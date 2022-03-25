SRC_URI += " \
    file://0001-qtdemux-don-t-skip-the-stream-duration-longer-than-3.patch \
    file://0002-flacparse-invalid-metadata-127-continue-parse.patch \
    file://0003-autodetect-Add-preferred-for-autovideosink-autoaudio.patch \
    file://0004-rtpmanager-Bump-to-upstream.patch \
    file://0005-v4l2-Support-preferred-formats.patch \
    file://0006-video-flip-Support-rockchip-RGA-2D-accel.patch \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
FILESPATH_prepend := "${THISDIR}/${PN}:"
