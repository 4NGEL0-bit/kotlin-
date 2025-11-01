fun main(){
    
    print("enter intenger:\n")
    val arr = Array(5) { readlnOrNull()?.toIntOrNull() ?: 0 }
    
    val sum = arr.sum()
    val max = arr.maxOrNull()
    val min = arr.minOrNull()
    println("sum = $sum")
    println("max = $max")
    println("min = $min")
    print("ask for the number to search on tha array:")
    
    var found = false
    val jack  = readlnOrNull()?.toIntOrNull() ?: 0
    
    for (i in arr.indices){
        
        if (jack == arr[i]){
            println("found the searched number, here is the index: $i")
            found = true
            break
        }
    }
    
    if (!found){
        print("the number doesn't exist.")}

}