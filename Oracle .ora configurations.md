#oracle #setup 

*Use Oracle Net Configuration Assistant to generate these files!* 
Configure them after.

## Location
```
<oracle_location>\network\admin
```
## tnsnames.ora
```
ORACLR_CONNECTION_DATA =
  (DESCRIPTION =
    (ADDRESS_LIST =
      (ADDRESS = (PROTOCOL = IPC)(KEY = EXTPROC1521))
    )
    (CONNECT_DATA =
      (SID = CLRExtProc)
      (PRESENTATION = RO)
    )
  )
```
## listener.ora
```
SID_LIST_LISTENER =
  (SID_LIST =
    (SID_DESC =
      (SID_NAME = CLRExtProc)
      (ORACLE_HOME = C:\oracle\db_home)
      (PROGRAM = extproc)
      (ENVS = "EXTPROC_DLLS=ONLY:C:\oracle\db_home\bin\oraclr19.dll")
    )
  )

LISTENER =
  (DESCRIPTION_LIST =
    (DESCRIPTION =
      (ADDRESS = (PROTOCOL = TCP)(HOST = MACHINE_ABC)(PORT = 1521))
      (ADDRESS = (PROTOCOL = IPC)(KEY = EXTPROC1521))
    )
  )
```
## sqlnet.ora
```
SQLNET.AUTHENTICATION_SERVICES= (NONE)

NAMES.DIRECTORY_PATH= (TNSNAMES, EZCONNECT)
```
