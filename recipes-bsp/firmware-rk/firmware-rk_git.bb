# Copyright (C) 2016 - 2017 Jacob Chen <jacob2.chen@rock-chips.com>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Rockchip firmware"
DESCRIPTION = "Rockchip firmware such as for the WIFI, BT"

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=564e729dd65db6f65f911ce0cd340cf9"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/rockchip-linux/rkwifibt"
S = "${WORKDIR}/git"

inherit allarch

do_install () {
	install -d ${D}/system/etc/firmware/
	cp -rf ${S}/firmware/broadcom/all/WIFI_FIRMWARE/* ${D}/system/etc/firmware/

	install -d ${D}/etc/firmware/
	cp -rf ${S}/firmware/broadcom/all/BT_FIRMWARE/*.hcd ${D}/etc/firmware/
}

PACKAGES =+ "${PN}-wifi \
	${PN}-bt \
"
ALLOW_EMPTY_${PN} = "1"
FILES_${PN}-wifi = "/system/etc/*"
FILES_${PN}-bt = "/etc/firmware/*"
