package ex5tp3

//same thing, we will base on the exercice 9's work
interface logger{
    fun log(message: String)
}
class Consolelogger : logger{
    override fun log(message: String) {
        println("[CONSOLE]: $message")
    }
}
class FileLogger : logger{
    override fun log(message: String) {
        println("[FILE]: Saving '$message' to log.txt")
    }
}
//creating a generic function
fun <T : logger> broadcast(logger: T, message: String) {
    println("Broadcasting message...")
    logger.log(message)
}


fun main(){
    //defining each class
    val Consolelogger = Consolelogger()
    val fileLogger = FileLogger()
    //calling broadcast function for each object
    broadcast(Consolelogger, "Message 1")
    broadcast(fileLogger, "Message 2")
}