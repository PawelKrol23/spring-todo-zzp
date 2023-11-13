--liquibase formatted sql
--changeset DeerDancer5:9

ALTER TABLE categories add owner serial;
UPDATE categories SET owner = 1 WHERE id < 6;

