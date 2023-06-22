# API_SpringBoot

## Description

This project is a simple API using Spring Boot with a docker MySQL database. The API is a simple CRUD of a user entity.
It was created to study Java and the Spring Boot framework.

## How to run the project

### Requirements

- Java 17
- Docker
- Maven

### Steps

1. Clone the repository
2. Run the command `docker-compose up` to start the database
3. Run the command `mvn spring-boot:run` to start the API

## Endpoints

Default URL: http://localhost:8080/api

| Method | Endpoint| Parameters | Description       |
| ------ | ------- | ---------- | ----------------- |
| GET    | /users  | -          | Get all users     |
| GET    | /user   | id         | Get a user by id  |
| POST   | /user   | -          | Create a new user |
| PUT    | /user   | id         | Update a user     |
| DELETE | /user   | id         | Delete a user     |

## JSON Body format

JSON body format for POST and PUT requests.

```json
{
  "name": "string",
  "email": "string",
}
```

## Database

The database is a docker MySQL database. All credentials are not secure and are only for study purposes.