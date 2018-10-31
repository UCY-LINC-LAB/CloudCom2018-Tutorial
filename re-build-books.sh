#!/usr/bin/env bash

mvn clean install book

docker-compose stop book
docker-compose rm -f book

docker volume prune -f

docker-compose up -d --no-deps --build book



