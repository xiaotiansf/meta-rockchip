FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://0002-Add-support-reboot-loader-command.patch \
"

BUSYBOX_SPLIT_SUID = "0"

