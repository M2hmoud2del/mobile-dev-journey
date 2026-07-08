import java.time.LocalDate

/*
* Mission
* Write a program that prints the grade of a student,
    * if his total is above or equals to 90 then print A+,
        * if his total is above or equals to 75 then print B,
            * if his total is above or equals to 50 then print D+
                * , otherwise print D
* • Assume that the student has a `total` of 72
* • Solve this mission using if, else & when expressions.
* */

fun main(){

   print("Enter your total grade: ")
   val total = readln().toInt()
    // If-Else
   if(total in 90..100)println("A+")
   else if(total in 75..90)println("B")
   else if(total in 50..75)println("D+")
   else println("D")
    // When
   when(total){
       in 90..100 -> println("A+")
       in 75..90 -> println("B")
       in 50..75 -> println("D+")
       else -> println("D")
   }

}