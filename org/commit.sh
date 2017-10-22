#!/bin/bash

echo "Committext: "
read committext
echo "Branch: "
read branch
git pull $(git remote) master
git add $(pwd)/..
git commit -m "$committext"
git push -u $(git remote) $branch

echo -e "\e[92m\e[1mVorgang abgeschlossen!"
