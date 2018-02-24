if( typeof(EventSource) !== "undefined" ) {

	var source = new EventSource("/role/arzt/warteraumsse");

	source.onmessage = function(event) {
    // Parse the JSON data
  	var patient = JSON.parse(event.data);

    // TODO: Implement voice callout and animation
    // NOTE: For Stöckl & Seifert

    $("#patientCalled").fadeOut();
    $("#patientCall").fadeIn(1000);
    $(".patientGreen").css('color', 'green');
    $(".patientdismiss").css("display","none");

    setTimeout(responsiveVoice.speak("Nächster Patient: ".concat(patient.titel, " ", patient.vorname, " ", patient.nachname), "Deutsch Female"), 15000);
	}
} else {
		alert("Browser unterstützt kein SSE. Patientendaten können somit nicht empfangen werden. Benutzen sie bitte einen anderen Browser.");
}
