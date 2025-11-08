package AdamMentaguiLab3.kt
//defining the interface
interface logger{
    //defining the interface function
    fun log(message: String)
}
//implementing the interface to the first class
class Consolelogger : logger{
    //prints the message using the interface function
    override fun log(message: String) {
        println("[CONSOLE]: $message")
    }
}
//implementing the interface to the second class
class FileLogger : logger{
    //prints the message using the interface function
    override fun log(message: String) {
        println("[FILE]: Saving '$message' to log.txt")
    }
}

fun main(){
    //defining each class and calling their function log()
    val Consolelogger = Consolelogger()
    Consolelogger.log("Exercice")
    val fileLogger = FileLogger()
    fileLogger.log("Hello World")

}