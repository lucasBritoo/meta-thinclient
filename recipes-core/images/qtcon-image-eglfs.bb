DESCRIPTION = "QtCon image with Qt Graphics QPA EGLFS"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

require qt5.inc

# Packages to develop on image: gcc, gdb, strace, make, packages -dev
# Add: dev-pkgs tools-debug tools-sdk
IMAGE_FEATURES += " \
                   eclipse-debug \
                   package-management \
                   ssh-server-openssh \
                   splash \
		   tools-sdk \
                   "

IMAGE_LINGUAS = "en-us"

SYSTEMD_DEFAULT_TARGET = "multi-user.target"

GSTREAMER_PACKAGES = " \
                      gstreamer1.0-plugins-base \
                      gstreamer1.0-plugins-bad \
                      gstreamer1.0-plugins-good \
                      "

IMAGE_INSTALL_append = " \
                        bluez5 \
                        ${GSTREAMER_PACKAGES} \
                        htop \
                        kernel-modules \
                        networkmanager \
                        pi-bluetooth \
                        ${QT5_PACKAGES} \
                        qt5everywheredemo \
                        "

export IMAGE_BASENAME = "qtcon-image-eglfs"

inherit extrausers  
EXTRA_USERS_PARAMS = " \
                      usermod -P 'r00t' root; \
                      useradd -U -m -P 'pi' raspberry; \
                      "

inherit core-image populate_sdk_qt5
