//defining car class with its attributes
class Car(val brand: String, val model: String,val year:Int) {
    //defining the method function
    fun displayinfo(){
        println("brand:$brand, model:$model, year:$year")
    }
}


fun main(){
    //declaring two cars as objects
    val car1 = Car("toyota","Corolla",2020)
    val car2 = Car("Ford","Mustang",2023)
    //calling each object's method
    car1.displayinfo()
    car2.displayinfo()
}