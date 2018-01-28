// Test-Stub fuer Vorzeige
function requestPatientData(patient) {
  var name = patient.children[2].innerHTML;
  var grund = patient.children[3].innerHTML;
  // Voller name
  document.getElementById('h_vorname').innerHTML = name;

  // Vor und Nachname
  document.getElementById('t_vorname').innerHTML = name.split(" ")[1];
  document.getElementById('t_nachname').innerHTML = name.split(" ")[2];

  // Grund
  document.getElementById('t_grund').innerHTML = grund.split(" ")[0];
}
