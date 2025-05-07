#linux 

Look in specific folder only
```bash
grep 'searchterm' /folder/abc/*
```

Look in all folders inside given folder
```bash
grep -r 'searchterm' /folder/abc/
grep --recursive 'searchterm' /folder/abc/
```
Exclude
```bash
grep -V 'otherthanthissearchterm' filetosearch.txt
```
Mostly useful with piping
```bash
grep 'searchterm' filetosearch.txt | grep -V 'excludethissub-searchterm' | grep -V 'excludefurther'
```
Display modifiers
```
-n show line numbers
-l show file name
-c show count in each file
--exclude=*.gz exclude .gz files from search
```