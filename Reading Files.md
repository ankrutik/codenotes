#java #recipe 

# Java
## Streams
```java
String filename = "/samplefile.txt";  

try(Stream<String> streamOfLines = Files.lines(Paths.get(filename))) 
{  
	streamOfLines.forEach(s -> 
		{  
	        System.out.println(s);  
	    }
    );
}
catch(Exception e){  
	System.out.println(e);
}
```