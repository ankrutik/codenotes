#git #troubleshoot 

# Troubleshooting

## New line issues
### Scenario 1
Code base has been moved to another OS installation where `git bash` was installed anew. You have moved .ssh directory along with other got configurations. 
When you run `git status`, all files are seen as modified.
When you do a `git diff <filename>`, the only change you see are new line characters.

Use the following on the codebase to fix the issue. The files will not be shown as modified and you will be able to `git pull`.
```bash
git config core.autocrlf input
```

# Resources
- https://stackoverflow.com/questions/5787937/git-status-shows-files-as-changed-even-though-contents-are-the-same
- 