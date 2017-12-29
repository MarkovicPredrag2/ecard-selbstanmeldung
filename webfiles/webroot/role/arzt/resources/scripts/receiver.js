//	Checkt, ob der Browser die Klasse EventSource kennt
//	Die EventSource Klasse wird von fast allen modernen
//	Browsern unterstützt (exklusive Explorer und Edge)
if(typeof(EventSource) !== "undefined") {
	//	Definiert die URI als Ressource
	var source = new EventSource("/role/arzt/sse");
	source.onmessage = function(event) {
	//	Wird ausgeführt, sobald eine Nachricht angekommen ist
	//	Dieser Block updated die Tabelle (DOM-Manipulation über JavaScript)
	var patInfos = JSON.parse(event.data);
	document.getElementById("patTable").innerHTML += 
		"<tr>" +
			"<td>" + patInfos.prioritaet 	+ "</td>" +
			"<td>" + patInfos.svnr 				+ "</td>" +
			"<td>" + patInfos.nachname 		+ "</td>" +
			"<td>" + patInfos.vorname 		+ "</td>" +
			"<td>" + patInfos.alter 			+ "</td>" +
			"<td>" + patInfos.grund 			+ "</td>" +
		"</tr>";
	};
} else {
		document.getElementById("result").innerHTML = "Sorry, your browser does not support server-sent events...";
}
