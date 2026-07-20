/*
Send the numbers “7” & “8” as parameters to a function that
returns the largest number among them, then print the result to the
user in your main function.
*/ 
fun main() {
    print( getMax(7, 8) )
}
fun getMax(number1: Int,number2: Int) = if (number1 >= number2) number1 else number2
