# ecard-selbstanmeldung
Repo of the fiveforu diplomproject team. This repository contains files for the Ecard-Selbstanmeldungs software.

## Usage description

### Database

#### Read and write operations

Note: The URL at the end of the commands might vary, so you eventually have to specify a different url on which the server runs.
You also have to change the payload in the DM command.
In order to test a simple DM and DQ operation, paste the following commands into your common CLI:
**To get all users:** curl -d '{"key":"p*mlm@o=@B{>ff*|{z8.[$NUt6k>"}' -H "Content-Type: application/json" -X GET http://localhost:8080

**To add an user (change the payload before):** curl -d '{"key":"p*mlm@o=@B{>ff*|{z8.[$NUt6k>", "payload":{"svnr":"5043030698", "vorname":"Dawid", "nachname":"Muncan", "alter":"3", "addresse":"Zentrum der Welt", "hn":"503", "stiege":"3", "plz":"1020", "ort":"Wien"}}' -H "Content-Type: application/json" -X POST http://localhost:8080/

#### User roles

Here are the test users along with their usernames, passwords and roles:
Ärzte:
	drmuncan fliegeimohr arzt
Nutzer:
	haustanteraphael 1raphaelhatrecht nutzer

### Keys

Important keys and users:

DB:
	username: root
	password: v2tJ)Jjt=NS!F<%
	256bit AES Key: x0M9ErVpTVi98cWffCs1NRjQ9QixVq9X

Important CLI commands:
=======================
sudo systemctl start mysql >>	Starts the DB
sudo systemctl restart mysql.service >>	Restarts the DB
sudo systemctl stop mysql.service >>	Stops the DB
sudo mysql_secure_installation >>	For DB configurations
systemctl status mysql.service >>	Checking the DB status
mysql -u root -p	>>	Enter the mysql DBMS with password
mysqldump -u YourUser -p YourDatabaseName > wantedsqlfile.sql	>>	Exporting a DB from mysql into a .sql file
mysql -u username -p [DB_NAME] < file.sql	>>	Importing a DB into mysql
mysql -u {username} -p{password} -h {remote server ip} {DB name}	>>	Remote control access to a db
mysql -u root -p'v2tJ)Jjt=NS!F<%' -h https://acc5448c.ngrok.io lokalePatientenDB

Important SQL Statements:
=========================
SHOW DATABASES;	>>	Shows the available DBs in the DBMS
CREATE DATABASE database name;	>>	Creates a DB with the given name
DROP DATABASE database name;
USE [DB_NAME];
SHOW tables; 
