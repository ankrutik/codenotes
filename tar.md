#linux #archiving

- Running thru command line was seen to be much faster than using 7z or WinRar.
- No compression is used.
- Use when backing up files/folder when moving between machines/laptops.
# Creating
```bash
tar -czf archive_file_name.tar FolderToArchive/

# print checkpoints
tar --checkpoint=1000000 -czf archive_file_name.tar FolderToArchive/

# print all files
tar -czvf archive_file_name.tar FolderToArchive/
tar --verbose -czf archive_file_name.tar FolderToArchive/

tar --remove-files -czf archive_file_name.tar FolderToArchive/
```

## Parameterized
```bash
# parameterized with timestamp print 
export para='sc_latest_dumps'; date && tar -czvf $para.tar $para/ && date 

# parameterized with timestamp print and multiple folders 
export para='zzz01'; date && tar -czvf $para.tar zzzDocumentation/ zzzoutlookbackup/ zzzpendo/ && date
```

# Listing
```bash
tar --list -f archive_file_name.tar
```
# Extracting
```bash
tar -xzf archive_file_name.tar

# Specific folder
tar -xzf archive_file_name.tar /RootArchive/SubArchive
```
