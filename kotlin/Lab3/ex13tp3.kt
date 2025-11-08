package tpex5tp3

//we will base on the exercice 8 again, we will keep the same classes and code

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
//creating generic team which is a list and prints every student with its role(getrole())
class Team<T: Person>( val members: List<T>){
    fun displayinfo(){
        for (person in members){
            println("${person.name} : ${person.getRole()}")
        }
    }
}

fun main(){
    //creating objects
    val S = Student("Ali")
    val T = Teacher("Youssef")
    val R = Student("Johnson")
    val B = Teacher("BObo")
    val C = Teacher("Charlie")
    //creating the student team and teacher team by creating the object team class for each
    val Stud= Team(listOf(S,R))
    val Prof= Team(listOf(T,B,C))
    //displaying student team
    print("Student Team Roles:\n\n")
    Stud.displayinfo()
    //displaying teacher list
    print("Teacher  Team Roles:\n\n")
    Prof.displayinfo()
}

