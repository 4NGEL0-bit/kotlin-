// Kotlin - Extension Functions (Exercises from LAB_Ad_concepts___.pdf)
// Implements: String.whisper(), ByteArray.toHexString(), String.hexToByteArray(), String.toSHA256(), String.isAlphanumeric(), String.containsSafeCharsOnly()
import java.security.MessageDigest

fun String.whisper(): String = this.lowercase() + "..."

fun ByteArray.toHexString(): String = this.joinToString("") { String.format("%02x", it) }

fun String.hexToByteArray(): ByteArray {
    require(length % 2 == 0) { "Hex string must have even length" }
    return chunked(2).map { it.toInt(16).toByte() }.toByteArray()
}

fun String.toSHA256(): String {
    val md = MessageDigest.getInstance("SHA-256")
    val hash = md.digest(this.toByteArray(Charsets.UTF_8))
    return hash.toHexString()
}

fun String.isAlphanumeric(): Boolean = this.all { it.isLetterOrDigit() }

fun String.containsSafeCharsOnly(allowed: Set<Char>): Boolean = this.all { it in allowed }

// Quick demo main
fun main() {
    println("HELLO".whisper()) // hello...
    val data = byteArrayOf(0xDE.toByte(), 0xAD.toByte(), 0xBE.toByte(), 0xEF.toByte())
    val hex = data.toHexString()
    println(hex) // deadbeef
    println(hex.hexToByteArray().contentEquals(data))
    println("Kotlin is great for security".toSHA256())
    println("user123".isAlphanumeric())
    println("user_123".isAlphanumeric())
    val safe = setOf('a','b','c','.','_','1','2','3')
    println("abc_123.abc".containsSafeCharsOnly(safe))
}
