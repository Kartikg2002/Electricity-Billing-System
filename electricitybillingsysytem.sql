CREATE DATABASE electricity;
USE electricity;

CREATE TABLE signup(
account VARCHAR(50),
meternumber VARCHAR(50),
username VARCHAR(50),
name VARCHAR(50),
password VARCHAR(50)
);

CREATE TABLE newcustomer(
customername VARCHAR(50),
meternumber VARCHAR(50),
address VARCHAR(50),
city VARCHAR(50),
state VARCHAR(50),
email VARCHAR(50),
phoneno VARCHAR(50)
);

CREATE TABLE meterinformation(
meternumber VARCHAR(50),
meterlocation VARCHAR(50),
metertype VARCHAR(50),
phasecode VARCHAR(50),
billtype VARCHAR(50),
days VARCHAR(50)
);

CREATE TABLE bill(
meter_no VARCHAR(50),
month VARCHAR(50),
units VARCHAR(50),
totalbill VARCHAR(50),
status VARCHAR(50)
);

CREATE TABLE tax(
cost_per_unit VARCHAR(50),
meter_rent VARCHAR(50),
service_charge VARCHAR(50),
service_tax VARCHAR(50),
swacch_bharat_cess VARCHAR(50),
fixed_tax VARCHAR(50)
);

SELECT * FROM signup;
SELECT * FROM newcustomer;
SELECT * FROM meterinformation;
SELECT * FROM tax;
SELECT * FROM bill;