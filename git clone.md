#git 

## Regular default branch clone
```bash
git clone ssh://git@code.base.com:7999/project/main.git codebase_directory_name
```
## Cloning single branch
Use this when the codebase is too large and clone command fails due to volume.
```bash
git clone ssh://git@code.base.com:7999/project/main.git codebase_directory_name --branch branch_to_clone --single-branch
```
## Troubleshoot
1. What is the correct clone URL to use?
	1. Do you have access to the distributed server of the repository? Is there an alternate location/server that you can try?
	2. Do you have access to the auth protocol? ssh vs https
	3. Is the repository too large? Should you try single branch clone?