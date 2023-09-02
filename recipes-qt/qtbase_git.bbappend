FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG_GL = "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'gles2 eglfs linuxfb kms', 'no-opengl', d)}"

DEPENDS_rpi += "userland"

PACKAGECONFIG += " \
                  accessibility \
                  dbus \
                  evdev \
                  fontconfig \
                  freetype \
                  getentropy \
                  gif \
                  glib \
                  icu \
                  jpeg \
                  libinput \
                  libpng \
                  optimize-size \
                  release \
                  sql-sqlite \
                  tools \
                  tslib \
                  xkbcommon \
                  widgets \
                  zlib \
                  "

PACKAGECONFIG_remove = "tests examples"

QT_QPA_DEFAULT_PLATFORM = "eglfs"
QT_QPA_EGLFS_INTEGRATION = "eglfs_brcm"

do_configure_prepend() {
  echo "QT_QPA_DEFAULT_PLATFORM  = ${QT_QPA_DEFAULT_PLATFORM}" >> ${S}/mkspecs/oe-device-extra.pri
  if [ -n "${QT_QPA_EGLFS_INTEGRATION}" ]; then
    echo "EGLFS_DEVICE_INTEGRATION = ${QT_QPA_EGLFS_INTEGRATION}" >> ${S}/mkspecs/oe-device-extra.pri
  fi
}

