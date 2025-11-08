package tp2

//we will base on the 8th exercice

//we will keep the same classes
abstract class Person{
    abstract val name : String
    abstract fun getRole(): String

}
class Student(override val name: String) : Person(){
    override fun getRole(): String {
        return "Student"
    }
}
class Teacher(override val name: String) : Person(){
    override fun getRole(): String {
        return "Teacher"
    }
}
fun main(){
    //keeping the same objects
    val S = Student("Ali")
    val T = Teacher("Youssef")
    //creating a list which stores the objects
    val list : List<Person> =listOf(S,T)
    //creating a loop for which prints the name of the object and role based on the getrole function that is in the class chosen
    for (person in list){
        println("name:${person.name} | role : ${person.getRole()}")
    }
    //we notice that the corrected getrole() is based on the chosen object class
}