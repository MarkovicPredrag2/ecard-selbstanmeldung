#!/bin/bash
echo "Updating project from github ..."
git pull $(git remote) master
echo "Updating database ..."
echo "Type your root's database password:"
read -s PASSWORD
mysql -u root -p$PASSWORD -e "create database if not exists ordination" && mysql -u root -p$PASSWORD ordination < ./db/ordination.sql
echo -e "\e[92m\e[1mServer got updated on the newest version."
