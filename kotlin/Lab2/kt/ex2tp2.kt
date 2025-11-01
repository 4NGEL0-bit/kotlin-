fun main(){
   
     var score = 0
     val scores= mutableListOf<Int>()
   
    while(true){
       
        print("enter the score between 0 and 100 (-1 to exit):")
        val input  = readlnOrNull()
        score = input?.toIntOrNull() ?: 0
       
        if (score ==-1)break
       
        if (score < 0 || score > 100){
            print("out of the range,retry.")
            continue
        }
       
        scores.add(score)
    }
    
    val avg = scores.average()
    
     when{
        avg in 90.0..100.0 -> println("Excellent : $avg ")
        avg in 70.0..89.0 -> println("Good : $avg ")
        avg in 50.0..69.0 -> println("Fair : $avg ")
        else -> println("Fail : $avg ")
    }
 }