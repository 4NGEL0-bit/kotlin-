fun main() {
   
    var count1 = 0
    var count2 = 0
    var count3 = 0
    
    print("enter your sentence:\n")
    val str = readlnOrNull()?.lowercase() ?: ""
    
    for (ch in str) {
        if (ch.isDigit()) {
            count1 += 1
        } else if (ch in "aeiou") {
            count2 +=1
        } else if (ch == ' '){
            count3 +=1
        } else{
            continue
        }
    }
    
    print("digit counts :$count1.vowel counts : $count2.space counts: $count3\n")
    
    if ("admin" in str.lowercase() ) {
        val rev = "admin".reversed()
        val newStr = str.replace("admin", rev, ignoreCase = true)
        print("warning message \n")
        println("the new sentence : $newStr")
    }

}