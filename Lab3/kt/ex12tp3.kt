package AdamMentaguiLab3.kt
//defining the calculator class
class Calculator(){
    //defining the addition function for integers
    fun add(a: Int, b: Int): Int {
        return a + b
    }
    //defining the addition function for doubles
    fun add(a: Double, b: Double): Double {
        return a + b
    }
}

fun main(){
    //creating the object
    val calculator = Calculator()
    //calling each function with its perspective attributes
    println("First addition operation with integer: ${calculator.add(5,10)}")
    println("Second addition operation with double: ${calculator.add(5.5,10.5)}")
}