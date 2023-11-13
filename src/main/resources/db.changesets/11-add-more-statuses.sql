--liquibase formatted sql
--changeset DeerDancer5:10

INSERT INTO STATUSES (id, name, displayName, owner) VALUES ('4','Canceled','canceled',1);
INSERT INTO STATUSES (id, name, displayName, owner) VALUES ('5','Not started','not_started',1);
INSERT INTO STATUSES (id, name, displayName, owner) VALUES ('6','Completed','completed',1);

INSERT INTO STATUSES (id, name, displayName, owner) VALUES ('7','In progress','in_progress',2);
