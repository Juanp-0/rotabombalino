#!/bin/bash
set -e
echo "Running remote configuration script"
cd ~/minecraft-server/mods
rm -rf ./*
aws s3 cp s3://minecraft-server-src/src/ ./ --recursive
cd ..
nohup java -Xmx2G -Xms1G -jar forge-1.21.1-52.1.1-shim.jar > server.log 2>&1 &
