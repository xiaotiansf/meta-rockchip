DESCRIPTION = "Rockchip binary loader"

LICENSE = "BINARY"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=564e729dd65db6f65f911ce0cd340cf9"
NO_GENERIC_LICENSE[BINARY] = "LICENSE.TXT"

DEPENDS = "rk-binary-native"

SRC_URI = "git://github.com/rockchip-linux/rkbin.git"
SRCREV = "7b3142bfc7b43709b2d09ca00faf85b36f8f74a4"
S = "${WORKDIR}/git"

LOADER_rk3399 ?= "rk33/rk3399_loader_*.bin"

MINILOADER_rk3399 ?= "rk33/rk3399_miniloader_*.bin"

DDR_rk3399 ?= "rk33/rk3399_ddr_800MHz_*.bin"

inherit deploy

DDR_BIN = "ddr.bin"
LOADER_BIN = "loader.bin"
MINILOADER_BIN = "miniloader.bin"
ATF_BIN = "atf.bin"
UBOOT_IMG = "uboot.img"
TRUST_IMG = "trust.img"

do_deploy () {
	install -d ${DEPLOYDIR}
	[ ${DDR} ] && cp ${S}/${DDR} ${DEPLOYDIR}/${DDR_BIN}
	[ ${MINILOADER} ] && cp ${S}/${MINILOADER} ${DEPLOYDIR}/${MINILOADER_BIN}
	[ ${LOADER} ] && cp ${S}/${LOADER} ${DEPLOYDIR}/${LOADER_BIN}
	[ ${ATF} ] && cp ${S}/${ATF} ${DEPLOYDIR}/${ATF_BIN}

	echo "done"
}

# for update image
do_deploy_append_rk3399 () {
	install -d ${DEPLOYDIR}
	cp ${S}/img/rk3399/${UBOOT_IMG} ${DEPLOYDIR}/${UBOOT_IMG}
	cp ${S}/img/rk3399/${TRUST_IMG} ${DEPLOYDIR}/${TRUST_IMG}
}

addtask deploy before do_build after do_compile

do_package[noexec] = "1"
do_packagedata[noexec] = "1"
do_package_write[noexec] = "1"
do_package_write_ipk[noexec] = "1"
do_package_write_rpm[noexec] = "1"
do_package_write_deb[noexec] = "1"
do_package_write_tar[noexec] = "1"
