--liquibase formatted sql
--changeset DeerDancer5:7

ALTER TABLE TASKS ADD status serial;
UPDATE TASKS SET status = 3 WHERE id < 4;

