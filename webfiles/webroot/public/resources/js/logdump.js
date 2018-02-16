var datenTabelle;

function logdump(logart) {
  $.ajax({
    url: '/role/arzt/logdata',
    data: { "logart": logart },
    success: function loadDataIntoView(logdata) {

      // TODO: Read through API to delete/add rows
      // NOTE: https://datatables.net/reference/api/

      // Table elements
      var logtable = document.getElementById('logtable');
      var tablebody = document.getElementById('tablebody');
      var tableHead = document.getElementById('tabletop');

      // Clear table body before dumping log
      while (tablebody.firstChild) {
			  tablebody.removeChild(tablebody.firstChild);
			}

      // Clear table head before dumping log
      while (tableHead.firstChild) {
			  tableHead.removeChild(tableHead.firstChild);
			}

      // General header
      var generalHeader =
        "<th>Id</th>" +
        "<th>Datum</th>";

      // Choose the right table with the right method to load
      switch (logart) {
        case "1": // Neuer Patient
          // Dataformat:
          // {
          //   sozialversicherungsnummer: 1234 010101,
          //   vorname: max,
          //   nachnamne: musterpatien
          // }
          // Load table head
          break;
        case "2": // Patientendaten Änderung
        //ToDo;Änderungsquerry anpassen (im Moment kann nur ein Datenfeld bearbeitet werden!!!!1!!!11!!!elf!!)
          // Dataformat:
          // {
          //   sozialversicherungsnummer: 1234 010101,
          //   vorname: max,
          //   nachname musterpatien_neu,
          //   änderungen: array
          // }
          // Load table head
          break;
        case "3": // Patienteneinschreibung
          // Dataformat:
          // {
          //   sozialversicherungsnummer: 1234 010101,
          //   vorname: max,
          //   nachnamne: musterpatien,
          //   grund: rezept
          // }
          // Load table head
          break;
        case "4": // Wartelistenaufruf
          // Dataformat:
          // {
          //   sozialversicherungsnummer: 1234 010101,
          //   vorname: max,
          //   nachnamne: musterpatien,
          //   arzt: dr. hofbauer,
          //   (raum: ordination 1)
          // }
          // Load table head
          break;
        case "5": // Webapplikationsanmeldung (Benutzer)
          // Dataformat:
          // {
          //   username: muncan,
          // }
          // Load data into head
          tableHead.innerHTML += generalHeader + "<th>Username</th>";

          // Load data into body
          logdata.forEach(function (log) {
            var payload = JSON.parse(log.daten);

            tablebody.innerHTML +=
              "<tr>" +
                "<td>" + log.id + "</td>" +
                "<td>" + log.timestamp + "</td>" +
                "<td>" + payload.username + "</td>" +
              "</tr>";
          });
          break;
      }

      $('#logtable').DataTable();

    }
  });
}
