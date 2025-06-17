#git #Security 

Use platform specific credential helper. Fedora specific example below
```bash
sudo dnf install git-credential-libsecret
git config --global credential.helper /usr/libexec/git-core/git-credential-libsecret
