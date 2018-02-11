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
