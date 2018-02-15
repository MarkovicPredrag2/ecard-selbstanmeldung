#!/bin/bash

echo "Committext: "
read committext
echo "Branch: "
read branch
echo "Database root login:"
mysqldump -u root -p --routines ordination > ./db/ordination.sql
git pull $(git remote) master
git checkout $branch
git add .
git commit -m "$committext"
git push -u $(git remote) $branch

echo -e "\e[92m\e[1mCommit abgeschlossen!"
