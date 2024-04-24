#java

```bash
# Copy jar built with fix
cp <original_location>/application.jar application.jar

# unzip jar
mkdir application-extracted
unzip application.jar application-extracted/

# extract files to patch
mkdir patch
cd application-extracted
cp ankrutik/util/AppUtil.class --parents ../patch/

# built patch jar
cd patch
/D/Tools/Javalib/jdk-17.0.2/bin/jar -cvf hotfix.jar com
```

Post JDK11, all hotfix type jars will come earliest in the classpath.