INSERT INTO department (dp_id, dp_name) VALUES (1, 'IT');
INSERT INTO department (dp_id, dp_name) VALUES (2, 'HR');

INSERT INTO employee (em_id, em_name, em_date_of_birth, em_salary, em_permanent, em_dp_id) VALUES (1, 'John', '1995-10-10', 50000.00, 1, 1);
INSERT INTO employee (em_id, em_name, em_date_of_birth, em_salary, em_permanent, em_dp_id) VALUES (2, 'Jane', '1998-12-12', 60000.00, 1, 1);
INSERT INTO employee (em_id, em_name, em_date_of_birth, em_salary, em_permanent, em_dp_id) VALUES (3, 'Bob', '1992-02-02', 40000.00, 0, 2);

INSERT INTO skill (sk_id, sk_name) VALUES (1, 'Java');
INSERT INTO skill (sk_id, sk_name) VALUES (2, 'Spring Boot');
INSERT INTO skill (sk_id, sk_name) VALUES (3, 'React');

INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 2);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 2);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 3);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (3, 1);
