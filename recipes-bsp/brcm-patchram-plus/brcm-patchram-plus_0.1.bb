DESCRIPTION = "Broadcom Bluetooth patch utility (based on Intel Edison tree)"
SECTION = "connectivity"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://brcm_patchram_plus.c;md5=1428ee036a462b072ab6698573efe80c"

SRC_URI = "file://brcm_patchram_plus.c \
           file://brcm_patchram_plus1.c \
           file://bluetooth-init.service \
           "
S = "${WORKDIR}/"

inherit systemd

do_compile() {
	${CC} -O2 -Wall -o brcm_patchram_plus brcm_patchram_plus.c
	${CC} -O2 -Wall -o brcm_patchram_plus1 brcm_patchram_plus1.c
}

do_install() {
	install -v -d  ${D}/usr/sbin/
	install -m 0755 brcm_patchram_plus ${D}/usr/sbin/
	install -m 0755 brcm_patchram_plus1 ${D}/usr/sbin/
        install -Dm 0644 ${WORKDIR}/bluetooth-init.service ${D}${systemd_system_unitdir}/bluetooth-init.service
}

SYSTEMD_SERVICE_${PN} = "bluetooth-init.service"

INSANE_SKIP_${PN} = "ldflags"
