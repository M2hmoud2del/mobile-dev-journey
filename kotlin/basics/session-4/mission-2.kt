import java.time.LocalDate

/*
 * Extra Mission
 *
 * My Etisalat App is giving daily Social Megabytes gifts
 * for the users.
 *
 * Write a program that checks the current day,
 * then send the users free Social Megabytes
 * according to that day.
 *
 * It is better to use a when expression
 * when there are more than two branches,
 * and this program contains 5 branches.
 */

fun main(){

    val dayOfWeek = LocalDate.now().dayOfWeek
    when(dayOfWeek){
        java.time.DayOfWeek.SATURDAY -> println("SATURDAY: 20 Social Megabytes")
        java.time.DayOfWeek.SUNDAY -> println("SUNDAY: 25 Social Megabytes")
        java.time.DayOfWeek.MONDAY -> println("MONDAY: 25 Social Megabytes")
        java.time.DayOfWeek.TUESDAY -> println("TUESDAY: 30 Social Megabytes")
        java.time.DayOfWeek.WEDNESDAY -> println("WEDNESDAY: 30 Social Megabytes")
        else -> println("No Gift Today")
    }

}