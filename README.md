# "Bookstore" Microservice Tutorial

## Description
The purpose of this repository is to provide all the necessary source code that accompanies the 
CloudCom 2018 Tutorial Session entitled *[Designing Scalable and Secure Microservices by Embracing DevOps-as-a-Service Offerngs.](https://cyprusconferences.org/cloudcom2018/tutorials/)*

The main focus of the tutorial is to present practical challenges and benefits of adopting the microservice architecture paradigm though the *Bookstore App*.
The *Bookstore App* has been developed having the basic microservice principles in mind:
* Technology Heterogeneity
* Resilience
* Scalability
* Organizational Alignment
* Composability
* Service Discovery
* Configurability
* Ease of Deployment
* Monitoring, Logging
* Loose Coupling
* Replaceability
* Continuous Integration, Continuous Deployment

## Architecture
![Bookstore Microservice Architecture](assets/img/architecture.png)

The Bookstore consists of 5 distinct services.

* The **Books** service is responsible for handling 
* The **Ratings** service is responsible for handling 
* The **Reviews** service is responsible for handling 
* The **Cart** service is responsible for handling 
* The **Front-End** service is responsible for handling 
* The **API Gateway** service is responsible for handling 

In addition to the main services there are 2 additional infrastructure services that 

* The **Service Registry** service is responsible for handling 
* The **Front-End** service is responsible for handling 
  

## Key Technologies
* Spring Boot
* Docker
* Consul
* Traefik
* JWT

## Prerequisites
* Docker
* JAVA 8
* Maven
* Docker Compose

## How to run

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

