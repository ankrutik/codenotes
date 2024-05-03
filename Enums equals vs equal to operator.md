#java 

Use `==` over `.equals()` for enum comparisons.
`==` will enforce type checking at compile time.
`.equals()` with object of another class will always compile, but always incorrectly return `false`.