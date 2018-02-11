function logdump(logart) {
  $.ajax({
    url: '/role/arzt/logdata',
    data: { logart: this.logart },
    success: function loadDataIntoView(logdata) {
      // TODO: Load data into table

      var patientlist = document.getElementById("patientlist");
      while (patientlist.firstChild) {
			  patientlist.removeChild(patientlist.firstChild);
			}
      var zeilenZahler = tblLog.rows.length;
      for(var i = zeilenZahler - 1; i>0; i--){
        tblLog
      }
    }
  })
}
