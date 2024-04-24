#oracle 

- Install Software only
	- Avoid creating database instance as part of installation. Create db instance after installation using DBCA.
- Use Virtual Account for user
	- Do not select existing or new Windows User option
- DBCA Instance creation
	- Use File System storage
		- Not ASM
	- Unselect "pluggable" or "container" installation
	- UTF8 character encoding