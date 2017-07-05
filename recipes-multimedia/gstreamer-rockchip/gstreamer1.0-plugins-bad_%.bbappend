PACKAGECONFIG_append = " kms"

SRC_URI += " \
	file://0015-HACK-always-reutrn-true-when-check-format.patch \
	file://0002-kmssink-add-render_rectangle-and-show-fps-for-qt.patch \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
FILESPATH_prepend := "${THISDIR}/${PN}:"
