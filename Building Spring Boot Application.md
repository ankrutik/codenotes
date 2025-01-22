#spring #gradle 

*This assumes you are building with Gradle*

Set `JAVA_HOME`
```bash
set JAVA_HOME=C:\dev\Tools\Javalib\jdk-21.0.1
```
## To Build
```bash
gradlew.bat build
```
## To Build and Run
```bash
gradlew.bat bootRun
```
## To Build Distributable
Add following plugin to `build.gradle` file
```groovy
plugins {  
    ...
    id 'application'  
}
```
Then run
```bash
gradlew.bat bootDistZip
gradlew.bat bootDistTar
```
This will build the distributable at 
```
<project>build\distributions
```
The zip will contain
- bin with the executables
- jar with 
	- at root...
		- third party dependency classes 
	- in BOOT-INF...
		- custom, user programmed classes
	- META-INF

JRE/JDK will not be packaged.