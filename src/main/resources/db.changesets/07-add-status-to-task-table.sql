--liquibase formatted sql
--changeset DeerDancer5:7


UPDATE TASKS SET status = 3 WHERE id < 4;