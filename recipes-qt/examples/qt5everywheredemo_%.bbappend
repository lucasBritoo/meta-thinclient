FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
            file://qt5everywheredemo.service \
            file://qt5.default \
            "

do_install_append() {
  install -m 0755 -d ${D}${sysconfdir}/default
  install -m 0644 ${WORKDIR}/qt5.default ${D}${sysconfdir}/default/qt5

  install -m 0755 -d ${D}${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/qt5everywheredemo.service ${D}${systemd_unitdir}/system/
}

FILES_${PN} += " /lib/systemd/system "

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "qt5everywheredemo.service"
