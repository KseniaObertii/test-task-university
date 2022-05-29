INSERT INTO lector (id, name, surname, salary, degree) VALUES (1, 'Andrew', 'Pirogov', 1200, 'PROFESSOR');
INSERT INTO lector (id, name, surname, salary, degree) VALUES (2, 'Saloni', 'Livan', 300, 'ASSISTANT');
INSERT INTO lector (id, name, surname, salary, degree) VALUES (3, 'Ivan', 'Ivanov', 300, 'ASSISTANT');
INSERT INTO lector (id, name, surname, salary, degree) VALUES (4, 'Kate', 'Megonia', 900, 'ASSOCIATE_PROFESSOR');

INSERT INTO department (id, department_name, department_head_lector_id) VALUES (1, 'Biology', 1);
INSERT INTO department (id, department_name, department_head_lector_id) VALUES (2, 'Chemistry', 4);
INSERT INTO department (id, department_name) VALUES (3, 'Math');

INSERT INTO lectors_departments (lector_id, department_id) VALUES (1, 1);
INSERT INTO lectors_departments (lector_id, department_id) VALUES (1, 2);
INSERT INTO lectors_departments (lector_id, department_id) VALUES (2, 2);
INSERT INTO lectors_departments (lector_id, department_id) VALUES (3, 2);
INSERT INTO lectors_departments (lector_id, department_id) VALUES (4, 1);
INSERT INTO lectors_departments (lector_id, department_id) VALUES (4, 2);
