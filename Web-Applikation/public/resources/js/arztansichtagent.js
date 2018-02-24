// SSE Receiver function
//	Checkt, ob der Browser die Klasse EventSource kennt
//	Die EventSource Klasse wird von fast allen modernen
//	Browsern unterstützt (exklusive Explorer und Edge)
if( typeof(EventSource) !== "undefined" ) {

	//	Definiert die URI als Ressource
	var source = new EventSource("/sse");
  // Sobald ein Event erhalten wurde, wird diese Funktion
  // samt der Daten im Parameter ausgeführt.
	source.onmessage = function(event) {

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

// Focus the first patient on page load
function focusPatientOnStartup() {
  if (document.getElementById('patientlist').firstChild) {
    document.getElementById('patientlist').firstChild.className += " active";
  }
}

// Function to add "focus-selection"
// behviour to the patient-elements in the list
function focusPatientOnSelect(dom) {

  // Get the patients
  var patients = document.getElementById('patientlist').children;

  // Unfocus all the other patients in the list
  for (var i = 0; i < patients.length; i++) {
    patients[i].className.replace(" active", "");
  }

  // Check, if the callin-button should be enabled or disabled
  // This button is only enabled, if the selected element
  // is either in behandlungs-status or the first element
  dom.disabled = false; document.getElementById('patientlist').firstElementChild.getAttribute('id') == dom.getAttribute('id') ||

  }

  // Check, if the behandlung
  // Get Patient data for the patient
  requestPatientData(dom);
}

// Function to resolve the reasons into icons
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

// Function to call in the patient
function callInPatient(svnr) {
  alert("Selected svnr: " + svnr);
  // First off, request the url
  $.post("/role/arzt/callin", { "svnr": svnr },
    function(data, status) {
      alert("Server status:" + status);
      if (status == 200) {
        // If successful, give the corresponding patient-element a green border
        // to indicate a succsessful callin of the selected patient.
        $('#' + svnr).css("border", "2px solid green");
      } else {
        // Otherwise, log an error
        console.error("Couldn't retrieve patient data");
      }
    });
}

// Function to rank the warteliste within the persistance layer
function rankPatientBefore(svnrbelow) {
  var patients = document.getElementById("patientlist").children;
  for(var n = 0; n < patients.length; n++) {
    if (patients[n].id == svnrbelow) {
      //  Get the svnr above.
      //  If the patient got
      //  moved to the last position,
      //  set svnr.before to 0.
      var ranking = {};
      if ((patients.length - 1) < (n + 1)) {
        // Set before to 0
        // ranking.from = patients[n - 1].id;
        // ranking.before = patients[n].id;
        ranking.from = patients[n].id;
        ranking.before = "0";
      } else {
        ranking.from = patients[n].id;
        ranking.before = patients[n + 1].id;
      }
      return ranking;
    }
  }
  return {};
}

// Get patient data for the selected patient
function requestPatientData(dom) {
  $.post("/role/arzt/patientdata", { "svnr": JSON.stringify(dom.getAttribute('id')) },
    function(data, status) {
      alert(status);
      if (status == 200) {
        var patient = data[0];
        $("#h_vorname").html(patient.vorname);
        $("#t_nachname").html(patient.nachname);
        $("#t_grund").html(patient.grund);
      } else {
        console.error("Couldn't retrieve patient data");
      }
    });
}
