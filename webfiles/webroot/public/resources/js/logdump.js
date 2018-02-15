function logdump(logart) {
  $.ajax({
    url: '/role/arzt/logdata',
    data: { logart: this.logart },
    success: function loadDataIntoView(logdata) {
      // Table to log into
      var logTable = document.getElementById(logart);

      // Clear table before dumping log
      while (logTable.firstChild) {
			  logTable.removeChild(logTable.firstChild);
			}

      alert("Hello");
      // Load data into table
      logTable.payload.forEach(function (log) {
        document.getElementById("logArtEins").innerHTML +=
          "<tr>" +
              "<td>" + log.id + "</td>" +
              "<td>2018-02-10</td>" +
              "<td>1234567890</td>" +
              "<td>Max</td>" +
              "<td>Mustermann</td>" +
          "</tr>"
      });
    }
  });
}


/*"<li class='list' onclick='requestPatientData(this)' id='" + person.svnr + "'>" +
  "<i class='fa " + iconResolver(person.grund) + " fa-5x' aria-hidden='true' style='float:left; margin: 0 15px 0 0;'></i>" +
  "<i class='fa fa-bars fa-3x' aria-hidden='true' style='float:right; padding-top:27.5px'></i>" +
  "<h3 style='text-align: left'>" + person.grund + "</h3>" +
  "<p>".concat(person.anrede, " ", person.nachname, " ", person.vorname, " (", person.alter, " Jahre alt)","</p>") +
"</li>";
*/
