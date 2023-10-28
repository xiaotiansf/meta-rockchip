# Copyright (C) 2016 - 2017 Randy Li <ayaka@soulik.info>
# Released under the GNU GENERAL PUBLIC LICENSE Version 2
# (see COPYING.GPLv2 for the terms)

DEFAULT_PREFERENCE = "-1"

include rockchip-mpp.inc
DEPENDS = "git-replacement-native"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
FILESPATH_prepend := "${THISDIR}/${PN}:"

SRCREV = "${AUTOREV}"
#SRC_URI = "git://github.com/kraj/mpp.git;branch=release"
SRC_URI = "git@github.com:xiaotiansf/mpp.git;branch=develop"

S = "${WORKDIR}/git"
