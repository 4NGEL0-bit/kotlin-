// Kotlin - Data Classes (Player, AclRule)
data class Player(val username: String, var score: Int = 0)

data class AclRule(val protocol: String, val port: Int, val action: String)

fun main() {
    // Player demo
    val p1 = Player("alice")
    val p2 = Player("bob", 10)
    val p3 = Player("alice")
    println(p1) // toString
    println("p1 == p3: ${'$'}{p1 == p3}") // equality by data
    val p1Copy = p1.copy(score = 5)
    println("p1Copy: ${'$'}p1Copy")
    println("p1 hashCode: ${'$'}{p1.hashCode()} p1Copy hashCode: ${'$'}{p1Copy.hashCode()}")

    // ACL demo using a set
    val rules = mutableSetOf<AclRule>()
    rules.add(AclRule("TCP", 443, "ALLOW"))
    rules.add(AclRule("TCP", 80, "ALLOW"))
    rules.add(AclRule("ICMP", 0, "DENY"))
    println("Rule count after initial load: ${'$'}{rules.size}")
    val duplicateRule = AclRule("TCP", 443, "ALLOW")
    rules.add(duplicateRule)
    println("Rule count after adding duplicate: ${'$'}{rules.size}")
    val sshRule = AclRule("TCP", 22, "ALLOW")
    println("Is SSH explicitly allowed? ${'$'}{sshRule in rules}")
}
