#spring 

- Retrieve Beans by...
	- Method name
	- Bean name
	- Class type
		- Will fail if there are 2 or more bean methods that return objects of the same type. To solve situation of multiple candidates...
			- Define with `@Primary`
			- Use `@Qualifier("qualifierName")`
				- `@Qualifier` can be used to refer to Beans named with `@Bean(name = "somename")` not just those name with `@Qualifier("somename")`
	- Get all
		- `ctx.getBeanDefinitionName();`
	- Suggested approach is [[Spring Component and ComponentScan]]

```java
// build application context
var ctx = new AnnotationConfigApplicationContext(AnnotationApproachConfig.class);

// simple String
ctx.getBean("name");
// method name
ctx.getBean("rushil");
// bean name
ctx.getBean("Akshai");
// class type
//will fail if there are 2 or more bean methods that return same type
ctx.getBean(SandwichShop.class);

//get all
Arrays.stream(ctx.getBeanDefinitionNames())
.forEach(System.out::println);
```