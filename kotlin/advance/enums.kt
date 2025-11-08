// Kotlin - Enums (PlayerStatus, CommonProtocol)
enum class PlayerStatus { PLAYING, PAUSED, STOPPED }

enum class CommonProtocol(val port: Int, val isSecure: Boolean) {
    HTTP(80, false),
    HTTPS(443, true),
    FTP(21, false),
    SSH(22, true),
    DNS(53, false);
}

fun getProtocolFromPort(port: Int): CommonProtocol? = CommonProtocol.values().firstOrNull { it.port == port }

fun main() {
    val portToScan = 22
    val protocol = getProtocolFromPort(portToScan)
    if (protocol != null) {
        println("Port ${'$'}portToScan is default for ${'$'}{protocol.name}.")
        println(if (protocol.isSecure) "This is a secure protocol." else "Warning: This is an insecure protocol.")
    } else {
        println("Port ${'$'}portToScan has no common protocol assigned.")
    }
}
