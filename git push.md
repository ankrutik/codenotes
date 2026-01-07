#git 

> Updates remote refs using local refs, while sending objects necessary to complete the given refs.

Push command pushes changes from branch on your local git to branch on the server. 

## -f
Do not use `-f ` parameter on regular basis. If your local branch is not updated (remote branch has changes you don’t have), then you will end up replacing the remote branch with your outdated local branch. 

 ## --force-with-lease
 Performs force push only if the remote does not have any changes from others. Use when you have rebased, squashed, changed commits, etc.
 
## When local branch is not updated…

If commits are present on the remote branch that are not present on local branch, git will be unable to push.

In that case, perform a `git fetch` and then `git rebase`  to update your local branch. Resolve conflicts if any. Then push again. 
`