DESCRIPTION = "Pusher client and server built on Boost.Asio"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE_1_0.txt;md5=e4224ccaecb14d942c71d31bef20d78c"

inherit externalsrc

EXTERNALSRC_pn-${PN} = "/home/yurii/dev/projects/ezloml_dev/pusher-cpp"
EXTERNALSRC_BUILD_pn-${PN} = "/home/yurii/dev/projects/ezloml_dev/pusher-cpp"

DEPENDS += " \
    boost \
    rapidjson \
    openssl \
    libcryptopp \
    curl \
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

