#!/usr/bin/env bash

mvn clean install package

docker-compose stop product
docker-compose rm -f product

docker volume prune -f

docker-compose up -d --no-deps --build product



