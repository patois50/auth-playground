CREATE DATABASE IF NOT EXISTS auth_service;

USE auth_service;

CREATE TABLE IF NOT EXISTS user (
    username VARCHAR(255),
    password VARCHAR(255),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255),
    primary key (username)
);
