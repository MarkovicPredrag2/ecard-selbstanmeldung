# ecard-selbstanmeldung
Repo of the fiveforu diplomproject team. This repository contains files for the Ecard-Selbstanmeldungs software.

## Usage description

### Test database

Note: The URL at the end of the commands might vary, so you eventually have to specify a different url on which the server runs.
You also have to change the payload in the DM command.
In order to test a simple DM and DQ operation on the DB, paste the following commands into your common CLI:
	To get all users: curl -d '{"key":"p*mlm@o=@B{>ff*|{z8.[$NUt6k>"}' -H "Content-Type: application/json" -X GET http://localhost:8080
	
	To add an user (change the payload before): curl -d '{"key":"p*mlm@o=@B{>ff*|{z8.[$NUt6k>", "payload":{"svnr":"5043030698", "vorname":"Dawid", "nachname":"Muncan", "alter":"3", "addresse":"Zentrum der Welt", "hn":"503", "stiege":"3", "plz":"1020", "ort":"Wien"}}' -H "Content-Type: application/json" -X POST http://localhost:8080/


