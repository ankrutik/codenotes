#spring 
# Define
- Use `@Bean` annotation
- Define inside [[Spring Configuration]] class
  
Annotate method that returns an Object with `@Bean`

```java
//File AnnotationApproachConfig.java
record Person (String name, int age) { };
record Place (String name, String area) { };
record Plan (Person person, Place place) { };
record SandwichShop (String name) { };

@Configuration
public class AnnotationApproachConfig {

	// very simple Bean called "name"
	@Bean
	public String name(){
		return "JellyBean";
	}

	@Bean
	public Person rushil(){
		return new Person("Rushil", 34);
	}
	
	@Bean(name = "Akshai")
	public Person buildAkshai(){
		return new Person("Akshai", 35);
	}

	@Bean(name = "SandwichShop")
	public SandwichShop buildSandwichShop(){
		return new SandwichShop("Basic");
	}

	@Bean(name = "ChilliCheeseSandwichShop")
	public Place buildChilliCheeseSandwichShop(){
		return new Place(
		"ChilliCheeseSandwichShop", "Worli");
	}

	// auto-wire using parameters
	@Bean(name = "MondayPlan")
	public Plan buildMonday(Person rushil, Place ChilliCheeseSandwichShop){
		return new Plan(rushil, ChilliCheeseSandwichShop);
	}
}
```
# Retrieve
- By...
	- Method name
	- Bean name
	- Class type
		- Will fail if there are 2 or more bean methods that return objects of the same type
	- Get all
		- `ctx.getBeanDefinitionName();`
- To solve situation of Multiple candidates
	- Define with `@Primary`
	- Use `@Qualifier("qualifierName")`
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