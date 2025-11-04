#tech #webservers

- Isolate if the error is at browser or server by looking at browser console or network tab
	- [[HTTP Response Codes]] 400 or 500
- Is the failure at routing of the web server like https or f5?
- Is the failure in the application server?
	- Authentication issue?
	- Forbidden to user?
	- Error in server logs?
		- Startup was alright?
	- Error in application logs
		- Log level needs to change
		- Flag log entries by thread ID

Take a moment to understand during POC or development where the failures might be occurring. Can influence the design of your work.

When troubleshooting such things and also for system design, it helps to understand at what level the communication is failing. Redirection? Domain not found? Application error? At what point in the application?

If there is a gateway or redirection server check those logs. If Tomcat is involved, check the access logs. If application is failing, check application logs.

# Links

# References