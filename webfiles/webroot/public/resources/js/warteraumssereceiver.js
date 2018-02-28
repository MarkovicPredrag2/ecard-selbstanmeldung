if( typeof(EventSource) !== "undefined" ) {

	var source = new EventSource("/role/arzt/warteraumsse");

	source.onmessage = function(event) {
    // Parse the JSON data
  	var patient = JSON.parse(event.data);

    // Call-in animation
    $(".patientGreen")
			.css('color', 'green')
			.css('font-size', 80)
			.html("&nbsp " + patient.titel + " " + patient.nachname + " " + patient.vorname)
			.fadeIn(1000)
			.delay(10000)
			.fadeOut(1000);

    // Voice speak library
    setTimeout(responsiveVoice.speak("Nächster Patient: ".concat(patient.vorname, " ", patient.nachname), "Deutsch Female"), 1000);
	}
} else {
		alert("Browser unterstützt kein SSE. Patientendaten können somit nicht empfangen werden. Benutzen sie bitte einen anderen Browser.");
}
