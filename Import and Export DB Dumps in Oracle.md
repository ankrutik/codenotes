#database #oracle 

```sql title:"Export"
expdp system/system SCHEMAS=tp2,smf,sabamaster,metadb DUMPFILE=SC_DUMPS_20250408_U62S3_KAREKAR.DMP log=SC_DUMPS_20250408_U62S3_KAREKAR.log
```


```sql title:"Import"
impdp system/system@qadb SCHEMAS=tp51_tenant,smf,sabamaster,metadb DUMPFILE=SC_dumps_20230907.DMP
```