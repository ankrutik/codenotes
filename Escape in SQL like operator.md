#databases #oracle 

When using underscore in operand to `like` keyword, you need to specify the escape character explicitly. 

```sql
select * from some_table where URL_IDENTIFIER like '%\_%' ESCAPE '\';

```


