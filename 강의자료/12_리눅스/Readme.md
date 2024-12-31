### vmware and Rocky linux 설치
- [vmware player](https://softwareupdate.vmware.com/cds/vmw-desktop/player/17.6.2/24409262/windows/core/)
- [로키리눅스](https://rockylinux.org/ko-KR/download) mini iso

### GUI 설치
- dnf update -y
- dnf grouplist
- dnf groupinstall "Workstation" -y
- systemctl get-default
- systemctl set-default graphical.target
- systemctl get-default
- reboot
### node.js 설치
```
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.3/install.sh  | bash
source ~/.bashrc
 nvm --version
 nvm list-remote

nvm install v22.12.0
nvm list
nvm use v22.12.0
nvm -v

 sudo ln -s "$NVM_DIR/versions/node/$(nvm version)/bin/node" "/usr/local/bin/node"
$ sudo ln -s "$NVM_DIR/versions/node/$(nvm version)/bin/npm" "/usr/local/bin/npm"
```
