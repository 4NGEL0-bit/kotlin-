fun main(){
    while(true){
        //input for the entries
        print("enter your username")
        val username = readlnOrNull()
        print("enter your password")
        val password = readlnOrNull()
        
        if(username.isNullOrBlank() || password.isNullOrBlank()){
            print("username or password required\n")
            continue
        }
        //declared a variable which takes the password's length
        val len=password.length
        
        when{
            len < 6-> print("weak")
            len in 6..9-> print("medium")
            len >= 10 && password.any { it.isDigit() } -> print("strong")
            else->print("error")
        }
       
  }
}