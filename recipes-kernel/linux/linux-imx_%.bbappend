FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
	file://01-enable-tas2563.patch \
        file://02-add-fsl-sai-debugging.patch \
        file://04-change-tas2563-clocks.patch \
        file://05-disable-spdif.patch \
        file://06-set-hoggrp.patch \
        file://enable-kgdb.cfg \
"
#        file://03-enable-wlan.patch \
#
DELTA_KERNEL_DEFCONFIG = "enable-kgdb.cfg"
