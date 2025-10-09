#postgres 

## Rollback
```sql title:'Savepoint with Rollback'
BEGIN;
    SAVEPOINT my_savepoint;
    INSERT INTO table1 VALUES (4);
    ROLLBACK TO SAVEPOINT my_savepoint;
COMMIT;
```

## Release
```sql title:'Savepoint with Release'
BEGIN;
    SAVEPOINT my_savepoint;
    INSERT INTO table1 VALUES (4);
    RELEASE SAVEPOINT my_savepoint;
COMMIT;
```

# references/see also
[Savepoint](https://www.postgresql.org/docs/current/sql-savepoint.html)
[Rollback to](https://www.postgresql.org/docs/current/sql-rollback-to.html)
[Rollback Prepared](https://www.postgresql.org/docs/current/sql-rollback-prepared.html)
[Rollback](https://www.postgresql.org/docs/current/sql-rollback.html)

