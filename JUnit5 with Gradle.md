#testing #builds #gradle #junit

API and Runtime JUnit Dependencies needed
```groovy
dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.1'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.1'
}
```
Specify which testing platform to use
```groovy
test {
    useJUnitPlatform()
}

```

# References
https://www.baeldung.com/junit-5-gradle