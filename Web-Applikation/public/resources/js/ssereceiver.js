//	Checkt, ob der Browser die Klasse EventSource kennt
//	Die EventSource Klasse wird von fast allen modernen
//	Browsern unterstützt (exklusive Explorer und Edge)
if( typeof(EventSource) !== "undefined" ) {

	//	Definiert die URI als Ressource
	var source = new EventSource("/sse");
  // Sobald ein Event erhalten wurde, wird diese Funktion
  // samt der Daten im Parameter ausgeführt.
	source.onmessage = function(event) {
    // Dataformat adding:
    // ==================
    // {
    //   replace: false,
    //   svnr: "5047030699",
    //   anrede: "Hr.",
    //   nachname: "Neugberger",
    //   vorname: "Christopher",
    //   alter: 18,
    //   grund: "Untersuchung"
    // }
		// Dataformat replacing:
		// {
		// 	replace: true
		// 	payload: [
		// 		...
		// 	]
		// }
  	var patient = JSON.parse(event.data);
		if (patient.replace) {
			// Replace the entire list
      // The replace flag is set by the server
      // if an error occured during the sorting process.

      // Remove children
			var patientlist = document.getElementById("patientlist");
			while (patientlist.firstChild) {
			  patientlist.removeChild(patientlist.firstChild);
			}

      // Add the children from the server
			patient.payload.forEach(function (person) {
				document.getElementById("patientlist").innerHTML +=
		  		"<li class='list' onclick='requestPatientData(this)' id='" + person.svnr + "'>" +
		  			"<i class='fa " + iconResolver(person.grund) + " fa-5x' aria-hidden='true' style='float:left; margin: 0 15px 0 0;'></i>" +
		  			"<i class='fa fa-bars fa-3x' aria-hidden='true' style='float:right; padding-top:27.5px'></i>" +
		  			"<h3 style='text-align: left'>" + person.grund + "</h3>" +
		        "<p>".concat(person.anrede, " ", person.nachname, " ", person.vorname, " (", person.alter, " Jahre alt)","</p>") +
		  		"</li>";
			});

		} else {
      // Otherwise, add a new patient to the list
			document.getElementById("patientlist").innerHTML +=
	  		"<li class='list' onclick='requestPatientData(this)' id='" + patient.svnr + "'>" +
	  			"<i class='fa " + iconResolver(patient.grund) + " fa-5x' aria-hidden='true' style='float:left; margin: 0 15px 0 0;'></i>" +
	  			"<i class='fa fa-bars fa-3x' aria-hidden='true' style='float:right; padding-top:27.5px'></i>" +
	  			"<h3 style='text-align: left'>" + patient.grund + "</h3>" +
	        "<p>".concat(patient.anrede, " ", patient.nachname, " ", patient.vorname, " (", patient.alter, " Jahre alt)","</p>") +
	  		"</li>";
		}
	};
} else {
		alert("Browser doesn't support SSE");
}

function iconResolver(reason) {
  var icon = "";

  switch (reason) {
    case "Untersuchung":
      icon = "fa-stethoscope";
      break;
    case "Rezept":
      icon = "fa-file-text-o";
      break;
    case "AUM":
      icon = "fa-briefcase";
      break;
  }

  return icon;
}
