#!/bin/bash

echo "Database name:"
read database
mysql -u root -p $database < ./db/ordination.sql

echo -e "\e[92m\e[1mSDatenbank updated!"
