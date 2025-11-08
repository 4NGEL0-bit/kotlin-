//defining the class Book
class Book(val title: String,val author: String){
    //defining the secondary constructor
    constructor(author: String):this("Advanced Kotlin ",author){
        println("author: $author")
    }
    //init block
    init {
        println("book created: $title")
    }
}
fun main(){
    //calling the primary constructor of the class book
    Book(" Kotlin Basics "," Mohammed Ali")
    //calling the secondary constructor of the class book
    Book("Mohammed Ali")
}