#linux 


```bash title:'Basic'
rsync -avh --progress file.txt /run/media/krutikarekar/ssd1/screen

# a: Archive Mode
# v: Increase verbosity
# h : Human readable
```

> rsync is a file transfer program capable of efficient remote update
via a fast differencing algorithm.

Use when...
- transferring large files
- transferring files over network
- overcoming "Error Splicing File" issue

How is it better?
- copies only differences
- shows progress
- preserves permissions, timestamps, etc.
- verification options
- resume broken transfers


