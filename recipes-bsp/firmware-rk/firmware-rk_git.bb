# Copyright (C) 2016 - 2017 Jacob Chen <jacob2.chen@rock-chips.com>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Rockchip firmware"
DESCRIPTION = "Rockchip firmware such as for the WIFI, BT"

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=564e729dd65db6f65f911ce0cd340cf9"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/kraj/rkwifibt"

#SRCREV = "a389710ca130405a0e6e4f22bc0335c976a5c4b0"
#SRC_URI = "git://github.com/JeffyCN/mirrors.git;branch=rkwifibt"
#SRCREV = "5b8a34dcc21b465445a007ad4bc45c1770b73a1c"
#SRC_URI = "git://github.com/FireflyTeam/rkwifibt;protocol=https"
S = "${WORKDIR}/git"

inherit allarch

do_install () {
        install -d ${D}/system/etc/firmware/
        install -m 0644 ${S}/firmware/broadcom/all/*/* \
                -t ${D}/system/etc/firmware/
#        install -d ${D}/lib/firmware/rtlbt/
#        install -m 0644 ${S}/realtek/RTL*/* -t ${D}/lib/firmware/rtlbt/
}
PACKAGES =+ "${PN}-wifi \
             ${PN}-bt \
            "
ALLOW_EMPTY_${PN} = "1"
ALLOW_EMPTY_${PN}-bt = "1"
FILES_${PN}-wifi = "/system/* /lib/firmware/rtlbt"
