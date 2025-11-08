package ex2tp3
//Creating the abstract class
abstract class Person{
    //create the attributes of the abstract class
    abstract val name : String
    abstract fun getRole(): String

}
//creating student  class that inherits from the abstract class
class Student(override val name: String) : Person(){
    //gives the role as student
    override fun getRole(): String {
        return "Student"
    }
}
//creating teacher   class that inherits from the abstract class
class Teacher(override val name: String) : Person(){
    //gives the role as teacher
    override fun getRole(): String {
        return "Teacher"
    }
}

fun main(){
   // val S = Person("Ali") you cannot create an object for an abstract class
    //creating two object based on the inherited classes
    val S = Student("Ali")
    val T = Teacher("Youssef")
    //priting each class getrole() method
    println("${S.name} got the role of : ${S.getRole()}")
    println("${T.name} got the role of : ${T.getRole()}")
}