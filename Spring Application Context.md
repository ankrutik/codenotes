#spring 

- Interface `org.springframework.context.ApplicationContext`
- IoC container
	- Other type is Bean Factory
- See [Different ApplicationContexts](https://www.baeldung.com/spring-application-context)
	- Java based
	- Annotation based
	- XML based
# Best Practices
## Avoid resource leak 
Use try with resource to launch application to close it automatically
- in case anything goes wrong during the usage
- finished using the context
```java
try(var ctx = new AnnotationConfigApplicationContext(AnnotationApproachConfig.class))
{
	applicationContext.getBean("name");
	applicationContext.getBean("rushil");
}	
```
# References
- https://medium.com/@axel.garcia/how-does-applicationcontext-work-internally-in-spring-boot-d8826b549ab