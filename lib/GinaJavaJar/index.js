const spawn = require('child_process').spawn;

const cardShouldBePlugged 		= true;
const GET_CARD_READER_STATUS 	= 'R';
const GET_PATIENT_INFORMATION = 'P'; 
const GET_CARD_TYPE 					= 'T';

async function GinaListener(ipaddress, cardReader, callback) {
//	Invoke subprocess
	const ginaProc = await spawn('java', ['-jar', './lib/ginaconn.jar', `https://${ipaddress}/base/15`, cardReader]);
//	Set the encoding for the std-Pipes
	ginaProc.stdout.setEncoding('utf8');
	ginaProc.stderr.setEncoding('utf8');
//	Writing to the subprocess
	ginaProc.stdout.on('data', (patient) => {
		callback(patient, undefined);
		setTimeout(() => {
			ginaProc.stdin.write(GET_PATIENT_INFORMATION);
		}, 1000);
	});
//	Logging errors from GINA
	ginaProc.stderr.on('data', 	(err) => callback(undefined, err));
	ginaProc.stderr.on('error', (err) => callback(undefined, err));
	ginaProc.stdin.on('error', 	(err) => callback(undefined, err));
	ginaProc.stdout.on('error', (err) => callback(undefined, err));
	
//	Initial writing to the process
	setTimeout(() => {
		ginaProc.stdin.write(GET_CARD_READER_STATUS);
	}, 1000);
}

GinaListener('10.196.2.18', 'Test-03 (02:94:93)', (patient, error) => {
	if (error) {
		console.log(error);
	} else {
		console.log('Patientdata: ' + patient);
	}
});
