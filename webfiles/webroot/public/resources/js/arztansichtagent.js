// Patientlist DOM
var patientList = document.getElementById('patientlist');
// Callin Button DOM
var callInButton = document.getElementById('callin');
// Dismiss Button DOM
var dismissButton = document.getElementById('dismiss');

// SSE Receiver function
//	Checkt, ob der Browser die Klasse EventSource kennt
//	Die EventSource Klasse wird von fast allen modernen
//	Browsern unterstützt (exklusive Explorer und Edge)
if( typeof(EventSource) !== "undefined" ) {

	//	Definiert die URI als Ressource
	var source = new EventSource("/role/arzt/patientsse");

  // Sobald ein Event erhalten wurde, wird diese Funktion
  // samt der Daten im Parameter ausgeführt.
	source.onmessage = function(event) {
    // Parse the JSON data
  	var patient = JSON.parse(event.data);
    // Otherwise, add a new patient to the list
		patientList.innerHTML +=
	  	"<li class='list' onclick='focusPatientOnSelect(this)' id='" + patient.svnr + "'>" +
	  		"<i class='fa " + iconResolver(patient.grundid) + " fa-5x' aria-hidden='true' style='float:left; margin: 0 15px 0 0;'></i>" +
	  		"<i class='fa fa-bars fa-3x' aria-hidden='true' style='float:right; padding-top:27.5px'></i>" +
	  		"<h3 style='text-align: left;'>" + patient.grund + "</h3>" +
	      "<p>".concat(patient.geschlecht == "M" ? "Hr." : "Fr.", " ", (patient.titel == null ? "" : patient.titel), " ", patient.nachname, " ", patient.vorname, " (", patient.alter, " Jahre alt)","</p>") +
	  	"</li>";

    // If the patient is the first in the list,
    // focus him and refresh the button state.
		if (patientList.firstElementChild.getAttribute('id') == patient.svnr) {
			focusPatientOnSelect(patientList.firstElementChild);
		}
	};
} else {
	alert("Browser unterstützt kein SSE. Patientendaten können somit nicht empfangen werden. Benutzen sie bitte einen anderen Browser.");
}

// Focus the first patient on page load
function focusPatientOnStartup() {
  if (patientList.firstChild) {
		focusPatientOnSelect(patientList.firstElementChild);

    // If the first patient is in behandlung,
    // disable the entire list.
		if (patientList.firstElementChild.classList.contains('behandlung')) {
			$("ul.example").sortable("disable");
		}
  }
}

// Function to add "focus-selection"
// behviour to the patient-elements in the list
function focusPatientOnSelect(dom) {
	// Get the patients
  var patients = patientList.childNodes;

  // Unfocus all the other patients in the list
  for (var i = 0; i < patients.length; i++) {
    patients[i].classList.remove("active");
  }

  // Set the selected element to active
	dom.classList.add("active");

  // Set buttons clickable depending on the
  // selected item.
	setButtonsClickable(dom);

	// Get Patient data for the patient
  requestPatientData(dom);
}

// Function to dismiss the selected patient
function dismissPatient() {
	var selectedElement = document.getElementsByClassName("active")[0];
  // First off, dismiss the patient in the persistance layer
	$.post("/role/arzt/dismiss", { "svnr": selectedElement.getAttribute('id') },
    function(data, status) {
      if (status == "success") {
        // On success, delete the current element
        selectedElement.remove();
        // Eventually, select the new first element underneath if he exists
				if (patientList.firstChild) {
					focusPatientOnSelect(patientList.firstElementChild);
				} else {
          // Clear the display,
          // if there ain't a patient anymore
					$("#h_name").html("Kein Patient in der Warteliste.");
					$("#h_svnr").html("");
					$("#h_versicherung").html("");
	        $("#h_grund").html("");
					$("#h_geburtsdatum").html("");
					$("#h_adresse").html("");
					$("#h_email").html("");
					$("#h_telefon").html("");

          // And disable all the buttons
					callInButton.classList.add("w3-disabled");
					dismissButton.classList.add("w3-disabled");
				}

				// And enable the list again
				$("ul.example").sortable("enable");
      } else {
        console.error("Couldn't dismiss patient");
        // Reset patient table
				resetPatientTable(data);
      }
    }
	);
}

