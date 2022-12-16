-- **************************************************************
-- This script destroys the database and associated users
-- **************************************************************

-- The following line terminates any active connections to the database so that it can be destroyed
SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'jg_homes_capstone';

DROP DATABASE jg_homes_capstone;

DROP USER jghomes_owner;
DROP USER jghomes_appuser;
