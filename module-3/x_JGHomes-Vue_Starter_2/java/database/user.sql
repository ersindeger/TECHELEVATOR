-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER jghomes_owner
WITH PASSWORD 'postgres1';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO jghomes_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO jghomes_owner;

CREATE USER jghomes_appuser
WITH PASSWORD 'postgres1';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO jghomes_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO jghomes_appuser;
