#java 

Start out with downloading the new JDK, change the JAVA_HOME for your web, and see if things work straight up. Read the changelogs early on.
## Test cases...

1. See Spring upgrade test cases
2. See Tomcat upgrade test cases
3. Any test cases that can be seen in the java changelogs

## Some other checks...

1. source the JDK version and subversion from a relevant authority in your org
2. check the source of the JDK: Oracle or AdoptJDK or Amazon or something else
3. check if we need to upgrade Tomcat with the JDK
    1. Check what other teams are doing
4. check if the current version of Spring that we use is supported with that JDK version
    1. Check what other teams are doing
5. Check the order of mentioning jars in the classpath has changed. Do you need to rearrange how the jars are mentioned?
    1. Application start up .bat and .sh files
    2. tomcat/catalina.properties>shared.loader
6. Read the changelog from the version/sub-version we are currently at and where we are updating to. See if there is any change/feature that we can adopt or make changes for.

## Timings
Should take you 2 days if there isn't anything major.
Otherwise 2 weeks if it calls for Spring upgrade.
5 days if Tomcat upgrade is needed.
If something super weird comes up, then can take you a month. (Trauma from July 2020 when we went to JDK 12 or 17)

Switch JDK for your application and check early on to understand what all efforts you will need. Read the changelogs early on.