PV="1.10.4"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
FILESPATH_prepend := "${THISDIR}/${PN}:"

SRC_URI_append += " \
                 file://0001-video-Add-VYUY-pixel-format.patch \
                 file://0002-WIP-video-Add-P010_10LEC-pixel-format.patch \
"

SRC_URI[md5sum] = "f6b46f8fac01eb773d556e3efc369e86"
SRC_URI[sha256sum] = "f6d245b6b3d4cb733f81ebb021074c525ece83db0c10e932794b339b8d935eb7"
