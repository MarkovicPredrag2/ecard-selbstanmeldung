#!/bin/bash

echo "Committext: "
read committext
git add ./../.
git commit -m "$committext"
echo "Branch: "
read branch
git push -u $(git remote) $branch

echo -e "\e[92m\e[1mVorgang abgeschlossen!"
