# "Bookstore" Microservice Tutorial

## Description
The purpose of this repository is to provide all the necessary source code that accompanies the 
CloudCom 2018 Tutorial Session entitled *[Designing Scalable and Secure Microservices by Embracing DevOps-as-a-Service Offerngs.](https://www.slideshare.net/DemetrisTrihinas/designing-scalable-and-secure-microservices-by-embracing-devopsasaservice-offerings)* (Slideshare Presentation)





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

The Bookstore consists of the following distinct services.

* The **Books** service is responsible for handling product information regarding books such as title, author, description etc.

* The **Ratings** service is responsible for handling operations regarding a star rating system for products 

* The **Reviews** service is responsible for handling user based reviews
 
* The **Cart** service is responsible for handling operations regarding items to be purchased 
 
* The **Front-End** service is the user interface of the Bookstore App

* The **API Gateway** service is the central service of the deployment. It is responsible to authenticate requests, knows (with the assistance of the Load Balancer/Reverse Proxy) how is the underlying deployment, routes the request to the services and performs aggregations on data from various services.

In addition to the main services there are 2 additional infrastructure services that 

* The **Service Registry** service acts as a service catalog. Whenever a new service is added to the deployment, it automatically registers to the Consul Service Registry.
 
* The **Load Balancer/Reverse Proxy** service is responsible to route requests to the microservices deployed. It uses the Service Registry service to acquire knowledge of the deployed containers (what is their IP and what kind of services there are). It can be also configured to perform weighted routing which is useful for Canary Deployments, A/B Testing etc. 
  

## Key Technologies
### Spring Boot
[Spring Boot](https://spring.io/projects/spring-boot) is a java framework for building production-ready applications quickly and provides non-functional features such as:
* Embedded servers to deploy within JVM containers
* Application components are configured externally and automatically upon instantiation and runtime.
* Inherently distributed with tools for service discovery, security, API gateways, circuit breaking, message-passing, database integration.
* Open-source ecosystem with tons of smaller frameworks created (major contributors include Netflix, AWS, Spotify).

Spring Boot is based on [Spring Framework](https://spring.io/).

### Docker

[Docker](https://www.docker.com/) is a tool designed to make it easier to create, deploy, and run applications by using containers. Containers allow a developer to package up an application with all of the parts it needs, such as libraries and other dependencies, and ship it all out as one package. By doing so, thanks to the container, the developer can rest assured that the application will run on any other Linux machine regardless of any customized settings that machine might have that could differ from the machine used for writing and testing the code.

### Consul

[Consul](https://www.consul.io/) is a service mesh solution providing a full featured control plane with service discovery, configuration, and segmentation functionality. The key features of Consul are:

* **Service Discovery**: Clients of Consul can register a service, such as api or mysql, and other clients can use Consul to discover providers of a given service. Using either DNS or HTTP, applications can easily find the services they depend upon.
* **Health Checking**: Consul clients can provide any number of health checks, either associated with a given service ("is the webserver returning 200 OK"), or with the local node ("is memory utilization below 90%"). This information can be used by an operator to monitor cluster health, and it is used by the service discovery components to route traffic away from unhealthy hosts.
* **KV Store**: Applications can make use of Consul's hierarchical key/value store for any number of purposes, including dynamic configuration, feature flagging, coordination, leader election, and more. The simple HTTP API makes it easy to use.

Consul is designed to be friendly to both the DevOps community and application developers, making it perfect for modern, elastic infrastructures.

### Traefik

[Traefik](https://docs.traefik.io/) is a modern HTTP reverse proxy and load balancer that makes deploying microservices easy. 

### JWT
[JSON Web Token (JWT)](https://jwt.io/) is an open standard (RFC 7519) that defines a compact and self-contained way for securely transmitting information between parties as a JSON object. This information can be verified and trusted because it is digitally signed. 

## Prerequisites
To be able to run the source code of this repo you will need the following installed 

1. Java 8+ [For installation instructions click here](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
2. Maven [For installation instaructions click here](https://maven.apache.org/install.html)
3. Docker [For installation instaructions click here](https://docs.docker.com/install/#supported-platforms)
4. Docker Compose [For installation instaructions click here](https://docs.docker.com/compose/install/)

## How to run

* Clone this project 

`git clone https://github.com/UCY-LINC-LAB/CloudCom2018-Tutorial.git`

* `cd` into the cloned project folder

* run `./build-run-all.sh`
 
* wait 4-5 minutes all services will be up and running  

* to check the progress of the deployment run the command `docker ps -a`

* visit http://localhost:8080 to see the Traefik dashboard and registered services


## System Configuration - Local hostname   

In Unix/MAC based environments open the `/etc/hosts` file with sudo privileges and add the following lines on top of the file 

```
127.0.0.1	product.localhost
127.0.0.1	apigateway.localhost
127.0.0.1	localhost
```

In Windows environments you will need to edit the file `c:\WINDOWS\system32\drivers\etc\hosts`

### Production Configuration

In case you need to migrate similar configurations to production you will have to edit the `A Records` of your DNS to point to the `Public IP` of the Traefik.
In the Traefic configuration you will need to reconfigure the host names (front ends and backends) properly to match your domain

## Run

|Service | URL|
|--------|----|
| Front-End| http://product.localhost:38582/|
| API Gateway| http://apigateway.localhost/api/v1/all|
| Traefik Dashboard | http://localhost:8080|


---

