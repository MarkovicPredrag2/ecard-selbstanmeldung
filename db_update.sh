#!/bin/bash

mysql -u root -p lokalePatientenDB < ./db/ordination.sql

echo -e "\e[92m\e[1mSDatenbank updated!"
