-- Database: escola

-- DROP DATABASE IF EXISTS escola;

CREATE DATABASE escola
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'en-GB'
    LC_CTYPE = 'en-GB'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

GRANT TEMPORARY, CONNECT ON DATABASE escola TO PUBLIC;

GRANT ALL ON DATABASE escola TO postgres;