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
