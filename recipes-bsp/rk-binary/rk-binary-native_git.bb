inherit native deploy

DESCRIPTION = "Rockchip binary tools"

LICENSE = "CLOSED"

SRC_URI = "git://github.com/rockchip-linux/rkbin.git"
SRCREV = "c528bc933c43488e407ff6f4858831f274dc1af0"
S = "${WORKDIR}/git"

do_install () {
	install -d ${D}/${bindir}
	install -m 0755 "${S}/tools/trust_merger" ${D}/${bindir}
	install -m 0755 "${S}/tools/firmwareMerger" ${D}/${bindir}

	install -m 0755 "${S}/tools/kernelimage" ${D}/${bindir}
	install -m 0755 "${S}/tools/loaderimage" ${D}/${bindir}

	install -m 0755 "${S}/tools/mkkrnlimg" ${D}/${bindir}
	install -m 0755 "${S}/tools/resource_tool" ${D}/${bindir}

}
