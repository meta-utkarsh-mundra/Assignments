CREATE DATABASE employee_portal;

USE employee_portal;

CREATE TABLE employee(
emp_code VARCHAR(11) PRIMARY KEY NOT NULL,
first_name VARCHAR(100) NOT NULL,
last_name VARCHAR(100),
dob DATE NOT NULL,
gender VARCHAR(1) NOT NULL,
primary_contact_number VARCHAR(10),
secondary_contact_number VARCHAR(10),
email_id VARCHAR(100) NOT NULL,
skype_id VARCHAR(100),
profile_picture VARCHAR(512),
password VARCHAR(100),
enabled BOOLEAN DEFAULT true
);

CREATE TABLE job_title_master(
job_id INT AUTO_INCREMENT PRIMARY KEY ,
job_title VARCHAR(100) NOT NULL
);

CREATE TABLE user_role(
user_role_id INT PRIMARY KEY AUTO_INCREMENT,
user_name VARCHAR(200) NOT NULL,
role VARCHAR(50) NOT NULL    
);

CREATE TABLE skill_master(
skill_id INT PRIMARY KEY AUTO_INCREMENT,
skill_name VARCHAR(100) NOT NULL
);

CREATE TABLE employee_skill(
emp_skill_id INT PRIMARY KEY,
emp_code VARCHAR(11) NOT NULL,
skill_code INT NOT NULL,
FOREIGN KEY (emp_code)  REFERENCES employee(emp_code),
FOREIGN KEY (skill_code)  REFERENCES skill_master(skill_id)
);

CREATE TABLE project(
project_id INT PRIMARY KEY auto_increment,
project_name VARCHAR(100),
project_description VARCHAR(200) NOT NULL,
start_date DATE NOT NULL,
end_date DATE
);

CREATE TABLE address(
address_id INT PRIMARY KEY,
emp_code VARCHAR(11) NOT NULL,
add_line_1 VARCHAR(100) NOT NULL,
add_line_2 VARCHAR(100),
FOREIGN KEY (emp_code) REFERENCES employee(emp_code)
);

CREATE TABLE job_details(
 job_detail_id INT PRIMARY KEY AUTO_INCREMENT ,
 emp_code VARCHAR(11) NOT NULL,
 job_code INT NOT NULL,
 reproting_mgr VARCHAR(11),
 team_lead VARCHAR(11),
 curr_proj_id INT,
 FOREIGN KEY (emp_code) REFERENCES employee(emp_code),
 FOREIGN KEY (job_code) REFERENCES job_title_master(job_id),
 FOREIGN KEY (reproting_mgr) REFERENCES Employee(emp_code),
 FOREIGN KEY (team_lead) REFERENCES Employee(emp_code),
 FOREIGN KEY (curr_proj_id) REFERENCES project(project_id)
);

select * from skill_master;