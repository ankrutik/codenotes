#databases #oracle #troubleshoot

For those that are using Oracle 19c on their machines, you may get this error when modifying/working with views  
```
ORA-38824: A CREATE OR REPLACE command may not change the EDITIONABLE property of an existing object.
```
``
**As a temporary workaround**, use the `editionable` keyword in your `create or replace` statements.

For example,  
```sql
Create or replace view SOME_VIEW AS
```
becomes  
```sql
Create or replace editionable view SOME_VIEW AS
```

Seems Edition-Based Redefinition(EBR) is on by default 18c onwards.
Please share if anyone knows a better solution.


## Links
[https://docs.oracle.com/en/database/oracle/oracle-database/18/adfns/editions.html#GUID-4B118A0F-60D8-4F38-99EF-F7645037CA21](https://docs.oracle.com/en/database/oracle/oracle-database/18/adfns/editions.html#GUID-4B118A0F-60D8-4F38-99EF-F7645037CA21)

