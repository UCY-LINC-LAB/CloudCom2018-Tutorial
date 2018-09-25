#!/usr/bin/env bash

# Comment the following line in production -- Warning it clears all docker images and containers
docker stop $(docker ps -a -q) && docker rm $(docker ps -a -q) && docker rmi $(docker images -q) -f

mvn clean install package


docker-compose up -d



#watch -n 1 'docker ps -a'


