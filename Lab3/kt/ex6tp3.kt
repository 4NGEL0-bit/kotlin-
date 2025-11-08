package AdamMentaguiLab3.kt
//creating the class student
class Student(val name:String,val age:Int){
    //initializing the map list for grades
    val grade:MutableList<Int> = mutableListOf()
    //defining a function method that adds grades to the list
    fun addGrade(entry:Int){
        grade.add(entry)
    }
    //defining  a function method that calculates the average of that map list
    fun getAverage() : Double{
        val avg:Double = grade.average()
        return avg
    }
    //defining a function method which prints avg,name and age
    fun displayStudentInfo(){
        println("Student: $name | Age: $age | Avg:${getAverage()}")
    }
}

fun main(){
    //declaring 3 objects (three students
    val stud1 = AdamMentaguiLab3.kt.Student("Adam", 21)
    val stud2 = AdamMentaguiLab3.kt.Student("Bobby", 23)
    val stud3 = AdamMentaguiLab3.kt.Student("Charlie", 24)
    //adding 3 grades on each student
    stud1.addGrade(19)
    stud1.addGrade(20)
    stud1.addGrade(30)
    stud2.addGrade(25)
    stud2.addGrade(12)
    stud2.addGrade(18)
    stud3.addGrade(30)
    stud3.addGrade(29)
    stud3.addGrade(31)
    //displaying full details of each student alongside their averages
    stud1.displayStudentInfo()
    stud2.displayStudentInfo()
    stud3.displayStudentInfo()
}