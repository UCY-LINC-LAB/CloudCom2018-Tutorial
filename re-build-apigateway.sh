#!/usr/bin/env bash

mvn clean install package

docker-compose stop apigateway
docker-compose rm apigateway

docker volume prune -f

docker-compose up -d --no-deps --build apigateway



