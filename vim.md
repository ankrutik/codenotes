#linux #texteditor

## Quit
`Esc, :q` : Quit
`Esc, :w` : Write
`Esc, :wq` : Write and Quit

## Search
`Esc, /searchString` : Forward search
`Esc, /\searchString` : Case-Insensitive Forward search
`Esc, ?searchString` : Backward search

`:set ignorecase`
`:set smartcase`

## Go To line
`:123` : Go to line 123
`gg`  : First line
`G` :  Last line
`:+10` : Go down 10 lines
`:-10` : Go up 10 lines

`:set number` : See line numbers
## Edit Mode
`Esc, i`
## Visual Mode
`Esc, v`

`y` : Yank or Copy
`d`: Delete
`p`: Paste

## Timestamp
`:put =strftime('%c')`

## Visual Block Mode for column insertion
```
Esc
Ctrl+V
--- Select the lines you want to insert column text
Shift+I
--- Enter the text you want, the change will be displayed on the line where the cursor is currently
Esc
--- The change will reflect
```