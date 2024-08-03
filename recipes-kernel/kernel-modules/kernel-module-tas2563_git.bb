SUMMARY = "TI TAS256x Driver"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://tas2563-codec.c;beginline=1;endline=20;md5=466a52cbb9f70fc1a7869a2a467b01b2"

inherit module

#SRC_URI = "git://git.ti.com/tas256xsw-android/tas2563-android-driver.git;branch=master \
#           file://makefile.patch \
#          "
#SRCREV = "7fd160643990d86c8cd584e13167b639f04fd23e"
SRC_URI = "git://github.com/DynamicDevices/tas2563-android-driver.git;branch=master;protocol=https \
	   file://tas2563_uCDSP.bin \
           file://01-fix-nxp-build.patch \
          "
SRCREV = "df070a7437fa27b9e253fc5b087a56411b68216b"

S = "${WORKDIR}/git"

do_configure() {
}

do_install:append() {
  install -d ${D}${nonarch_base_libdir}/firmware
  install -m 755 ${WORKDIR}/tas2563_uCDSP.bin ${D}${nonarch_base_libdir}/firmware
}

FILES:${PN} += "${nonarch_base_libdir}/firmware/tas2563_uCDSP.bin" 

KERNEL_MODULE_AUTOLOAD:append = "snd-soc-tas2563"
