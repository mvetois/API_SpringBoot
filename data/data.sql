CREATE DATABASE IF NOT EXISTS APP;

USE APP;

CREATE TABLE users(
                      id int NOT NULL AUTO_INCREMENT,
                      name VARCHAR(255) NOT NULL,
                      email VARCHAR(255) NOT NULL,
                      PRIMARY KEY(id)
);

INSERT INTO users(name, email) VALUES ("Jean", "Jean@email.com");