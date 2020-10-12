# Copyright (C) 2017 Fuzhou Rockchip Electronics Co., Ltd
# Released under the GNU GENERAL PUBLIC LICENSE Version 2
# (see COPYING.GPLv2 for the terms)
include gstreamer1.0-rockchip-extra.inc

TAG = "release_${PV}"
SRC_URI = " \
	git://github.com/kraj/gstreamer-rockchip-extra.git;tag=${TAG};nobranch=1 \
"
SRC_URI_remove = "file://gtk-doc-tweaks.patch"

S = "${WORKDIR}/git"
