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
	- Clipboard Managers
		- [Clipboard Indicator](https://extensions.gnome.org/extension/779/clipboard-indicator/)
		- CopyQ
			- Setup system shortcut to execute `copyq show`
- git
	- See [[Platform Specific Credential Manager for git]]
- vim 
	- See [[vimrc]]
- [Obsidian flatpak](https://obsidian.md/download)
- [protonvpn](https://protonvpn.com/support/official-linux-vpn-fedora)
- Drivers
	- Epson L3150
		- See [[rpm#Install local file with digest verification]]
		- Uploaded to Drive

```bash title: 'Common software'
# libreoffice
sudo dnf install libreoffice

#protonvpn
sudo dnf install ./protonvpn-stable-release-1.0.3-1.noarch.rpm && sudo dnf check-update --refresh
sudo dnf install proton-vpn-gnome-desktop

# nvidia drivers
sudo dnf install xorg-x11-drv-nvidia-cuda xorg-x11-drv-nvidia-cuda-libs

# qbittorent
sudo dnf install qbittorrent

```
## Installing software
Stay away from the "Apps" software. Clunky and slow.
```bash title:'Install rpm files from bash'
sudo dnf install package.rpm
```

See [[gnome extensions#installing extensions]]
## Directory Structure
```bash 
~/projects/ 
	├── personal/ 
	├── work/ 
	├── opensource/ 
	└── learn/
		└── notes/
		└── codenotes/

mkdir -p projects/learn/notes
mkdir -p projects/learn/codenotes
mkdir -p projects/personal
mkdir -p projects/work
mkdir -p projects/opensource		
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
## Software Updates
Check what needs update in the "Software" application, but prefer bash to actually update.
```bash title:'Update software'
sudo dnf upgrade firefox
sudo dnf upgrade vlc
```
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
## GNOME Extensions
Can be controlled from browser (via browser extension) at 
https://extensions.gnome.org/local/

# Troubleshooting
[Fedora Troubleshooting Quick Doc](https://docs.fedoraproject.org/en-US/quick-docs/troubleshooting-bluetooth-problems/)
## Copying large files
Use [[rsync]] to avoid the "Error Splicing File" issue
## Sound lag
As of fedora 43, PulseAudio should not be installed. pipewire and wireplumber should be  installed.
After an upgrade, if you notice audio lag, restart wireplumber...
```bash title:'Restart wireplumber'
systemctl restart --user wireplumber
```
### Archived
Reboot after following then wait for some time. 
The issue goes away on it's own.
Observed to happen when video/sound drivers were changed. Probably some build happening in the back.
```bash title:'Restart pipewire services'
systemctl --user restart pipewire pipewire-pulse wireplumber
```
#### Immediate fix
```
# Completely disable audio power management
sudo vim /etc/modprobe.d/audio_powersave.conf

# Disable ALL audio power saving
options snd_hda_intel power_save=0 power_save_controller=N
options snd_ac97_codec power_save=0
options snd_usb_audio power_save=0

# Completely disable audio power management
sudo vim /etc/modprobe.d/audio_powersave.conf

# Disable ALL audio power saving
options snd_hda_intel power_save=0 power_save_controller=N
options snd_ac97_codec power_save=0
options snd_usb_audio power_save=0
```

```bash title:' Low latency config'
vim  ~/.config/pipewire/pipewire.conf.d/10-low-latency.conf 

# add following
context.properties = { default.clock.rate = 48000 default.clock.quantum = 256 default.clock.min-quantum = 16 default.clock.max-quantum = 1024 
}

# restart
systemctl --user restart pipewire pipewire-pulse wireplumber

```

```bash title:'Reinstall drivers'
sudo dnf install nvidia-driver kmod-nvidia-latest-dkms

sudo dnf install kernel-devel-matched kernel-headers

sudo dnf reinstall pipewire pipewire-pulseaudio pipewire-alsa wireplumber
```

PulseAudio should not be present.
```bash title:'Remove pulseaudio and install pipewire'
sudo dnf install pipewire pipewire-alsa pipewire-pulseaudio \ pipewire-jack-audio-connection-kit wireplumber \ pipewire-utils

sudo dnf remove pulseaudio pulseaudio-utils

systemctl --user enable pipewire pipewire-pulse wireplumber 
systemctl --user start pipewire pipewire-pulse wireplumber
```

## Repo related issues
```bash title:'Error message'
Failed to load updateinfo cache for repo...
id too large...
```

```bash title: 'Solution'
sudo dnf clean all
sudo dnf makecache
```

## Clipboard Indicator
**This will remove your clipboard history.**
Registry file might be corrupted.  
Check if you have the file `/home/krutikarekar/.cache/clipboard-indicator@tudmotu.com/registry.txt`  
If it exists, rename to `/home/krutikarekar/.cache/clipboard-indicator@tudmotu.com/registry.backup.txt` 
Logout/login to GNOME. 
