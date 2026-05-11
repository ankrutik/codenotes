#fedora #linux #customization #scripting


```bash title:'Enable repo and install keyd'
sudo dnf copr enable alternateved/keyd
sudo dnf install keyd
```

```bash title:'Write keyd conf file'
sudo vim /etc/keyd/default.conf
----------------------------------

[ids]
*

[main]
f1 = C-c
f2 = C-v
f3 = C-x
f4 = C-z
```

```bash title:'Start keyd daemon'
sudo systemctl enable --now keyd
```

```bash title:'Reload Keyd configs'
sudo keyd reload
```

# references
[keyd repo](https://github.com/rvaiya/keyd)