// Function to call-in the selected patient
function callInPatient() {
	var selectedElement = document.getElementsByClassName("active")[0];
	// First off, call in the patient in the persistance layer
	$.post("/role/arzt/callin", { "svnr": selectedElement.getAttribute('id') },
    function(data, status) {
      if (status == "success") {
        // Mark element as 'behandlung'
				document.getElementsByClassName("active")[0].classList.add("behandlung");
        // Refresh button state
				setButtonsClickable(selectedElement);
        // Disable the entire list
				$("ul.example").sortable("disable");
      } else {
        console.error("Couldn't call in patient");

				// Reset patient table
				resetPatientTable(data);
      }
    }
	);
}

// Function to resolve the reasons into icons
function iconResolver(reason) {
  var icon = "";

  switch (reason) {
    case 2:
      icon = "fa-stethoscope";
      break;
    case 1:
      icon = "fa-file-text-o";
      break;
    case 3:
      icon = "fa-briefcase";
      break;
  }

  return icon;
}

// Function to rank the warteliste within the persistance layer
function rankPatientBefore(svnrbelow) {
  var patients = patientList.children;
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
  $.post("/role/arzt/patientdata", { "svnr": dom.getAttribute('id') },
    function(data, status) {
      if (status == "success") {
        var patient = data;

        // Replace all null's with -
				for (var key in patient) {
				  if (patient.hasOwnProperty(key)) {
				    patient[key] = patient[key] == null ? "n.A." : patient[key];
				  }
				}

        // Load the data into the fields
        $("#h_name").html((patient.titel == "n.A." ? "" : patient.titel).concat(" ", patient.vorname, " ", patient.nachname, " - ", (patient.geschlecht == 'M' ? 'Männlich' : 'Weiblich')));
				$("#h_svnr").html(String(patient.svnr).concat(" - ", patient.verskuerzel));
				$("#h_versicherung").html(patient.verslang);
        $("#h_grund").html("Grund: ".concat(patient.grund));
				$("#h_geburtsdatum").html("Geburtsdatum: ".concat(patient.geburtsdatum, " - ", patient.age, " Jahre"));
				$("#h_adresse").html("Adresse: ".concat(patient.plz, " ", patient.ort, ", ", patient.strasse, " ", patient.hausnummer));
				$("#h_email").html("Email: ".concat(patient.email));
				$("#h_telefon").html("Telefon: ".concat(patient.telefonnummer));

      } else {
        console.error("Couldn't retrieve patient data");
      }
    }
	);
}

// Function to reset the patient table
function resetPatientTable(patients) {
	// Reset the entire list if an error occured
	var patientlist = patientList;

  // Remove all patients from the list
	while (patientlist.firstChild) {
		patientlist.removeChild(patientlist.firstChild);
	}

	// Add all the patients again
	patients.payload.forEach(function (person) {
		// TODO: Ask, if the patient is in behandlung, to add the behandlungs class
		patientlist.innerHTML +=
			"<li class='list " + (person.behandlung != null ? "behandlung" : "") + "' onclick='requestPatientData(this)' id='" + person.svnr + "'>" +
				"<i class='fa " + iconResolver(person.grundid) + " fa-5x' aria-hidden='true' style='float:left; margin: 0 15px 0 0;'></i>" +
				"<i class='fa fa-bars fa-3x' aria-hidden='true' style='float:right; padding-top:27.5px'></i>" +
				"<h3 style='text-align: left'>" + person.grund + "</h3>" +
				"<p>".concat(person.anrede, " ", person.nachname, " ", person.vorname, " (", person.alter, " Jahre alt)","</p>") +
			"</li>";
	});

  // Ask, if the first patient is in behandlung
  // to disable the entire list.
	if (patientList.firstElementChild.classList.contains('behandlung')) {
		$("ul.example").sortable("disable");
	}
}

function setButtonsClickable(dom) {
  // Callin-Button:
	// Check, if the callin-button should be enabled or disabled
  // This button is only enabled, if the selected element
  // is either in behandlungs-status or the first element
	if (patientList.firstElementChild.getAttribute('id') == dom.getAttribute('id') && !dom.classList.contains('behandlung')) {
		callInButton.classList.remove("w3-disabled");
	} else {
		callInButton.classList.add("w3-disabled");
	}

  // Dismiss-Button:
  // Check, if the dismiss-button should be enabled or disabled
  // The dismiss-button is only enabled, if the selected patient
  // is already in behandlung.
	if (dom.classList.contains('behandlung')) {
		dismissButton.classList.remove("w3-disabled");
	} else {
		dismissButton.classList.add("w3-disabled");
	}
}
