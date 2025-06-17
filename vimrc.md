#linux #vim

# Create vimrc
```bash
vim ~/.vimrc
```

# Vimrc contents
```bash
" Basic indentation settings
set autoindent          " Copy indent from current line when starting new line
set smartindent         " Smart autoindenting for C-like programs
set expandtab           " Use spaces instead of tabs
set tabstop=4           " Number of spaces a tab counts for
set shiftwidth=4        " Number of spaces for each indent
set softtabstop=4       " Number of spaces a tab counts for while editing
set formatoptions+=r   " Auto-insert comment leader after <Enter>

```