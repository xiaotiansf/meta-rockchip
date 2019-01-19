DESCRIPTION = "Rockchip binary loader"

LICENSE = "CLOSED"

DEPENDS = "rk-binary-native"

SRC_URI = "git://github.com/rockchip-linux/rkbin.git"
SRCREV = "c528bc933c43488e407ff6f4858831f274dc1af0"
S = "${WORKDIR}/git"

LOADER_rk3399 ?= "rk33/rk3399_loader_*.bin"

MINILOADER_rk3328 ?= "rk33/rk3328_miniloader_*.bin"
MINILOADER_rk3399 ?= "rk33/rk3399_miniloader_*.bin"

DDR_rk3328 ?= "rk33/rk3328_ddr_786MHz_*.bin"
DDR_rk3399 ?= "rk33/rk3399_ddr_800MHz_*.bin"

inherit deploy

DDR_BIN = "ddr.bin"
LOADER_BIN = "loader.bin"
MINILOADER_BIN = "miniloader.bin"
ATF_BIN = "atf.bin"
UBOOT_IMG = "uboot.img"
TRUST_IMG = "trust.img"

RKBINARY_DEPLOY_DIR = "${DEPLOYDIR}/rk-binary"

do_deploy () {
	install -d ${RKBINARY_DEPLOY_DIR}
	[ ${DDR} ] && cp ${S}/${DDR} ${RKBINARY_DEPLOY_DIR}/${DDR_BIN}
	[ ${MINILOADER} ] && cp ${S}/${MINILOADER} ${RKBINARY_DEPLOY_DIR}/${MINILOADER_BIN}
	[ ${LOADER} ] && cp ${S}/${LOADER} ${RKBINARY_DEPLOY_DIR}/${LOADER_BIN}
	[ ${ATF} ] && cp ${S}/${ATF} ${RKBINARY_DEPLOY_DIR}/${ATF_BIN}

	# Don't remove it!
	echo "done"
}

deploy_prebuilt_image () {
	install -d ${RKBINARY_DEPLOY_DIR}
	[ -e {S}/img/${SOC_FAMILY}/${UBOOT_IMG} ] && \
		cp ${S}/img/${SOC_FAMILY}/${UBOOT_IMG} ${RKBINARY_DEPLOY_DIR}/${UBOOT_IMG}
	[ -e ${S}/img/${SOC_FAMILY}/${TRUST_IMG}  ] && \
		cp ${S}/img/${SOC_FAMILY}/${TRUST_IMG} ${RKBINARY_DEPLOY_DIR}/${TRUST_IMG}
}

do_deploy_append_rk3328 () {
	deploy_prebuilt_image
}

do_deploy_append_rk3399 () {
	deploy_prebuilt_image
}

addtask deploy before do_build after do_compile

do_package[noexec] = "1"
do_packagedata[noexec] = "1"
do_package_write[noexec] = "1"
do_package_write_ipk[noexec] = "1"
do_package_write_rpm[noexec] = "1"
do_package_write_deb[noexec] = "1"
do_package_write_tar[noexec] = "1"
