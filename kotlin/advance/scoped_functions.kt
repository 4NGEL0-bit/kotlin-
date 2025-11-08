// Kotlin - Scoped functions exercises (apply, let, run, with, also)
data class Logger(var prefix: String) {
    fun log(message: String) { println("[$prefix] $message") }
}

data class Person(var name: String, var age: Int, var city: String?)

fun getPeople(): List<Person> {
    println("Fetching people...")
    return listOf(Person("Eve", 22, "Paris"), Person("Frank", 33, "Tokyo"))
}

fun main() {
    // apply: configure Logger
    val infoLogger: Logger = Logger("X").apply { prefix = "INFO" }
    infoLogger.log("Application starting...")

    // let: null-safe city length
    val p1 = Person("Alice", 30, "New York")
    val p2 = Person("Bob", 40, null)
    val p1CityLength: Int = p1.city?.let { it.length } ?: 0
    val p2CityLength: Int = p2.city?.let { it.length } ?: 0
    println("P1 City Length: ${'$'}p1CityLength")
    println("P2 City Length: ${'$'}p2CityLength")

    // run: print welcome and return formatted summary or Guest
    val person = Person("Charlie", 25, "London")
    val personWithNoCity = Person("David", 50, null)
    val p1Summary: String = person.city?.run {
        println("Welcoming ${'$'}{person.name} to ${'$'}this!")
        "${'$'}{person.name} lives in ${'$'}{this.uppercase()}"
    } ?: "Guest"
    val p2Summary: String = personWithNoCity.city?.run {
        println("Welcoming ${'$'}{personWithNoCity.name} to ${'$'}this!")
        "${'$'}{personWithNoCity.name} lives in ${'$'}{this.uppercase()}"
    } ?: "Guest"
    println(p1Summary)
    println(p2Summary)

    // with: grouping calls on non-null object
    val systemLogger = Logger("SYSTEM")
    with(systemLogger) {
        log("System boot...")
        log("Loading modules...")
        log("Ready.")
    }

    // also: log size as a side-effect
    val peopleList: List<Person> = getPeople().also { println("List fetched, size = ${'$'}{it.size}") }
    println("List has ${'$'}{peopleList.size} people.")
}
