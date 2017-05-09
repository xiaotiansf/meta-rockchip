DEPENDS += "${@bb.utils.contains("DISTRO_FEATURES", "wayland", " wayland-protocols", " ", d)}"

PV="1.10.4"

SRC_URI_remove = " \
	file://ensure-valid-sentinels-for-gst_structure_get-etc.patch \
	file://0001-Makefile.am-don-t-hardcode-libtool-name-when-running.patch \
	file://0001-gstreamer-gl.pc.in-don-t-append-GL_CFLAGS-to-CFLAGS.patch  \
	file://0002-glplugin-enable-gldeinterlace-on-OpenGL-ES.patch \
	file://0003-glcolorconvert-implement-multiple-render-targets-for.patch \
	file://0004-glcolorconvert-don-t-use-the-predefined-variable-nam.patch \
	file://0005-glshader-add-glBindFragDataLocation.patch \
	file://0006-glcolorconvert-GLES3-deprecates-texture2D-and-it-doe.patch \
	file://0008-gl-implement-GstGLMemoryEGL.patch \
	file://0009-glimagesink-Downrank-to-marginal.patch \
"

SRC_URI += " \
	file://0010-gl-pkg-config-don-t-advertise-all-our-dependent-libr.patch \
	file://0011-gstreamer-gl.pc.in-don-t-append-GL_CFLAGS-to-CFLAGS.patch  \
	file://0012-Makefile.am-don-t-hardcode-libtool-name-when-running.patch \
	file://0001-Prepend-PKG_CONFIG_SYSROOT_DIR-to-pkg-config-output.patch \
"

SRC_URI += " \
	file://wayland/0001-Revert-waylandsink-consider-buffer-size-when-copying.patch \
	file://wayland/0001-waylandsink-Allow-any-kind-of-FD-for-shm-memory.patch \
	file://wayland/0002-waylandsink-support-linux-dmabuf-protocol.patch \
	file://wayland/0003-waylandsink-Rework-dmabuf-support.patch \
	file://wayland/0004-wayland-fix-cflags-libs-order.patch \
	file://wayland/0005-wayland-include-drm_fourcc.h-properly-and-fix-build.patch \
	file://wayland/0006-wayland-only-use-libdrm-headers-don-t-link-to-the-li.patch \
	file://wayland/0007-meson-Build-waylandsink.patch \
	file://wayland/0008-wayland-avoid-prefix-clash-in-combined-pkg-config-ch.patch\
	file://wayland/0009-wldisplay-Don-t-compare-a-guint-with-0.patch \
	file://wayland/0010-ext-Fix-various-compiler-warnings-with-clang.patch \
	file://wayland/0011-waylandsink-fix-display-re-connection-redraw-pending.patch \
	file://wayland/0012-waylandsink-set-video-surface-opaque.patch \
	file://wayland/0013-waylandsink-consider-buffer-size-when-copying-to-wl-.patch \
	file://wayland/0014-waylandsink-fix-memory-offset-calculation-for-dmabuf.patch \
"

EXTRA_OECONF += " \
	--enable-kms \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
FILESPATH_prepend := "${THISDIR}/${PN}:"

SRC_URI[md5sum] = "2757103e57a096a1a05b3ab85b8381af"
SRC_URI[sha256sum] = "23ddae506b3a223b94869a0d3eea3e9a12e847f94d2d0e0b97102ce13ecd6966"

EXTRA_OECONF += "WAYLAND_PROTOCOLS_SYSROOT_DIR=${STAGING_DIR}/${MACHINE}"
EXTRA_OECONF[vardepsexclude] = "MACHINE"
