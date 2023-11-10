--liquibase formatted sql
--changeset DeerDancer5:4
CREATE TABLE TASKS(
    id serial PRIMARY KEY,
    summary VARCHAR(40) NOT NULL,
    description VARCHAR(100),
    start_date DATE,
    end_date DATE,
    category serial,
    owner serial
);

INSERT INTO TASKS (id, summary, description, start_date, end_date, category,owner) VALUES
                (1,'Leg workout','Do not skip','2023-11-20','2023-11-20',2,1);

INSERT INTO TASKS (id, summary, description, start_date, end_date, category,owner) VALUES
    (2,'Chest workout','','2023-11-22','2023-11-22',2,2);


INSERT INTO TASKS (id, summary, description, start_date, end_date, category,owner) VALUES
    (3,'Meeting with sales','','2023-11-10','2023-11-10',1,3);
