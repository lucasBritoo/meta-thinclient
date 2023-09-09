DESCRIPTION = "ThinClient image with Qt Graphics QPA EGLFS"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Busca o arquivo com os pacotes
require qt5.inc

# PAcotes adicionais na imagem
IMAGE_FEATURES += " \
                   eclipse-debug \
                   package-management \
                   ssh-server-openssh \
                   splash \
		           tools-sdk \
                   curl \
                   net-tools \
                   "

IMAGE_LINGUAS = "en-us"

# SystemD inicia no modo múltipo usuário sem interface gráfica
SYSTEMD_DEFAULT_TARGET = "multi-user.target"

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

# 
export IMAGE_BASENAME = "thinclient-image"

inherit extrausers 

# Define senha do usuario root como r00t
# Cria um novo usuario e atribui o usuario ao grupo root
EXTRA_USERS_PARAMS = " \
                      usermod -P 'r00t' root; \
                      useradd -U -m -P 'dev123' dev; \
                      usermod -aG root dev; \
                      "

inherit core-image populate_sdk_qt5 updatehub-image
