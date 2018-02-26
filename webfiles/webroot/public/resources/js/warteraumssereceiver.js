if( typeof(EventSource) !== "undefined" ) {

	var source = new EventSource("/role/arzt/warteraumsse");

	source.onmessage = function(event) {
    // Parse the JSON data
  	var patient = JSON.parse(event.data);

    // TODO: Implement voice callout and animation
    // NOTE: For Stöckl & Seifert

    $(".patientGreen").css('color', 'green');

    setTimeout(responsiveVoice.speak("Nächster Patient: ".concat(patient.vorname, " ", patient.nachname), "Deutsch Female"), 1000);
	}
} else {
		alert("Browser unterstützt kein SSE. Patientendaten können somit nicht empfangen werden. Benutzen sie bitte einen anderen Browser.");
}
