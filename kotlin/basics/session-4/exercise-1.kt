import java.time.LocalDate

/*
* Exercise - 1
* Write a program that prints all the numbers that are divisible by 6 from 1 to 100
*/

fun main(){
   for(i in 6..100 step 6)print("$i,") // Best Performance (: CPU Happy now
   println()
   for(i in 1..100)if(i % 6 == 0)print("$i,") // spends More time ;(  CPU get exhausted

}