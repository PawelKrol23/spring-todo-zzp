--liquibase formatted sql
--changeset DeerDancer5:8

INSERT INTO CATEGORIES (id, name,description) VALUES (3,'School','Assignments, Study sessions etc.');
INSERT INTO CATEGORIES (id, name,description) VALUES (4,'Financial','');
INSERT INTO CATEGORIES (id, name,description) VALUES (5,'Health','');

UPDATE TASKS SET start_date = '2023-11-20 14:00:00' WHERE id = 1;


INSERT INTO TASKS (id, summary, description, start_date, end_date, category,owner,status) VALUES
    (4,'Java Assignment','Create to do app','2023-11-21 10:00:00','2023-11-21 13:00:00',3,1,3);

INSERT INTO TASKS (id, summary, description, start_date, end_date, category,owner,status) VALUES
    (5,'Full Body Workout','PRs incoming','2023-11-22 15:00:00','2023-11-22 17:00:00',2,1,3);

INSERT INTO TASKS (id, summary, description, start_date, end_date, category,owner,status) VALUES
    (6,'Coffee with Jerry','Catching up','2023-11-23 12:00:00','2023-11-23 13:00:00',1,1,2);
