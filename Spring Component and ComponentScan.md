#spring 
`@Component` and `@ComponentScan` annotations help reduce code that explicitly creates the beans. Spring will instead do that for us.

```java
// ===== AppMain.java
package com.acme.business;
import ...

@Configuration
@ComponentScan("com.acme.business")
public class AppMain {

	// Here, object of BusinessClass is Autowired into classObject
	@Bean(name = "explicitInit")
	public WhichClass initClass(WhichClass classObject){
		classObject.setName("namename");
		return classObject;
	}

	psvm(String a[]){
		// AnnotationConfigContext context
		context.getBean("explicitInit");
		// Here, 
		context.getBean(BusinessClass.class);
	}
}

// ===== WhichClass.java
package com.acme.business;
import ...
public interface WhichClass { ...
}

// ===== BusinessClass.java
package com.acme.business;
import ...

@Component
public class BusinessClass implements WhichClass {

}
```