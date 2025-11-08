package tp2

import java.util.logging.Logger

//we will be based on the exercice 9, we will keep the same classes and interface
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

fun main(){
    //defining objects
    val C = Consolelogger()
    val f = FileLogger()
    //defining list that stores all objects
    val list: List<logger> = listOf(C,f)
    //based on this loop, log will print each class's sentence with the message
    for (logger in list){
        logger.log("Log")
    }
}
