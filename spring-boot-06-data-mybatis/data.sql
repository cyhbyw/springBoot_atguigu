
DROP TABLE IF EXISTS department;

CREATE TABLE IF NOT EXISTS department (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `department_name` VARCHAR(255)
);

INSERT INTO department(department_name) VALUES ('RD');
INSERT INTO department(department_name) VALUES ('HR');