#linux 

Install software in Linux distros like Fedora.

# Install local file with digest verification
Make sure you trust the source!

```bash title:'Install local file without digest verification'
sudo rpm -i --nodigest --nofiledigest epson_printer_drivers.rpm
```
## Related errors
```bash title:'Related errors'
Error running transaction: package epson-inkjet-printer-escpr-1.8.6-1.x86_64 does not verify: no digest
```