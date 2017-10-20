# ecard-selbstanmeldung
Repo of the five4u diplomproject team. This repository contains files for the Ecard-Selbstanmeldungs software and it's iPad App.

## Database

### User roles
Users for testing purposes along with their pw's and roles.
	
| Username      	| Password		| Role		|
| ---------------------	| --------------------- | ------------- |
| drmuncan  		| fliegeimohr  		| arzt		|
| haustanteraphael 	| 1raphaelhatrecht	| nutzer	|

### 256bit AES Key
Key for the password encryption and decryption in the database.

```
x0M9ErVpTVi98cWffCs1NRjQ9QixVq9X
```

## Important CLI commands
Noteworthy CLI commands when working with the native CLI.

### MySQL Commands

| Command       | Description	|
| ------------- | ------------- |
| sudo systemctl start mysql  | Starts Mysql  |
| sudo systemctl restart mysql.service  | Restarts the Mysql  |
| sudo systemctl stop mysql.service  | Stops Mysql  |
| sudo mysql_secure_installation  | For Mysql configurations  |
| systemctl status mysql.service  | Checking the Mysql status  |
| mysql -u **YourUser** -p  | Login into Mysql with username and password (User **root** recommended) |
| mysqldump -u **YourUser** -p **YourDatabaseName** > **WantedSQLFile.sql**  | Exporting a DB from mysql into a .sql file  |
| mysql -u **YourUser** -p **YourDatabaseName** < **WantedSQLFile.sql**  | Importing a DB into mysql  |
| mysql -u **YourUser** -p -h **RemoteServerIP** **DatabaseName**  | Remote control access to a Mysql on a server  |

### Node/Npm Commands

| Command       | Description	|
| ------------- | ------------- |
| npm install | Install all dependencies required to start the server (from package.json) |
| node server.js | Command to start the server |

### Git Basic Commands

| Command       | Description	|
| ------------- | ------------- |
| git init | Initializes local git repo in the current folder |

## Important SQL Statements
Useful commands within the mysql shell.

| Command       | Description	|
| ------------- | ------------- |
| \q  | Leave Mysql  |
| \h  | Display help  |
| SHOW DATABASES;  | Shows the available DBs in the DBMS  |
| CREATE DATABASE **DatabaseName**;  | Creates a DB with the given name  |
| DROP DATABASE **DatabaseName**;  | Deletes the database  |
| USE **DatabaseName**;  | Uses the database  |
| SHOW tables;  | Displays all tables in the database  |
| DESC **TABLENAME**; | Displays the columns of the database |
