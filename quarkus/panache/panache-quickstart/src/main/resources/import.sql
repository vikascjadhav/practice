-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
insert into Person (id, fname,lname,age) values(nextval('hibernate_sequence'), 'V1', 'J1', 30.6);
insert into Person (id, fname,lname,age) values(nextval('hibernate_sequence'), 'V2', 'J3', 31.6);
insert into Person (id, fname,lname,age) values(nextval('hibernate_sequence'), 'V3', 'J3', 32.6);
insert into Person (id, fname,lname,age) values(nextval('hibernate_sequence'), 'V4', 'J3', 32.6);