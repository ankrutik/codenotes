#git 

## List remote URLs
```bash
git remote -v
```
Separate values can be maintained for Fetch and Push.
## Add Remote

```bash
git remote add origin https://<GIT_URL_HERE>
```
## Remove Remote
```bash
git remote remove origin
```
## Change URLs
```bash
git remote set-url origin https://<NEW_GIT_URL_HERE>
```
These URL values can be changed from config file as well. See [[git config]]