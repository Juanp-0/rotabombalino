#!/bin/bash
set -e  

./gradlew build

aws s3 cp build/libs/ s3://minecraft-server-src/src/ --recursive