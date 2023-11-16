#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE USER dockerapp WITH PASSWORD 'sasa';
    ALTER USER dockerapp WITH SUPERUSER;
    CREATE DATABASE db_fraudes;
    GRANT ALL PRIVILEGES ON DATABASE db_fraudes TO dockerapp;
    GRANT ALL ON SCHEMA public TO dockerapp;
EOSQL
