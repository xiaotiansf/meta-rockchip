# Copyright (C) 2017 Jacob Chen
# Released under the MIT license (see COPYING.MIT for the terms)

SOC_FAMILY = "rk3399"

require conf/machine/include/arm/arch-armv8.inc
require conf/machine/include/soc-family.inc

PREFERRED_PROVIDER_virtual/kernel = "linux-mainline"

SERIAL_CONSOLES = "1500000;ttyFIQ0"
KERNEL_IMAGETYPE = "Image"
KBUILD_DEFCONFIG = "defconfig"

PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot-rockchip"

IMAGE_FSTYPES = "ext4 rockchip-gpt-img"
IMAGE_CLASSES += "rockchip-gpt-img rockchip-update-img"
