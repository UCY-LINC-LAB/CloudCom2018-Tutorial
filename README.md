# Microservice Tutorial

## Description

## Prerequisites

## General

* Clone this project
* cd into the project folder
* run build-run-all.sh --> CAUTION! For now this script deletes all images and containers.
* wait 4-5 minutes all services will be up and running --> need to improve on this time. 

|Service | URL|
|--------|----|
| Product| http://localhost:38082/products|
| Reviews| http://localhost:28082/reviews|
| Rating | http://localhost:18082/ratings|


---

Mpost probably I will make use of the "choreography" approach rather than the "orchestrator" approach. 
Choreography --> Strong Decoupling

Netflix OSS
* Eureka Service Discovery
* Hystrix Circuit Breaking
* Zuul Api Gateway
 