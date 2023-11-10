--liquibase formatted sql
--changeset DeerDancer5:1

CREATE TABLE USERS (
   id serial PRIMARY KEY,
   username VARCHAR(20) NOT NULL,
   password VARCHAR(30) NOT NULL,
   role VARCHAR(6) NOT NULL
);
