#spring #setup #recipe

# Annotation Approach
1. Set up [[Spring Configuration]]
	1. [[Spring Beans#Define]]
2. Launch a [[Spring Application Context]]
	1. Pass configuration to application context

```java
//File AnnotationApproachConfig.java
record Person (String name, int age) { };

@Configuration
public class AnnotationApproachConfig {

	@Bean
	public String name(){
		return "JellyBean";
	}

	@Bean
	public Person rushil(){
		return new Person("Rushil", 34);
	}
}

// File ApplicationMainClass.java
public class ApplicationMainClass {
	public static void main(String[] args){
		var applicationContext = new AnnotationConfigApplicationContext(AnnotationApproachConfig.class);
		applicationContext.getBean("name");
		applicationContext.getBean("rushil");
	}
}
```