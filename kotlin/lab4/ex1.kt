
open class SecurityThreat(
    val id: String,
    val severity: Int,
    val description: String
) {
    open fun getSummary(): String {
        return "Threat $id - Severity: $severity - $description"
    }
}


class MalwareThreat(
    id: String,
    severity: Int,
    description: String,
    val type: String,
    val infectedFiles: List<String>
) : SecurityThreat(id, severity, description) {

    override fun getSummary(): String {
        return "Malware Threat: $type - Severity: $severity - Files: $infectedFiles"
    }
}


class NetworkThreat(
    id: String,
    severity: Int,
    description: String,
    val ipAddress: String,
    val port: Int
) : SecurityThreat(id, severity, description) {

    override fun getSummary(): String {
        return "Network Threat from $ipAddress:$port - Severity: $severity"
    }
}


fun main() {
    val malware = MalwareThreat(
        id = "M001",
        severity = 8,
        description = "Virus detected",
        type = "Ransomware",
        infectedFiles = listOf("file1.txt", "file2.txt")
    )

    val network = NetworkThreat(
        id = "N001",
        severity = 5,
        description = "Port scan detected",
        ipAddress = "192.168.1.1",
        port = 80
    )

    println(malware.getSummary())
    println(network.getSummary())
}