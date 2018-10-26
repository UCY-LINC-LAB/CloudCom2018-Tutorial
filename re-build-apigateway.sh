#!/usr/bin/env bash

mvn clean install package

docker-compose stop apigateway
docker-compose rm -f apigateway

docker volume prune -f

docker-compose up -d --no-deps --build apigateway



