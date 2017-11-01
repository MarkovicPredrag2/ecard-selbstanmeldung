# ecard-selbstanmeldung
Repo of the five4u diplomproject team. This repository contains files for the Ecard-Selbstanmeldungs software and it's iPad App.

## Setup
In order to work, you need to have a few programs installed on your device.

**npm and Node**: https://nodejs.org/en/download/



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

```
git config --global user.name "Your Name Here"
git config --global user.email "your_email@youremail.com"

git init
git status
git add FILENAME
git commit -m “COMMIT-NAME”
git remote add origin ONLINE REPO URL
git remote -v
git pull origin BRANCHNAME
git push

//The new boston tutorial:
git --version	-> Displays the git version
Config account with email and password:
	git config --global user.name "Markovic Predrag" -> Name configuration
	git config --global user.email "markovic.predrag.gs@gmail.com" -> Email configuration
git config --list	-> Displays the content of the git config file
git config [option]	-> Displays the value of the given key-value entry (e.g: git config user.name)
git --help		-> Displays the most used commands in git + short desciription of these
git help [command]	-> Displays a profound description of the given command (e.g: git help commit)
git init		-> Creates a .git hidden folder in the actual folder which initializes the repository
git add .		-> Adds all the files and folders to the scope of git. (It adds it to the so called "staging" area)
git commit -m "This is my commit description"		-> Makes a commit (snapshot) of the actual state of the concluded files of in the repsitory.

git log			-> Display the commit history stack of the actual project
git log --author="NAME"		-> Filters the commits according to the author
git status		-> Displays the actual stage of the staging mode. (Always recommended before commiting anything)
git diff		-> Compares all the files in the working space with the repository files.
get diff --staged		-> Compares all the files in the staging area with the repository.
git rm third.txt	-> Removes the file from the working directory.
git mv second.txt pudding.txt		-> Renames a file from "second.txt" to "pudding.txt"
git mv [FILE] [FOLDER]			-> Moves the file to another location
git commit -am "TEXT"			-> Force-moves every file in the working directory into a repository-commit with skipping the staging. (should be only used if simple corrections were made in files, not when files got removed)
git checkout -- [FILE]			-> Replaces the specified file with a file from the latest commit. Used for restoring the state.
git reset HEAD [FILE] 			-> Removes the given file off the staging area back to the working area
git checkout [COMMIT-GUID] -- [FILE]	-> Replaces the given file with the file of the given commit
git remote add [ALIAS] [HTTP-REPO-LINK]	-> Connects the local .git repo with the online repo. From now on it is possible to use the alias instead of the url to push files to the online repo.

git remote				-> Displays the alias for the online-repo-url

GitHub vocs:
push : Commiting to the online repo (GitHub)
fetch: Downloading from the online repo (GitHub)
fork: Copys the project and adds it to the repo-list. Its possible to participate from now on.
pull-request: Request for merging a branch to the master.
clone: Copys the actual state of the project in the branch to the local system.
star: This option bookmarks a project.
watch: Watching a project adds it to your notification stack.

git push -u [REPOALIAS] master		-> Pushes the latest local commit to the master
git pull origin [BRANCH]		-> Fetches the latest version of the specified branch
git clone -b <branch> <remote_repo>	-> Clones the specified branch.
git branch				-> Lists all the available branches
git checkout [BRANCH]			-> Switch the branch
git checkout -b [BRANCH]		-> Create a new branch
```

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
