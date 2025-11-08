//defining class student alongside its attributes
class Student(val name: String, val age:Int) {
    //defining init  as the init block of this class
    init {
        println("New student registered: $name, age $age")
    }
    //defining function method for this class
    fun displayinfo(){
        println("Student: $name| Age: $age")
    }
}
fun main(){
    //declaring 2 students as objects
    val stud1 = Student("Sara",20)
    val stud2 = Student("Ali", 21)
    //calling each object's method
    stud1.displayinfo()
    stud2.displayinfo()
}