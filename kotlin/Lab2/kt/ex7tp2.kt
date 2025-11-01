fun main(){
    
    val users = mapOf("admin" to "1234", "guest" to "guest")
    val blackList = mutableSetOf<String>()
    var i = 3
    
    while(i>0){
        
        print("enter your username:\n")
        val username = readln()
        print("enter your password:\n")
        val password = readln()
        
        if(!users.containsKey(username) && !users.containsValue(password)){
            blackList.add(username)
            i-=1
            println("credentials are incorrect,$i remain\n")
        }
        
        else{
            println("credentials are correct,your permission are granted.\n")
            break
        }

    }
    
    println("blacklisted usernames:$blackList")
}