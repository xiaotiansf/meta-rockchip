# Copyright (C) 2016 - 2017 Randy Li <ayaka@soulik.info>
# Released under the GNU GENERAL PUBLIC LICENSE Version 2
# (see COPYING.GPLv2 for the terms)
include gstreamer1.0-rockchip.inc

TAG = "release_${PV}"
SRC_URI = " \
	git://github.com/rockchip-linux/gstreamer-rockchip.git;tag=${TAG};nobranch=1 \
	file://build-rename-drmrockchip-to-rkximage.patch \
	file://0002-rockchipmpp-release-the-buffer-meta-data.patch \
	file://0003-rockchipmpp-support-more-GstStateChange.patch \
"

S = "${WORKDIR}/git"
