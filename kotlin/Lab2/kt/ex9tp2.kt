
fun printSummary(counts: Map<String, Int>, formatter: (String, Int) -> String) {
    for ((key, value) in counts) {
        println(formatter(key, value))
    }
}
fun main(){
    
    val logs = listOf("user1:LOGIN_OK", "guest:LOGIN_FAIL")
    
    val grouped = logs.groupBy { it.substringAfter(":").split("_")[1] }
    println("users with their status:\n $grouped")
    
    val map: Map<String,Int> = grouped.mapValues { it.value.size } .mapKeys { (key, _) -> if (key == "OK") "SUCCESS" else key }
    
    printSummary(map) { key, value -> "$key logins: $value" }
}