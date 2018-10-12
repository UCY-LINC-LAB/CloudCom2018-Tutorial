#!/usr/bin/env bash

# Comment the following line in production -- Warning it clears all docker images and containers
#docker stop $(docker ps -a -q) && docker rm $(docker ps -a -q) && docker rmi $(docker images -q) -f
#
mvn clean install package


docker-compose down --remove-orphans

#docker-compose rm -f

docker volume prune -f

docker-compose up -d --force-recreate --remove-orphans --build

docker-compose ps

#watch -n 1 'docker ps -a'


