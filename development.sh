#!/bin/sh

# run the gradle kotlin builds

./gradlew -t -c -P -b :bootJar &

# run the spring boot application

./gradlew bootRun -PskipDownload=true