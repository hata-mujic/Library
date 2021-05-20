DROP DATABASE IF EXISTS library;

CREATE DATABASE library;

USE library;

DROP TABLE IF EXISTS user;

CREATE TABLE user(
	first_name VARCHAR(255),
    last_name VARCHAR(255),
	user_name VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255),
    date_of_birth DATE,
    admin INT
);

INSERT INTO user
VALUES('Jhon', 'Doe', 'doe', '123456789', '1982-10-25', 1);

INSERT INTO user (first_name, last_name, user_name, password, date_of_birth)
VALUES('Sam', 'Smith', 'smith', '123456788', '1990-01-07');

