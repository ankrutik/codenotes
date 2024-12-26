#oracle #troubleshoot 

# Oracle doesn't let you login via system
Via Services.msc, kill the following services:
- Oracle ...TNSListener  
- OracleService...

Restart machine. 
Check Services.msc. The above services should start.
If services are stuck with status as "Stopping" even after restart...
```
# get PID
sc queryex OracleServiceQADB
# use PID to kill task
taskkill /f /pid 5536
```
Via Services.msc, manually start the following services:
- Oracle ...TNSListener  
- OracleService...


