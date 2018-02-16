//-----------	Imports	-----------

const spawn = require('child_process').spawn;
const events = require('events');

//-----------	Private Fields -----------

// These flags correspond to the GINA util inputs.
const GET_CARD_READER_STATUS 	= 'R';
const GET_PATIENT_INFORMATION = 'P';

//-----------	Public Functions -----------

module.exports.listen = (ipaddress, cardReader, oCardReader, pin, interval, test = false) => {
	/*
		 	Invoke subprocess via java.
			The util params are the url
			of the GINA and a cardReader address.
	*/
	const ginaProc = spawn('java',
		['-jar', './lib/ginaconn.jar', `https://${ipaddress}`, cardReader, oCardReader, pin]);

	//	Set the encoding for the std-Pipes.
	ginaProc.stdout.setEncoding('utf8');
	ginaProc.stderr.setEncoding('utf8');

	//	Create instance of an eventemitter
	//	to emit events.
	const eventEmitter = new events.EventEmitter();

	//	Set the timeout value for the gina request in ms.
	const timeout = interval;

	//	Initialize the plug flag.
	var cardCanBePlugged = true;

	//	Writing to the subprocess.
	ginaProc.stdout.on('data', (ginaData) => {
	  var requestData = JSON.parse(ginaData);
		if (requestData.init) {
			// Indicates a successfull connection
			// to all three services (base, sas, vdas).
			eventEmitter.emit('connection');
		}
		if (cardCanBePlugged) {
			//	Is it a patient info response?
			if (requestData.person) {
				console.log('Karte gesteckt, Patient wurde gefunden!');
				//	If so, card can be unplugged now.
				cardCanBePlugged = false;
				//	Invoke callback and return patient data.
				eventEmitter.emit('data', requestData);
				// 	Ask if card is unplugged.
				askGina(ginaProc, GET_CARD_READER_STATUS, timeout);
			} else if (requestData.cardinfo) {
				//	Is the card valid and plugged?
				if (requestData.cardinfo.ecardinfo.state == 'STATUS_READER_PRESENT') {
					//	Check, if the card is a valid 'e-card'.
					if (requestData.cardinfo.ecardinfo.type == 'schulungs-e-card (e-card für die Schulung)') {
						//	If the card is valid, ask for information.
						askGina(ginaProc, GET_PATIENT_INFORMATION, timeout);
					} else {
						//	If not, return error to callback.
						eventEmitter.emit('error', 'Ungueltige Karte!');
						askGina(ginaProc, GET_CARD_READER_STATUS, timeout);
					}
				} else {
					console.log('Warte auf das Stecken einer Karte');
					//	If not, ask until a valid card is plugged.
					askGina(ginaProc, GET_CARD_READER_STATUS, timeout);
				}
			}
		} else {
			if (requestData.cardinfo) {
				console.log('Karte kann nun ausgesteckt werden.');
				//	Is the card unplugged?
				//cardCanBePlugged = (requestData.cardinfo.state == 'STATUS_READER_EMPTY');
				cardCanBePlugged = false;
				//	Ask until the card got unplugged.
				askGina(ginaProc, GET_CARD_READER_STATUS, timeout);
			}
		}
	});

	//	Logging errors from the GINA process.
	ginaProc.stderr.on('data', 	(err) => eventEmitter.emit('error', err));
	ginaProc.stderr.on('error', (err) => eventEmitter.emit('procerror', err));
	ginaProc.stdin.on('error', 	(err) => eventEmitter.emit('error', err));
	ginaProc.stdout.on('error', (err) => eventEmitter.emit('procerror', err));


	//	Initial writing to the process.
	//	This is only used once, so it can enter
	//	the "callback circulation".
	askGina(ginaProc, GET_CARD_READER_STATUS, timeout);

	//	Return event-emitter to invoke callbacks.
	return eventEmitter;
}

//-----------	Private Functions -----------

//	Wrapper function to write to the GINA stdin.
function askGina(proc, flag, timeout) {
	setTimeout(() => {
		proc.stdin.write(flag);
	}, timeout);
}
