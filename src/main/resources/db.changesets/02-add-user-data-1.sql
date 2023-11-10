--liquibase formatted sql
--changeset DeerDancer5:2

INSERT INTO USERS (id,username,password,role) VALUES (1,'user1','user1','user');
INSERT INTO USERS (id,username,password,role) VALUES (2,'user2','user2','user');
INSERT INTO USERS (id,username,password,role) VALUES (3,'user3','user3','user');
INSERT INTO USERS (id,username,password,role) VALUES (4,'admin1','admin1','admin');
INSERT INTO USERS (id,username,password,role) VALUES (5,'admin2','admin2','admin');
