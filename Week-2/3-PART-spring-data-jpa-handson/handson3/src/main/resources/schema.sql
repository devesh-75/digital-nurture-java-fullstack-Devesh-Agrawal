DROP TABLE IF EXISTS attempt_option;
DROP TABLE IF EXISTS attempt_question;
DROP TABLE IF EXISTS attempt;
DROP TABLE IF EXISTS options;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS "user";

CREATE TABLE "user" (
    us_id INT PRIMARY KEY AUTO_INCREMENT,
    us_name VARCHAR(45) NOT NULL,
    us_email VARCHAR(45) NOT NULL
);

CREATE TABLE question (
    qt_id INT PRIMARY KEY AUTO_INCREMENT,
    qt_text VARCHAR(150) NOT NULL
);

CREATE TABLE options (
    op_id INT PRIMARY KEY AUTO_INCREMENT,
    op_qt_id INT,
    op_score DOUBLE,
    op_text VARCHAR(100) NOT NULL,
    FOREIGN KEY (op_qt_id) REFERENCES question(qt_id)
);

CREATE TABLE attempt (
    at_id INT PRIMARY KEY AUTO_INCREMENT,
    at_date DATE,
    at_us_id INT,
    at_score DOUBLE,
    FOREIGN KEY (at_us_id) REFERENCES "user"(us_id)
);

CREATE TABLE attempt_question (
    aq_id INT PRIMARY KEY AUTO_INCREMENT,
    aq_at_id INT,
    aq_qt_id INT,
    FOREIGN KEY (aq_at_id) REFERENCES attempt(at_id),
    FOREIGN KEY (aq_qt_id) REFERENCES question(qt_id)
);

CREATE TABLE attempt_option (
    ao_id INT PRIMARY KEY AUTO_INCREMENT,
    ao_op_id INT,
    ao_aq_id INT,
    ao_selected BIT,
    FOREIGN KEY (ao_op_id) REFERENCES options(op_id),
    FOREIGN KEY (ao_aq_id) REFERENCES attempt_question(aq_id)
);
