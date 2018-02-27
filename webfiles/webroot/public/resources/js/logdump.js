// Data Table Object
var logTable;


function initDataTable() {
  logTable = $('#logtable').DataTable();
}

// Function to dump the log into the table
function logdump(logart) {
  $.ajax({
    url: '/role/arzt/logdata',
    data: { "logart": logart },
    success: function loadDataIntoView(logdata) {
      // NOTE: https://datatables.net/reference/api/
      var logColumns;
      var logUnits = [];
      var logTableContent;

      // Destory total table with true and re-init
      logTable.destroy(true);

      // Choose the right table with the right method to load
      switch (logart) {
        case "1": // Neuer Patient
          // Dataformat:
          // {
          //   sozialversicherungsnummer: 1234 010101,
          //   vorname: max,
          //   nachnamne: musterpatien
          // }
          // Load template into log
          logTableContent =
            "<table id='logtable' class='display' cellspacing='0' width='100%'>" +
              "<thead>" +
                "<tr id='tabletop'>" +
                  "<th>ID</th>" +
                  "<th>Datum</th>" +
                  "<th>SVNR</th>" +
                  "<th>Vorname</th>" +
                  "<th>Nachname</th>" +
                "</tr>" +
              "</thead>" +
              "<tbody id='tablebody'>" +
              "</tbody>" +
            "</table>";

          // Init table-columns
          logColumns = [
            { data: 'ID' },
            { data: 'Datum' },
            { data: 'SVNR' },
            { data: 'Vorname' },
            { data: 'Nachname' }
          ];

          // Init table-rows
          logdata.forEach(function (log) {
            var payload = JSON.parse(log.daten);
            logUnits.push({
              "ID": log.id,
              "Datum": log.timestamp,
              "SVNR": payload.sozialversicherungsnummer,
              "Vorname": payload.vorname,
              "Nachname": payload.nachname
            });
          });
          break;
        case "2": // Patientendaten Änderung
          // Dataformat:
          // {
          //   sozialversicherungsnummer: 1234 010101,
          //   vorname: max,
          //   nachname musterpatien_neu,
          //   änderungen: array
          // }
          // Load template into log
          logTableContent =
            "<table id='logtable' class='display' cellspacing='0' width='100%'>" +
              "<thead>" +
                "<tr id='tabletop'>" +
                  "<th>ID</th>" +
                  "<th>Datum</th>" +
                  "<th>SVNR</th>" +
                  "<th>Vorname</th>" +
                  "<th>Nachname</th>" +
                  "<th>Aenderungen</th>" +
                "</tr>" +
              "</thead>" +
              "<tbody id='tablebody'>" +
              "</tbody>" +
            "</table>";

          // Init table-columns
          logColumns = [
            { data: 'ID' },
            { data: 'Datum' },
            { data: 'SVNR' },
            { data: 'Vorname' },
            { data: 'Nachname' },
            { data: 'Aenderungen' }
          ];

          // Init table-rows
          logdata.forEach(function (log) {
            var payload = JSON.parse(log.daten);
            var aenderungen = "";
            if (payload.änderungen.length != 0) {
              aenderungen += "'" + payload.änderungen[0].alt + "' geändert zu '" + payload.änderungen[0].neu + "'" + ",";
              for (var i = 1; i < payload.änderungen.length; i++) {
                  aenderung += "\n" + "'" + payload.änderungen[i].alt + "' geändert zu '" + payload.änderungen[i].neu + "'" + ",";
              }
            }
            logUnits.push({
              "ID": log.id,
              "Datum": log.timestamp,
              "SVNR": payload.sozialversicherungsnummer,
              "Vorname": payload.vorname,
              "Nachname": payload.nachname,
              "Aenderungen": aenderungen
            });
          });
          break;
        case "3": // Patienteneinschreibung
          logTableContent =
            "<table id='logtable' class='display' cellspacing='0' width='100%'>" +
              "<thead>" +
                "<tr id='tabletop'>" +
                  "<th>ID</th>" +
                  "<th>Datum</th>" +
                  "<th>SVNR</th>" +
                  "<th>Vorname</th>" +
                  "<th>Nachname</th>" +
                  "<th>Grund</th>" +
                "</tr>" +
              "</thead>" +
              "<tbody id='tablebody'>" +
              "</tbody>" +
            "</table>";

          // Init table-columns
          logColumns = [
            { data: 'ID' },
            { data: 'Datum' },
            { data: 'SVNR' },
            { data: 'Vorname' },
            { data: 'Nachname' },
            { data: 'Grund' }
          ];

          // Init table-rows
          logdata.forEach(function (log) {
            var payload = JSON.parse(log.daten);
            logUnits.push({
              "ID": log.id,
              "Datum": log.timestamp,
              "SVNR": payload.svnr,
              "Vorname": payload.vorname,
              "Nachname": payload.nachname,
              "Grund": payload.grund
            });
          });
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
          // Init table template
          logTableContent =
            "<table id='logtable' class='display' cellspacing='0' width='100%'>" +
              "<thead>" +
                "<tr id='tabletop'>" +
                  "<th>ID</th>" +
                  "<th>Datum</th>" +
                  "<th>SVNR</th>" +
                  "<th>Vorname</th>" +
                  "<th>Nachname</th>" +
                  "<th>Arzt</th>" +
                "</tr>" +
              "</thead>" +
              "<tbody id='tablebody'>" +
              "</tbody>" +
            "</table>";

          // Init table-columns
          logColumns = [
            { data: 'ID' },
            { data: 'Datum' },
            { data: 'SVNR' },
            { data: 'Vorname' },
            { data: 'Nachname' },
            { data: 'Arzt' }
          ];

          // Init table-rows
          logdata.forEach(function (log) {
            var payload = JSON.parse(log.daten);
            logUnits.push({
              "ID": log.id,
              "Datum": log.timestamp,
              "SVNR": payload.sozialversicherungsnummer,
              "Vorname": payload.vorname,
              "Nachname": payload.nachname,
              "Arzt": payload.arzt
            });
          });
          break;
        case "5": // Webapplikationsanmeldung (Benutzer)
          // Load template into log
          logTableContent =
            "<table id='logtable' class='display' cellspacing='0' width='100%'>" +
              "<thead>" +
                "<tr id='tabletop'>" +
                  "<th>ID</th>" +
                  "<th>Datum</th>" +
                  "<th>Username</th>" +
                "</tr>" +
              "</thead>" +
              "<tbody id='tablebody'>" +
              "</tbody>" +
            "</table>";

          // Init table-columns
          logColumns = [
            { data: 'ID' },
            { data: 'Datum' },
            { data: 'Username' }
          ];

          // Init table-rows
          logdata.forEach(function (log) {
            var payload = JSON.parse(log.daten);
            logUnits.push({
              "ID": log.id,
              "Datum": log.timestamp,
              "Username": payload.username
            });
          });
          break;
      }

      // Load table template into logcontainer
      document.getElementById('logtablecontainer').innerHTML = logTableContent;

      // Re-initialize table
      logTable = $('#logtable').DataTable({
        "data": logUnits,
        "columns" : logColumns
      });
    }
  });
}
