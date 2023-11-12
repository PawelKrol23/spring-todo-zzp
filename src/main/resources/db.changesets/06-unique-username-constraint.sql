--liquibase formatted sql
--changeset DeerDancer5:6

ALTER TABLE USERS ADD CONSTRAINT unique_username_constraint UNIQUE (username);
