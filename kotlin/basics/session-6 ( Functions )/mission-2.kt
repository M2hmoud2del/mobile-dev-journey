/*
• Write a program that contains two strings “Hello” and the other
one is “Candroid”
• Send the 1st string as a parameter to a function called “check”, the
function checks if the received string contains letter ‘a’ so it will
return true, otherwise the function will return false.
• Do the same steps for the 2nd string.
• Your main function will print the returned result.
*/

fun main() {
    println(isAExists("Hello"))
    println(isAExists("Candroid"))
}
fun isAExists(str: String) = "a" in str