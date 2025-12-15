#linux #gnome
# install extensions app
Only view, toggle extensions. Cannot install extensions.
```shell title:'install extensions app'
sudo dnf install gnome-extensions-app
```
# installing extensions
Source the file from the gnome extensions website or specific builds from github.

```shell title:'gnome extension location'
~/.local/share/gnome-shell/extensions/
```

Unzip at gnome extensions location...
```shell title:'unzip command'
unzip another-window-session-manager@gmail.com.zip -d ~/.local/share/gnome-shell/extensions/another-window-session-manager@gmail.com
```

```shell title:'List extensions'
gnome-extensions list
```

```shell title:'Enable extension'
gnome-extensions enable another-window-session-manager@gmail.com
```

For Wayland (fedora default), logout and login.