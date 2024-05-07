#testing #testing 

# Ordering and Dependency
```java
@Test(groups = "prep")  
public void initialization(){ ... }

@Test(groups = "test", dependsOnGroups = "prep")  
public void test1(){ ... }

@Test(groups = "test", dependsOnGroups = "prep")  
public void test2(){ ... }
```
Mention all 3 methods in the xml file.

# References
https://testng.org/
https://testng.org/#_testng_xml