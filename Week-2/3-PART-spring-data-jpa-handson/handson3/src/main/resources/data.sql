-- User
INSERT INTO "user" (us_id, us_name, us_email) VALUES (1, 'Alice', 'alice@gmail.com');

-- Questions
INSERT INTO question (qt_id, qt_text) VALUES (1, 'What is the extension of the hyper text markup language file?');
INSERT INTO question (qt_id, qt_text) VALUES (2, 'What is the maximum level of heading tag can be used in a HTML page?');
INSERT INTO question (qt_id, qt_text) VALUES (3, 'The HTML document itself begins with <html> and ends </html>. State True of False');
INSERT INTO question (qt_id, qt_text) VALUES (4, 'Choose the right option to store text value value in a variable');

-- Options for Question 1
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (1, 1, 0.0, '.xhtm');
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (2, 1, 0.0, '.ht');
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (3, 1, 1.0, '.html');
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (4, 1, 0.0, '.htmx');

-- Options for Question 2
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (5, 2, 0.0, '5');
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (6, 2, 0.0, '3');
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (7, 2, 0.0, '4');
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (8, 2, 1.0, '6');

-- Options for Question 3
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (9, 3, 0.0, 'false');
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (10, 3, 1.0, 'true');

-- Options for Question 4
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (11, 4, 0.5, '''John''');
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (12, 4, 0.0, 'John');
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (13, 4, 0.5, '"John"');
INSERT INTO options (op_id, op_qt_id, op_score, op_text) VALUES (14, 4, 0.0, '/John/');

-- Attempt
INSERT INTO attempt (at_id, at_date, at_us_id, at_score) VALUES (1, '2026-07-07', 1, 3.5);

-- Attempt Questions
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qt_id) VALUES (1, 1, 1);
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qt_id) VALUES (2, 1, 2);
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qt_id) VALUES (3, 1, 3);
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qt_id) VALUES (4, 1, 4);

-- Attempt Options (Selected)
-- Question 1: .html is selected (op_id = 3)
INSERT INTO attempt_option (ao_id, ao_op_id, ao_aq_id, ao_selected) VALUES (1, 1, 1, false);
INSERT INTO attempt_option (ao_id, ao_op_id, ao_aq_id, ao_selected) VALUES (2, 2, 1, false);
INSERT INTO attempt_option (ao_id, ao_op_id, ao_aq_id, ao_selected) VALUES (3, 3, 1, true);
INSERT INTO attempt_option (ao_id, ao_op_id, ao_aq_id, ao_selected) VALUES (4, 4, 1, false);

-- Question 2: 3 is selected (op_id = 6)
INSERT INTO attempt_option (ao_id, ao_op_id, ao_aq_id, ao_selected) VALUES (5, 5, 2, false);
INSERT INTO attempt_option (ao_id, ao_op_id, ao_aq_id, ao_selected) VALUES (6, 6, 2, true);
INSERT INTO attempt_option (ao_id, ao_op_id, ao_aq_id, ao_selected) VALUES (7, 7, 2, false);
INSERT INTO attempt_option (ao_id, ao_op_id, ao_aq_id, ao_selected) VALUES (8, 8, 2, false);

-- Question 3: true is selected (op_id = 10)
INSERT INTO attempt_option (ao_id, ao_op_id, ao_aq_id, ao_selected) VALUES (9, 9, 3, false);
INSERT INTO attempt_option (ao_id, ao_op_id, ao_aq_id, ao_selected) VALUES (10, 10, 3, true);

-- Question 4: 'John' is selected (op_id = 11)
INSERT INTO attempt_option (ao_id, ao_op_id, ao_aq_id, ao_selected) VALUES (11, 11, 4, true);
INSERT INTO attempt_option (ao_id, ao_op_id, ao_aq_id, ao_selected) VALUES (12, 12, 4, false);
INSERT INTO attempt_option (ao_id, ao_op_id, ao_aq_id, ao_selected) VALUES (13, 13, 4, false);
INSERT INTO attempt_option (ao_id, ao_op_id, ao_aq_id, ao_selected) VALUES (14, 14, 4, false);
