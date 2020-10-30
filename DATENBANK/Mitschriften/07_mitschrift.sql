/* Mitarbeitername, Jobtitle */
select CONCAT(first_name, ' ', last_name), job_title FROM employees e
JOIN jobs j
ON e.job_id=j.job_id;

/*  Mitarbeiter die in Europa arbeiten */
SELECT last_name, region_name FROM employees e
JOIN departments d
ON e.department_id= d.department_id
JOIN locations l
ON d.location_id = l.location_id
JOIN countries c
ON l.country_id=c.country_id
JOIN regions r
ON c.region_id=r.region_id
WHERE region_name = 'Europe';

/* Liste Mitarbeiter von einem speziellen Manager - NAME: Steven King */
SELECT m.last_name as Manager, CONCAT(e.first_name, ' ', e.last_name) as Unterstellter FROM employees e
JOIN employees m
ON e.manager_id= m.employee_id
WHERE m.last_name = 'King';

/* UPDATE
   UPDATE table_name
   SET column1 = value1, column2 = value2, ....
   WHERE condition;
*/

SELECT * FROM countries;

UPDATE countries
SET region_id=1
WHERE country_name='Germany';

SELECT * FROM employees WHERE first_name='John';

UPDATE employees
SET first_name='John'
WHERE first_name='Steven' AND last_name='King';

#Alle mit einem Gehalt unter 6000 bekommen eine Gehaltserhöhung um 100 Euro
SELECT * FROM employees
WHERE salary < 6000;

UPDATE employees
SET salary = salary + 100
WHERE salary < 6000;

#Alle mit einem Gehalt über 6000 bekommen eine Gehaltserhöhung von 50 Euro
SELECT first_name, last_name, salary FROM employees
WHERE salary > 6000;

UPDATE employees
SET salary = salary + 50
WHERE salary > 6000;

#Die Telefonnummer von Bruce ändert sich auf: 590.444.4568
SELECT * FROM employees
WHERE first_name= 'Bruce';

UPDATE employees
SET phone_number ='590.444.4568'
WHERE first_name= 'Bruce';

#Matos wechselt den Job und arbeitet nun als Sales Representative (SA_REP)
SELECT * FROM employees
WHERE last_name = 'Matos';

SELECT * from jobs;

UPDATE employees
SET job_id = 'SA_REP'
WHERE last_name = 'Matos';

SELECT * FROM employees
JOIN jobs j
ON employees.job_id = j.job_id
WHERE last_name = 'Matos';

UPDATE employees
SET job_id =(SELECT job_id FROM jobs
WHERE job_title='Sales Representative')
WHERE last_name = 'Matos';

#Das min.Gehalt von allen Jobs erhöht sich um 500, jedoch nicht beim Präsidenten (AD_PRES)
# # UNGLEICH: <>    !=
SELECT * FROM jobs;

UPDATE jobs
SET min_salary = min_salary + 500
WHERE job_title <> 'President';

#Shelley Higgins (205) wird Manager von Contracting
SELECT * from departments;

UPDATE departments
SET manager_id = 205
WHERE department_name = 'Contracting';

UPDATE departments
SET manager_id = (SELECT employee_id FROM employees WHERE first_name='Shelley' AND last_name ='Higgins')
WHERE department_name = 'Contracting';

#Peter Vargas erhält zukünftig eine Provision von 15%
select * FROM employees;

UPDATE employees
SET commission_pct = 0.15
WHERE first_name='Peter' AND last_name = 'Vargas';

#Der Standort in Seattle ändert seine Adresse zu: 113 Cherry St
Select street_address, city FROM locations
WHERE city='Seattle';

UPDATE locations
SET street_address= '113 Cherry St'
WHERE city='Seattle';

/*
INSERT INTO & DELETE FROM

INSERT INTO tablename(att1, att2, att3) VALUES('value1', 'value2', 'value3')
DELETE FROM tablename WHERE ...
*/

