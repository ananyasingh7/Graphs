#!/bin/sh
git status
git add .
sleep 1
printf "Enter commit message: "
read message
git commit -m "$message"
sleep 1
git push origin master