#java #json #serialization #javascript

Using Javascript Script Engine
```java
// contruct javascript engine
ScriptEngineManager sem = new ScriptEngineManager();
ScriptEngine engine = sem.getEngineByName("javascript");

//javascript script
String script = "Java.asJSONCompatible(" + json + ")";

// evaluate script
Map contents = (Map)this.engine.eval(script);

// iterate
contents.forEach((t, u) -> {
	System.out.println(t + ": " + u);
});
```
See also [[Nashorn Javascript]]

# Best Practices
Using de/serialization libraries like [[Jackson]] still remains the better option to have control over conversion options.

# References
https://www.java67.com/2024/06/how-to-convert-json-to-map-in-java-8.html?spref=tw