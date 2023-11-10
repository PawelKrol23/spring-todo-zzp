--liquibase formatted sql
--changeset DeerDancer5:4

CREATE TABLE STATUSES (
    id serial PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    displayName VARCHAR(20),
    owner serial
);

INSERT INTO STATUSES (id, name, displayName, owner) VALUES ('1','In progress','in_progress',1);
INSERT INTO STATUSES (id, name, displayName, owner) VALUES ('2','Canceled','canceled',2);
INSERT INTO STATUSES (id, name, displayName, owner) VALUES ('3','Not started','not_started',3);

