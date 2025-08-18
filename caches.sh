#!/bin/bash

updateCaches () {
    if [ -d "$1" ]; then
        cd $1
        docker compose pull
        ./mvnw clean package
        ./mvnw dependency:sources
        ./mvnw dependency:resolve -Dclassifier=javadoc
        ./mvnw dependency:resolve -Dclassifier=sources
        cd ..
    fi
}

for project in isdb isdb-count isdb-web isdb-audit; do
        updateCaches $project
done
