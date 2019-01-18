DESCRIPTION = "Ezlo ML"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE_1_0.txt;md5=341d1b99129987168a9b63216fcbefd5"

inherit externalsrc

EXTERNALSRC_pn-${PN} = "/home/yurii/dev/projects/ezloml_dev/ezloml"
EXTERNALSRC_BUILD_pn-${PN} = "/home/yurii/dev/projects/ezloml_dev/ezlo"

DEPENDS += " \
    webrtc \
    spdlog \
    pusher-cpp \
    cppcodec \
    rpclib \
    seeta-face-engine \
    cmake-native \
    ninja-native \
"

do_configure() {
    cd ${EXTERNALSRC}/
    mkdir -p build && cd build && cmake -GNinja ..
}

do_compile() {
    cd ${EXTERNALSRC}/build
    ninja
}

do_install() {
    install -d ${D}${includedir}
    cp -r  ${EXTERNALSRC}/pusher++/include/ ${D}${includedir}/
    cp -r  ${EXTERNALSRC}/rapidjson/rapidjson/include/ ${D}${includedir}/
}

