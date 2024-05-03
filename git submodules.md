#git 

- clone, pull, push a repo inside directory of another repo
- opposite of [[git sparse-checkout]]

## Adding a submodule
In existing git tracked project, `cd` to the directory where you want your submodule to exist.
```console
git submodule add https://github.com/username/projectname
```
This will clone the repo as a submodule and introduce 2 new changes
```console
	new file:   .gitmodules
	new folder: projectname
```
If you want to include these files in your parent project, commit these changes to your project to track them.

## Cloning project with submodules
Cloning repos with submodules will not clone the submodules. Just  a directory will be present without any of the files.
To bring in the submodule, run the following
```console
git submodule init
git submodule update
```
## Pulling into submodules
`git submodule update --remote`

## Pushing to submodules
`cd` to the submodule directory and perform commit and push to the submodule repo.

## Including submodule commits in parent codebase
Making commits from the parent directory will still show changes for the submodules as uncommitted.
```bash
 modified:   dir/submoduledir (modified content)
```
`cd` to the submodule directory and perform commit and push to the submodule repo.

`cd` to the parent directory. The submodule's commits will now show as pending to be added to the parent directory.

Making commits now from the parent directory will commit the submodule changes as part of the parent repo.

# Links

# References
https://git-scm.com/book/en/v2/Git-Tools-Submodules