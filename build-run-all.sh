#!/usr/bin/env bash

# Comment the following line in production -- Warning it clears all docker images and containers
docker stop $(docker ps -a -q) && docker rm $(docker ps -a -q) && docker rmi $(docker images -q)

docker-compose up -d

sleep 3

clear

mvn clean install package

