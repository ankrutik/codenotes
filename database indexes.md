#database/bestpractices #performance

Consider creating indexes on table columns which have large amounts of data that will need to be filtered thru an application query.

Order in which the filters appear in the query and the order in which the columns are defined in the index definition matters.

Separate indexes will take up space, consider design to avoid unnecessary indexes.

Index creation will cause temporary performance impact. Possible locks on tables as well. Look up documentation for option to create the indexes concurrently. Usually there will be a trade-off of time. For example, see [creating indexes concurrently in postgresdb](https://www.postgresql.org/docs/current/sql-createindex.html#SQL-CREATEINDEX-CONCURRENTLY)

**Also check if you need to partition the table or archive data that is very old.**

