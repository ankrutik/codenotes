#Security #web 
# Abstract
Attacker delivers malicious code to end user by injecting in web pages coming from an otherwise benign web site.

Occurs mostly when servers consume user input without validation.
# Best Practices
## Defense Philosophy
Attacker must be able to to insert and execute malicious content in a webpage. 

Perfect injection resistance
- ensure that **all variables** go through validation
- are then escaped or sanitized 

Encode all output so that variables are interpreted as text and not code.

# Types
## Reflected
- Injected script is reflected off the web server as part of..
	- error message
	- search result
	- other responses
- Delivered via emails or some other website
## Stored
- Permanently stored on target servers
- malicious script delivered directly from server
- Blind Cross-site scripting
	- when malicious code is executed via backend application by backend users like admins

# References
- https://x.com/alexxubyte/status/1796206525360603171
- OWASP
	- https://owasp.org/www-community/attacks/xss/
	- https://cheatsheetseries.owasp.org/cheatsheets/Cross_Site_Scripting_Prevention_Cheat_Sheet.html
	- https://cheatsheetseries.owasp.org/cheatsheets/DOM_based_XSS_Prevention_Cheat_Sheet.html