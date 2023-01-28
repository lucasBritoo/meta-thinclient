DESCRIPTION = "Simple Application with QtQuick2"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit qmake5 systemd

SRC_URI += " \
            git://github.com/b2open/simpleqtquick2cpp.git \
            file://myapp.service \
            "
SRCREV = "f968d95b1f9227d277829cd22d13defbe4c514ce"

S = "${WORKDIR}/git"

DEPENDS = "\
           qtbase \
           qtdeclarative \
           qtquickcontrols2 \
           "

RDEPENDS_${PN} = "\
    qtbase \
    qtvirtualkeyboard \
    qtquickcontrols2-qmlplugins \
    qtgraphicaleffects-qmlplugins \
    qttools-tools \
    "

do_install_append() {
  install -m 0755 -d ${D}${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/myapp.service ${D}${systemd_unitdir}/system/
}

FILES_${PN} += "\
    /opt/simpleqtquick2cpp/bin \
    "

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_AUTO_ENABLE = "disable"
SYSTEMD_SERVICE_${PN} = "myapp.service"

