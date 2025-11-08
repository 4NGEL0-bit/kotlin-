package tp2
//creating the generic that ha s apair
class  CustomPair<T, U>(val first: T,val  second: U){
    //function that displays two pairs
    fun display(){
        println("Pair: ($first, $second)")
    }
}

fun main(){
    //creating two generic class objects
    val pair1 = CustomPair("Student ID", 12345)
    val pair2 = CustomPair( "your Book object", 15.99)
    //calling function display() for each generic class object
    pair1.display()
    pair2.display()


}
