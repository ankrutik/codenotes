#git #troubleshoot 

File is `.git/config`
# Troubleshooting

## Authentication issues
Considering your password has changed, use the following to reset any credential configurations that were previously used for authentication with the repo server.
```bash
git config --system --unset credential.helper
```
On the next exchange with the repo server, git will ask you for your username and password.
## New line issues
### Scenario 1
Code base has been moved to another OS installation where `git bash` was installed anew. You have moved .ssh directory along with other got configurations. 
When you run `git status`, all files are seen as modified.
When you do a `git diff <filename>`, the only change you see are new line characters.

Use the following on the codebase to fix the issue. The files will not be shown as modified and you will be able to `git pull`.
```bash
git config core.autocrlf input
```

If the files still show up when checking status, perform a `git stash … git pull … git stash pop` after above. 
# Resources
- https://stackoverflow.com/questions/5787937/git-status-shows-files-as-changed-even-though-contents-are-the-same
- 