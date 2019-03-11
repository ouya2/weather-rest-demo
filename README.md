# weather-rest-demo
A simple weather window API

This is a sample Java / Maven / Spring Boot (version 1.5.16) application that can be used as a starter for 
creating a microservice complete with built-in health check, metrics.

## Pre-requisite:

To use this app, you need to register an API Key on http://openweathermap.org/ service. Update API url and key in src/main/resources/application.yml

## How to Run 

This application is packaged as a war which has Tomcat 8 embedded. You run it using the ```mvn clean spring-boot:run``` command.

* Clone this repository 
* Make sure you are using JDK 1.8 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean install```

## How to use
* Access the API URL using http://localhost:8080/

### To view Swagger 2 API docs

Run the server and browse to http://localhost:8080/swagger-ui.html 

## Technology Summary
