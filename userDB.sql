CREATE DATABASE USERS_DB;

USE USERS_DB;

CREATE TABLE USER_AUTH (
USER_NAME VARCHAR(50),
USER_PASS VARCHAR(50),
USER_ACCESS INT DEFAULT 1
);
