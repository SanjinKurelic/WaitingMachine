# Waiting Machine

Waiting machine is an application that enables the management of people waiting in line to ride the train. This is a demo application for Grafana and Prometheus presentation (ex. [JavaCro 22](https://2022autumn.javacro.hr/eng/Program/Grafana-and-Prometheus-monitoring-and-alerting)).

Implemented features are:
- Queue management: add a user to queue and fetch all users that are currently in queue
- Report endpoint for managers: this endpoint will either return success or an error
- Entrance scheduler: dummy counter of people who entered amusement park
- Queue scheduler which will put people to ride
- Overcrowded scheduler that checks if there is an overcrowded queue

## Getting started:

Waiting machine is written in Java using Spring Boot framework.

### Prerequisites

Running the project will require both Java and Docker (docker-compose) installed on the system:

- Java/JDK 17+
- Docker and docker compose

### Running

Run Docker compose command to start PostgreSQL database, Prometheus server and Grafana application:

```
docker-compose up
```

To start Waiting machine server, run Maven wrapper command which will build everything and serve web application
on **localhost:8080**

```
./mvnw spring-boot:run
```

### Calling endpoints

In this project there is Postman collection file: `WaitingMachine.postman_collection.json`. You can use it for playing with backend endpoints. 

## Monitoring and health check

Health check is implemented using Spring Actuator and exposed on actuator/health endpoint:

```
http://localhost:8080/actuator/health
```

Also, project is packed with Grafana and Prometheus monitoring tools. Both technologies are run from docker-compose and
already set-up for the project.

Prometheus can be accessed from: `http://localhost:19090`

Grafana can be accessed from: `http://localhost:13000` with username `admin` and password `admin`.
