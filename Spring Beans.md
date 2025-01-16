#spring 

- Java Bean
	- no arg constructor
	- getter and setters
	- `implements Serializable`
- Spring Bean
	- object managed by Spring IOC 
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
	@Primary
	public SandwichShop buildSandwichShop(){
		return new SandwichShop("Basic");
	}

	@Bean(name = "Mogo")
	@Qualifier("MogoQual")
	public SandwichShop buildSandwichShopMogo(){
		return new SandwichShop("Mogo");
	}


	@Bean(name = "ChilliCheeseSandwichShop")
	public Place buildChilliCheeseSandwichShop(){
		return new Place(
		"ChilliCheeseSandwichShop", "Worli");
	}

	// auto-wire using parameters
	@Bean(name = "MondayPlan")
	public Plan buildMonday(Person rushil, Place chilliCheeseSandwichShop){
		return new Plan(rushil, chilliCheeseSandwichShop);
	}

	// auto-wire using function call, duh!
	@Bean(name = "TuesdayPlan")
	public Plan buildTuesday(){
		return new Plan(rushil(), buildSandwichShop());
	}

	// @Primary will be autowired into someshop
	@Bean(name = "WednesdayPlan")
	public Plan buildWednesday(Person rushil, Place someshop){
		return new Plan(rushil, someshop);
	}

	// Mogo will be autowired into someshop
	@Bean(name = "ThursdayPlan")
	public Plan buildThurs(
		Person rushil
		, @Qualifier("MogoQual") Place someshop){
			return new Plan(rushil, someshop);
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
- To solve situation of multiple candidates
	- Define with `@Primary`
	- Use `@Qualifier("qualifierName")`
		- `@Qualifier` can be used to refer to Beans named with `@Bean(name = "somename")` not just those name with `@Qualifier("somename")`

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