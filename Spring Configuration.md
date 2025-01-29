#spring 

- Class with `@Configuration` annotation
- Contains `@Bean` definitions

## recipe 1
Instead of having a separate class annotated as Configuration, you can mark the started class itself.
```java
// AppMain.java Before change...
@Configuration
class AppConfig {
	@Bean
	public String getName(){ return "Shire"; }
}

public class AppMain {
	psvm(String args[]){
		// load AnnotationConfigContext with AppConfig.class in 
		// try-with
		// use beans from context
	}
}

// AppMain.java After change...
@Configuration
public class AppMain {
	@Bean
	public String getName(){ return "Shire"; }
	
	psvm(String args[]){
		// AppConfig.class removed
		// load AnnotationConfigContext in try-with
		// use beans from context
	}
}
```

## Note on XML vs Annotation
#spring/bestpractices Some new features may not be available via XML configurations. Move away from XML configuration and towards Java config or Annotations as much as possible.
See tip on [this Spring JPA page](https://docs.spring.io/spring-data/jpa/reference/repositories/create-instances.html#jpa.java-config)
