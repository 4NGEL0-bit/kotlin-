fun main() {
   
    val usernames = listOf("adam", "ismail", "youssef", "walid")
    val logintimes = listOf("3", "2", "10", "11")
    val access = listOf("OK", "FAIL", "OK", "FAIL")
   
    val map: Map<String, Pair<String, String>> = usernames.indices.associate { i ->
        usernames[i] to (logintimes[i] to access[i])
    }
    
    println(String.format("%-10s | %-10s | %-12s", "username", "login time", "Access Results"))
    println("-".repeat(36))
    for ((username, pair) in map) {
        println(String.format("%-10s | %-10s | %-12s", username, pair.first, pair.second))
    }
    println("-".repeat(36))
    
    val filter = map.filter { entry -> entry.value.second == "FAIL" }
    println("failed logins:\n" + filter)
    
    val counts = map.entries.groupBy { it.value.second }.mapValues { it.value.size }
    println("Counts per access result:")
    counts.forEach { (result, count) -> println("$result -> $count")
    }
}