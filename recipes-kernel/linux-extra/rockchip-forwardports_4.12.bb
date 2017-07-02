# Copyright (C) 2016 - 2017 Jacob Chen <jacob2.chen@rock-chips.com>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Rockchip forwardport"
DESCRIPTION = "This projects takes features included in https://github.com/rockchip-linux/kernel \
    and makes them buildable out-of-tree, on mainline kernel"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit module

DEPENDS += "linux-mainline"

SRCREV = "0db101a48fa132a323c2af7fa2b94db9a53b0a27"
SRC_URI = "git://github.com/rockchip-linux/rockchip_forwardports.git"
S = "${WORKDIR}/git"

module_do_compile() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS

	export CFLAGS=" -DCONFIG_MALI_MIDGARD -DCONFIG_MALI_MIDGARD_MODULE -DCONFIG_MALI_DEVFREQ \
            -DCONFIG_MALI_DMA_FENCE -DCONFIG_MALI_EXPERT -DCONFIG_MALI_PLATFORM_THIRDPARTY \
            -DCONFIG_MALI_PLATFORM_THIRDPARTY_NAME=rk -I${S}/include"

	oe_runmake KERNEL_PATH=${STAGING_KERNEL_DIR} \
		KERNEL_VERSION=${KERNEL_VERSION} \
		CC="${KERNEL_CC}" LD="${KERNEL_LD}" \
		AR="${KERNEL_AR}" \
		O=${STAGING_KERNEL_BUILDDIR} \
		KBUILD_EXTRA_SYMBOLS="${KBUILD_EXTRA_SYMBOLS}" \
		${MAKE_TARGETS} \
		CONFIG_MALI_MIDGARD=m CONFIG_MALI_DEVFREQ=y CONFIG_MALI_DMA_FENCE=y \
		CONFIG_MALI_EXPERT=y CONFIG_MALI_PLATFORM_THIRDPARTY=y CONFIG_MALI_PLATFORM_THIRDPARTY_NAME=rk \
		CONFIG_RK_VCODEC=m
}

KERNEL_MODULE_AUTOLOAD += "mali_kbase rk-vcodec"
