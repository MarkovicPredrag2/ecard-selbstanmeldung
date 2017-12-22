//-----------	Imports	-----------

const spawn = require('child_process').spawn;

//-----------	Private Fields -----------

// These flags correspond to the GINA util inputs.
const GET_CARD_READER_STATUS 	= 'R';
const GET_PATIENT_INFORMATION = 'P';

//-----------	Public Functions -----------

module.exports.listen = async (ipaddress, cardReader, callback) => {
	//	Invoke subprocess via java.
	//	The util params are the url
	//	of the GINA and a cardReader address.
	const ginaProc = await spawn('java',
		['-jar', './lib/ginaconn.jar', `https://${ipaddress}/base/15`, cardReader]);
		
	//	Set the encoding for the std-Pipes.
	ginaProc.stdout.setEncoding('utf8');
	ginaProc.stderr.setEncoding('utf8');
	
	//	Set the timeout value for the gina request in ms.
	const timeout = 400;
	
	//	Initialize the plug flag.
	var cardCanBePlugged = true;
	
	//	Writing to the subprocess.
	ginaProc.stdout.on('data', (ginaData) => {
	  var requestData = JSON.parse(ginaData);
		if (cardCanBePlugged) {
			//	Is it a patient info response?
			if (requestData.patient) {
				console.log('Patient wurde gefunden');
				//	If so, card can be unplugged now.
				cardCanBePlugged = false;
				//	Invoke callback and return patient data.
				callback(requestData.patient, undefined);
				// 	Ask if card is unplugged.
				askGina(ginaProc, GET_CARD_READER_STATUS, timeout);
			} else if (requestData.cardinfo) {
				//	Is the card valid and plugged?
				if (requestData.cardinfo.state == 'STATUS_READER_PRESENT') {
					//	Check, if the card is a valid 'e-card'.
					if (requestData.cardinfo.type == 'e-card') {
						//	If the card is valid, ask for information.
						askGina(ginaProc, GET_PATIENT_INFORMATION, timeout);
					} else {
						//	If not, return error to callback.
						callback(undefined, 'Ungueltige Karte!');
						askGina(ginaProc, GET_CARD_READER_STATUS, timeout);
					}
				} else {
					console.log('Karte steckt nicht!');
					//	If not, ask until a valid card is plugged.
					askGina(ginaProc, GET_CARD_READER_STATUS, timeout);
				}
			}
		} else {
			if (requestData.cardinfo) {
				console.log('Card unplugged?');
				//	Is the card unplugged?
				if (requestData.cardinfo.state == 'STATUS_READER_EMPTY') {
					//	If so, then the next card can be plugged.
					cardCanBePlugged = true;
				}
				//	Ask until the card got unplugged.
				askGina(ginaProc, GET_CARD_READER_STATUS, timeout);
			}
		}
	});
	
	//	Logging errors from the GINA process.
	ginaProc.stderr.on('data', 	(err) => callback(undefined, err));
	ginaProc.stderr.on('error', (err) => callback(undefined, err));
	ginaProc.stdin.on('error', 	(err) => callback(undefined, err));
	ginaProc.stdout.on('error', (err) => callback(undefined, err));
	
	//	Initial writing to the process.
	//	This is only used once, so it can enter
	//	the "callback circulation".
	askGina(ginaProc, GET_CARD_READER_STATUS, timeout);
}

//-----------	Private Functions -----------

//	Wrapper function to write to the GINA stdin.
function askGina(proc, flag, timeout) {
	setTimeout(() => {
		proc.stdin.write(flag);
	}, timeout);
}
