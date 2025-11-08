package AdamMentaguiLab3.kt
//this exercice is based on the exercice 3
//our main class as usual
open class Book(val title: String,val author: String){
    constructor(author: String):this("Advanced Kotlin ",author){
        println("author: $author")
    }
    init {
        println("book created: $title")
    }
}
//creating the inherited class and adding a new variable for it
class Ebook(title: String,author: String, filesize:Double) : Book(title,author){
    //init block
    init{
        println("Title:$title, Size:$filesize MB")
    }
}
fun main(){
    //calling the main class through primary and secondary constructors
    Book(" Kotlin Basics "," Mohammed Ali")
    Book("Mohammed Ali")
    //calling the inherited class
    Ebook(" Kotlin in Action"," Mohammed Ali",10.5)
}