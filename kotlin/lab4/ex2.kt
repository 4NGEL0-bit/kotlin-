// STEP 1: Create Logger interface
// Interface = A promise: "Whoever uses me MUST have a log() method"
interface Logger {
    fun log(message: String, level: String)
}

// STEP 2: Create Authenticator interface
// Another promise: "Whoever uses me MUST have a login() method"
interface Authenticator {
    fun login(username: String, password: String): Boolean
}

// STEP 3: Create SecurityAdmin class that implements BOTH interfaces
// This class MUST have both log() and login() methods
class SecurityAdmin : Logger, Authenticator {

    // Implementing the log() method from Logger interface
    override fun log(message: String, level: String) {
        println("[$level]: $message")
    }

    // Implementing the login() method from Authenticator interface
    override fun login(username: String, password: String): Boolean {
        // Simple check: username must be "admin" and password must be "12345"
        return username == "admin" && password == "12345"
    }
}

// STEP 4: Test it!
fun main() {
    // Create a SecurityAdmin object
    val admin = SecurityAdmin()

    println("=== Security System Demo ===\n")

    // Test 1: Successful login
    val username1 = "admin"
    val password1 = "12345"
    val loginSuccess = admin.login(username1, password1)

    if (loginSuccess) {
        admin.log("User '$username1' logged in successfully", "INFO")
    } else {
        admin.log("Failed login attempt for user '$username1'", "WARNING")
    }

    println() // Empty line for spacing

    // Test 2: Failed login (wrong password)
    val username2 = "admin"
    val password2 = "wrongpassword"
    val loginFailed = admin.login(username2, password2)

    if (loginFailed) {
        admin.log("User '$username2' logged in successfully", "INFO")
    } else {
        admin.log("Failed login attempt for user '$username2'", "WARNING")
    }

    println() // Empty line

    // Test 3: Failed login (wrong username)
    val username3 = "hacker"
    val password3 = "12345"
    val loginFailed2 = admin.login(username3, password3)

    if (loginFailed2) {
        admin.log("User '$username3' logged in successfully", "INFO")
    } else {
        admin.log("Failed login attempt for user '$username3'", "ERROR")
    }
}