--liquibase formatted sql
--changeset DeerDancer5:3
CREATE TABLE CATEGORIES (
     id serial PRIMARY KEY,
     name VARCHAR(20) NOT NULL,
     description VARCHAR(60)
);


INSERT INTO CATEGORIES (id, name,description) VALUES (1,'Meeting','');
INSERT INTO CATEGORIES (id, name,description) VALUES (2,'Workout','');