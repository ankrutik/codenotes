#sql/ms #docker 

```bash title:'Pull MSSQL Docker Image'
docker pull mcr.microsoft.com/mssql/server:2022-latest
```


```bash title:'Run MSSQL Server Instance'
docker run --net=host -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=system" -e "MSSQL_PID=tenant" -p 1433:1433 -d mssql-server-mlservices
```

`-p 1433:1433` might not be needed