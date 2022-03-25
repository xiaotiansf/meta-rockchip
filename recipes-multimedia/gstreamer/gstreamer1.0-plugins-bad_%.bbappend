SRC_URI += " \
    file://0001-kmssink-Add-24bit-RGB-support.patch \
    file://0002-waylandsink-support-fullscreen.patch \
    file://0003-waylandsink-relaxed-wl_shell-check-and-added-zwp_ful.patch \
    file://0004-kmssink-configure-mode-setting-from-video-info.patch \
    file://0005-kmssink-add-connector-properties-prop.patch \
    file://0006-kmssink-Generalize-setting-DRM-object-properties.patch \
    file://0007-kmssink-Add-plane-properties-property.patch \
    file://0008-kmssink-Escape-DRM-property-names.patch \
    file://0009-kmssink-Add-restore-crtc-property.patch \
    file://0010-kmssink-Avoiding-get_property-to-take-ownership-of-o.patch \
    file://0011-waylandsink-Avoid-race-condition-on-multi-threaded-c.patch \
    file://0012-kmssink-fix-tmp_kmsmem-leaks.patch \
    file://0013-kmssink-Accept-underscore-in-property.patch \
    file://0014-waylandsink-Don-t-create-throwaway-empty-regions.patch \
    file://0015-waylandsink-prefix-wl_shell-specific-variables-with-.patch \
    file://0016-waylandsink-Implement-XDG-shell-stable-support.patch \
    file://0017-waylandsink-Wait-for-the-surface-to-be-configured.patch \
    file://0018-waylandsink-make-gst_wl_window_is_toplevel-aware-of-.patch \
    file://0019-wayland-wlbuffer-just-return-if-used_by_compositor-i.patch \
    file://0020-kmssink-Fixup-all-errno-tracing.patch \
    file://0021-Revert-waylandsink-Don-t-create-throwaway-empty-regi.patch \
    file://0022-wayland-Drop-big-endian-version-of-the-DRM-formats.patch \
    file://0023-wayland-Add-more-DRM-formats.patch \
    file://0024-waylandsink-Commit-the-parent-after-creating-subsurf.patch \
    file://0025-wlvideoformat-clean-up-video-formats.patch \
    file://0026-waylandsink-Fix-xdg_shell-fullscreen-mode.patch \
    file://0027-waylandsink-Clear-window-when-pipeline-is-stopped.patch \
    file://0028-waylandsink-add-wl_registry.global_remove-listener.patch \
    file://0029-kmssink-Fix-implicit-declaration-build-error.patch \
    file://0030-kmssink-Ensure-we-have-an-allocator-before-importing.patch \
    file://0031-kmssink-Avoid-drain-on-caps-changes.patch \
    file://0032-kmssink-Do-not-drain-if-imported-buffer-are-from-KMS.patch \
    file://0033-kmssink-Fix-crash-with-force-modesetting-1.patch \
    file://0034-kmssink-Save-last-metadata-at-the-same-time-as-the-l.patch \
    file://0035-kmssink-fix-memory-leak-on-failing-allowed-caps.patch \
    file://0036-wlvideoformat-fix-typo-in-the-format-list.patch \
    file://0037-waylandsink-Keep-per-display-wayland-buffer-caches.patch \
    file://0038-waylandsink-use-GstMemory-instead-of-GstBuffer-for-c.patch \
    file://0039-waylandsink-Update-stale-GstBuffer-references-in-way.patch \
    file://0040-waylandsink-release-frame-callback-when-destroyed.patch \
    file://0041-wlvideoformat-fix-DMA-format-convertor.patch \
    file://0042-fix-h265_parser-read-vui-error.patch \
    file://0043-interim-fix-vc1-stream-may-memory-leak-when-pending.patch \
    file://0044-kmssink-Support-render-rectangle-for-plane.patch \
    file://0045-waylandsink-Only-check-for-dmabuf-format-when-availa.patch \
    file://0046-kmssink-Request-window-handle.patch \
    file://0047-waylandsink-Support-place-below-above.patch \
    file://0048-waylandsink-Enable-changing-window-handle.patch \
    file://0049-kmssink-Support-setting-plane-zpos.patch \
    file://0050-waylandsink-Convert-xdg-shell-to-unstable-zxdg-shell.patch \
    file://0051-waylandsink-Support-setting-toplevel-window-position.patch \
    file://0052-Bump-dtls-sctp-webrtc-to-upstream.patch \
    file://0053-HACK-gstmpegvideoparse-Split-every-picture.patch \
    file://0054-mpegtsdemux-Create-new-PCR-group-for-big-gap.patch \
    file://0055-gstjpegparse-Allow-parsebin-to-use-it-for-autopluggi.patch \
    file://0056-kmssink-Support-disabling-vsync.patch \
    file://0057-waylandsink-Drop-frame-when-window-not-ready.patch \
    file://0058-waylandsink-Only-set-viewport-destination-for-valid-.patch \
    file://0059-waylandsink-Fix-multiple-random-crashes.patch \
    file://0060-camerabin2-Support-setting-default-filters.patch \
    file://0061-waylandsink-Defer-prepare-window-when-getting-zero-w.patch \
    file://0062-mpegts-Add-a-property-to-ignore-broken-PCR-streams.patch \
    file://0063-waylandsink-Support-window-layer-property.patch \
    file://0064-waylandsink-Support-stretching-video-area.patch \
    file://0065-waylandsink-Support-window-alpha-property.patch \
    file://0066-waylandsink-Support-window-fill-mode-property.patch \
    file://0067-HACK-kmssink-Open-drm-devnode-directly.patch \
    file://0068-kmssink-Support-NV12_10LE40.patch \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
FILESPATH_prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG[kms] = "--enable-kms,--disable-kms,libdrm"
PACKAGECONFIG_remove = "vulkan"
PACKAGECONFIG += "kms"

