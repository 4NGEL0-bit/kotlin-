//defining the class Course
class Course(val name: String,val duration:Int){
    //declaring instructor for the secondary constructor
    var instructor:String? = null
    //init block
    init{
        println("Course initialized: $name")
    }
    //defining the secondary constructor
    constructor(name: String, duration: Int = 30, instructor: String) : this(name, duration) {
        this.instructor = instructor
    }
    //defining method function
    fun showdetails(){
        println("name:$name|duration:$duration|instructor:${instructor ?: "N/A"}")
    }
}
fun main(){
    //Defining first object for the primary constructor whereas the rest second one
    val course1 = Course("OOP in Kotlin ",30)
    val course2 = Course("Mobile Dev",45,"Dr;Samir")
    val course3 = Course("AI Basics  ",60,"Prof. Ali")
    //calling method for each object
    course1.showdetails()
    course2.showdetails()
    course3.showdetails()
}