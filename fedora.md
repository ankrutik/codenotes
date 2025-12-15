#linux/distro

“Workstation” variant is meant for developers. 

**Uses rpm files**, not deb.

**When updating Linux, check...**
- Will **Gnome** be updated as part of the Linux update?
	- Do your installed applications have an update for that Gnome version?
# Installation
- Fedora Media Writer to write bootloader to disk
	- Can be used to run OS from USB
- Needs RAID turned off in BIOS
	- More of a Windows thing
	- Switch to AHCI
# Setup
- Install via `flatpak` or Application Store
	- Intellij
	- CopyQ
		- Setup system shortcut to execute `copyq show`
- git
	- See [[Platform Specific Credential Manager for git]]
- vim 
	- See [[vimrc]]
- Obsidian
- Drivers
	- Epson L3150
		- See [[rpm#Install local file with digest verification]]
		- Uploaded to Drive

## Installing software
Stay away from the "Apps" software. Clunky and slow.
```bash title:'Install rpm files from bash'
sudo dnf install package.rpm
```

See [[gnome extensions#installing extensions]]
## Directory Structure
```
~/Projects/ 
	├── personal/ 
	├── work/ 
	├── opensource/ 
	└── learn/
		└── notes/
		└── codenotes/
```


# Session restore 
Use [Another Windows Session Manager](https://extensions.gnome.org/extension/4709/another-window-session-manager/) to save and restore Windows.
As of 2025.11.01, no support for Gnome 49.

## Archive (does not work)
```bash
gsettings set org.gnome.SessionManager auto-save-session true
```

```bash
sudo dnf install wmctrl
```
# Usage
## Screens
1. Browser
2. Terminal tabs 
	1. git
	2. coffee dial-in
3. Obsidian
4. Intellij
## Power
- Use Power button to Suspend laptop often
	- Faster than Hibernate
	- **Can lose data if battery exhausts during Suspend**
- Performance mode when coding
- Balanced Mode usually when note taking
- Power Saver mode when below 50%