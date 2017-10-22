#!/bin/bash

sudo apt-get update
sudo apt-get install mysql-server
mysql_secure_installation
mysql -u root -p lokalePatientenDB < ./db/ordination.sql
npm install
