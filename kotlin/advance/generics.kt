// Kotlin - Generics exercises (generic function, class, and upper bounds)
// Exercise 1: generic function
fun <T> logValue(value: T) { println("Retrieved value: ${'$'}value") }

// Exercise 2: generic class GoodVault<T>
class GoodVault<T>(private val data: T) {
    fun getData(): T = data
}

// Exercise 3: ByteConvertible + computeHash
interface ByteConvertible { fun toBytes(): ByteArray }

data class User(val username: String) : ByteConvertible { override fun toBytes() = username.toByteArray() }
data class FileContent(val content: String) : ByteConvertible { override fun toBytes() = content.toByteArray() }

fun <T : ByteConvertible> computeHash(data: T) {
    val md = java.security.MessageDigest.getInstance("SHA-256")
    val hash = md.digest(data.toBytes())
    println("Hashing ${'$'}{data.toBytes().size} bytes: " + hash.joinToString("") { String.format("%02x", it) })
}

fun main() {
    logValue("admin_user")
    logValue(401)
    logValue(false)

    val stringVault = GoodVault("MyPassword")
    val intVault = GoodVault(123456)
    val password: String = stringVault.getData()
    val pin: Int = intVault.getData()
    println("password:${'$'}password pin:${'$'}pin")

    computeHash(User("alice"))
    computeHash(FileContent("file data"))
    // computeHash("test") // won't compile - String is not ByteConvertible
}
