#!/usr/bin/env bash

mvn clean install

docker-compose stop ratings
docker-compose rm -f ratings

docker volume prune -f

docker-compose up -d --no-deps --build ratings



