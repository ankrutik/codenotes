#design #architecture 

Microservices concepts implemented in the front end developer flow.
Independent development and builds for different modules.

# Why?
- independent development
	- faster iterations
	- reduces bottlenecks
	- specialized skills
- module autonomy
	- failure isolation
	- scalability
		- code
		- team
	- flexibility in tech stacks
- performance
	- optimized loading

# When?
- large applications with numerous functions
	- each function having complexity and scalability concerns
- isolated function sets
	- segmentation in functionality
	- specialized teams
- business requirements keep evolving
	- adaptable
	- iterative development
- need for diverse tech stacks
- collaboration
	- team independence
	- reduced conflicts

# Best Practices
- Define clear module boundaries
- Independent development
- Module autonomy
- API contracts
- Versioning and compatibility
- Consitent UI/UX
- Isolate dependencies
- Centralized routing/navigation
- Monitor and logging
- CI/CD

# Code repo approaches
- mono repo
- multi repo
- meta repo
	- [[git submodules]] maybe?
# Frameworks that support
React, Angular, Next.js Vue.js, Svelte
# References
[Turing blog on microfrontends](https://www.turing.com/blog/micro-frontends-what-are-they-when-to-use-them/#:~:text=A%20micro%2Dfrontend%20is%20a,or%20functions%20within%20the%20application.)
[[https://martinfowler.com/articles/micro-frontends.html]]
