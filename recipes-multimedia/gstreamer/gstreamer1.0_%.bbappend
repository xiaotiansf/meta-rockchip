FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "\
    file://0001-gstconfig.h.in-initial-RISC-V-support.patch \
    file://0002-filesrc-Fix-stopping-race-in-pull-mode.patch \
"
