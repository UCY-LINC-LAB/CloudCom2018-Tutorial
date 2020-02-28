#!/usr/bin/env bash

#mvn clean install package
#
#docker-compose stop product
#docker-compose rm -f product
#
#docker volume prune -f
#
#docker-compose up -d --no-deps --build product
#
#
#


pushd cloudcom-frontend
npm install
ng build --prod
popd


docker-compose stop front-end
docker-compose rm -f front-end

docker volume prune -f

docker-compose up -d --no-deps --build front-end