SELECT * from locations;
SELECT * FROM countries;
INSERT INTO countries (country_id, country_name, region_id) VALUES ('AT', 'AUSTRIA', 1);

INSERT INTO locations (location_id, street_address, postal_code, city, state_province, country_id)
VALUES (2650, 'Holzstr. 15', '4020', 'Linz', 'OÖ' ,'AT'), (2700,'Holzstr. 15', '4020', 'Linz', 'OÖ' ,'AT');

DELETE FROM locations
WHERE location_id= 2700;

UPDATE locations
SET country_id = 'AT'
WHERE location_id=2600;

/* INSERT INTO employees
   MARTINA 207
   ANDREAS 208
   ALEKSANDER 209
   MICHAEL 210
   SIMON 211
*/

SELECT * from jobs;
SELECT * from departments;
SELECT * FROM employees;

INSERT INTO employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)
VALUES (207, 'Martina', 'Giselbrecht', 'MGISELBRECHT', '699.106.0201', '2020-10-30', 'IT_PROG', 50000.00, 0.20, 103, 60 );
INSERT INTO employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)
VALUES (208, 'Andreas', 'Maringer', 'andreaslmar2018@gmail.com', '0676 39 66 326', '2000-01-01', 'SA_MAN', 10000, 0.15, 205, 90);
INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)
VALUES (209,'Aleksandar','Kolic','kolicaleksandar90','0667764355147','2020-12-01','SA_REP',4600,null,null,null);

DELETE FROM employees
WHERE employee_id=289;

insert into employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)
values (211, 'John', 'Rambo', 'john.rambo@gmx.de', '111222333','1982-06-06', 'SA_MAN', 10, 0.9, 205, 110);

INSERT INTO employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)
VALUES (210, 'Max', 'Powers', 'MPWRS', '011.444.1844.479265', '1996-12-11', 'SA_MAN', 15000.00, 0.20, 100, 80);

/* CREATE TABLE
   ALTER TABLE
 */

CREATE DATABASE diary;
USE diary;

/*
DIARYUSER
user_id (PK) int auto_increment NOT NULL
username varchar(30) NOT NULL
birthdate date

ENTRY
entry_id (PK) int auto_increment NOT NULL
user_id (FK) int NOT NULL
text text
date date DEFAULT CURDATE()
*/

CREATE TABLE diaryuser (
    user_id int auto_increment NOT NULL,
    username varchar(30) NOT NULL,
    birthdate date,
    PRIMARY KEY (user_id)
);
#FOREIGN KEY MIT AUTOMATISCHER CONSTRAINTNAMENSGEBUNG
CREATE TABLE entry (
    entry_id int auto_increment NOT NULL,
    user_id int NOT NULL,
    text text,
    date date DEFAULT CURRENT_DATE,
    PRIMARY KEY (entry_id),
    FOREIGN KEY (user_id) REFERENCES diaryuser(user_id)
);
#FOREIGN KEY MIT SELBST GEWÄHLTEN NAMEN
CREATE TABLE entry (
    entry_id int auto_increment NOT NULL,
    user_id int NOT NULL,
    text text,
    date date DEFAULT CURRENT_DATE,
    PRIMARY KEY (entry_id),
    CONSTRAINT my_foreign_key FOREIGN KEY (user_id) REFERENCES diaryuser(user_id),
    INDEX (text)
);
#FOREIGNKEY IM NACHHINEIN HINZUFÜGEN
CREATE TABLE entry (
    entry_id int auto_increment NOT NULL,
    user_id int NOT NULL,
    text text,
    date date DEFAULT CURRENT_DATE,
    PRIMARY KEY (entry_id)
);

ALTER TABLE entry ADD FOREIGN KEY (user_id) REFERENCES diaryuser(user_id);

#TABELLE LÖSCHEN
DROP TABLE entry;



select * from diaryuser;
