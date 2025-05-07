CREATE DATABASE springbootdb;
\c springbootdb;
CREATE EXTENSION "uuid-ossp";
INSERT INTO person (id, name) VALUES (uuid_generate_v4(), 'Paul Randall');
INSERT INTO person (id, name) VALUES (uuid_generate_v4(), 'John Just');
