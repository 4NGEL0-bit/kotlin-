// ===== FROM EXERCISE 1 (We need these classes) =====

// Base Class
open class SecurityThreat(
    val id: String,
    val severity: Int,
    val description: String
) {
    open fun getSummary(): String {
        return "Threat $id - Severity: $severity - $description"
    }
}

// Malware Threat Class
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

// Network Threat Class
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


// ===== EXERCISE 3 STARTS HERE =====

// STEP 1: Create abstract class
// 'abstract' means "I'm incomplete - my children must finish me"
abstract class ThreatAnalyzer {
    // Abstract method = No body, children MUST implement it
    abstract fun analyze(threat: SecurityThreat): Boolean
}


// STEP 2A: MalwareAnalyzer - specializes in malware
class MalwareAnalyzer : ThreatAnalyzer() {

    override fun analyze(threat: SecurityThreat): Boolean {
        // Check if the threat is a MalwareThreat using 'is' keyword
        if (threat is MalwareThreat) {
            // If yes, we can access MalwareThreat-specific properties
            println("Scanning files: ${threat.infectedFiles}...")
            return true  // Successfully analyzed
        } else {
            // If no, we can't analyze it
            println("Cannot analyze non-malware")
            return false  // Failed to analyze
        }
    }
}


// STEP 2B: NetworkAnalyzer - specializes in network threats
class NetworkAnalyzer : ThreatAnalyzer() {

    override fun analyze(threat: SecurityThreat): Boolean {
        // Check if the threat is a NetworkThreat using 'is' keyword
        if (threat is NetworkThreat) {
            // If yes, we can access NetworkThreat-specific properties
            println("Blocking IP: ${threat.ipAddress}...")
            return true  // Successfully analyzed
        } else {
            // If no, we can't analyze it
            println("Cannot analyze non-network threat")
            return false  // Failed to analyze
        }
    }
}


// STEP 3: Test it!
fun main() {
    // Create analyzers
    val malwareAnalyzer = MalwareAnalyzer()
    val networkAnalyzer = NetworkAnalyzer()

    // Create threats
    val malwareThreat = MalwareThreat(
        "M001",
        8,
        "Virus detected",
        "Ransomware",
        listOf("file1.txt", "file2.txt")
    )

    val networkThreat = NetworkThreat(
        "N001",
        5,
        "Port scan detected",
        "192.168.1.1",
        80
    )

    println("=== Threat Analysis Demo ===\n")

    // Test 1: Pass MalwareThreat to MalwareAnalyzer (should work!)
    println("Test 1: MalwareAnalyzer analyzing MalwareThreat")
    val result1 = malwareAnalyzer.analyze(malwareThreat)
    println("Result: $result1\n")

    // Test 2: Pass MalwareThreat to NetworkAnalyzer (should fail!)
    println("Test 2: NetworkAnalyzer analyzing MalwareThreat")
    val result2 = networkAnalyzer.analyze(malwareThreat)
    println("Result: $result2\n")

    // Test 3: Pass NetworkThreat to MalwareAnalyzer (should fail!)
    println("Test 3: MalwareAnalyzer analyzing NetworkThreat")
    val result3 = malwareAnalyzer.analyze(networkThreat)
    println("Result: $result3\n")

    // Test 4: Pass NetworkThreat to NetworkAnalyzer (should work!)
    println("Test 4: NetworkAnalyzer analyzing NetworkThreat")
    val result4 = networkAnalyzer.analyze(networkThreat)
    println("Result: $result4")
}