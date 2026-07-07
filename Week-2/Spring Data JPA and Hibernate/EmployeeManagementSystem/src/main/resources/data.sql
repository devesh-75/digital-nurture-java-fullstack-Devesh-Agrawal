INSERT INTO department (id, name, created_by, created_date, last_modified_by, last_modified_date) 
VALUES 
(1, 'Engineering', 'System', CURRENT_TIMESTAMP, 'System', CURRENT_TIMESTAMP),
(2, 'HR', 'System', CURRENT_TIMESTAMP, 'System', CURRENT_TIMESTAMP);

INSERT INTO employee (id, name, email, department_id, created_by, created_date, last_modified_by, last_modified_date) 
VALUES 
(1, 'Alice Smith', 'alice.smith@example.com', 1, 'System', CURRENT_TIMESTAMP, 'System', CURRENT_TIMESTAMP),
(2, 'Bob Jones', 'bob.jones@example.com', 1, 'System', CURRENT_TIMESTAMP, 'System', CURRENT_TIMESTAMP),
(3, 'Charlie Brown', 'charlie.brown@example.com', 2, 'System', CURRENT_TIMESTAMP, 'System', CURRENT_TIMESTAMP);
