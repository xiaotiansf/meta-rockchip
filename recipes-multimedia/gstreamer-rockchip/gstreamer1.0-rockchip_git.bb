# Copyright (C) 2016 - 2017 Randy Li <ayaka@soulik.info>
# Released under the GNU GENERAL PUBLIC LICENSE Version 2
# (see COPYING.GPLv2 for the terms)

DEFAULT_PREFERENCE = "-1"

include gstreamer1.0-rockchip.inc

SRCBRANCH ?= "master"
SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/kraj/gstreamer-rockchip.git;branch=${SRCBRANCH};protocol=https"
SRC_URI_remove = "file://gtk-doc-tweaks.patch"

S = "${WORKDIR}/git"
