# Spring JWT Demo

## Description
This is a demo project for an authentication service using JWTs.

I created it only for playing around with JWTs using Spring.

__It should not be used in production!__

## How to use

### Configure

### Build/Test

### Package

### Run

An accessible mysql db will be required for the service to connect to.
If you have docker installed you can use the provided `docker-compose.yml` to launch a MariaDb and PhpMyAdmin.

__Start local MariaDb:__  
`$ docker-compose up -d`

__Stop:__  
`$ docker-compose stop`


## API

```
actuator/health --> View the health of the application

actuator/info --> View information about the application

actuator --> 
```



## Links
[Implementing JWT Authorization and Authentication in Spring by Yigit Erinc](https://erinc.io/2020/08/02/spring-jwt-authentication-and-authorization)

[Simple Spring Boot app](https://spring.io/guides/gs/spring-boot/)

[How to fix Spring Boot application terminating immediately](https://www.techiedelight.com/spring-boot-app-shuts-down-automatically-at-startup/)