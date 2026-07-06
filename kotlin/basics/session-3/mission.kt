/*
Mission To join the YouTube Partner Program and earn money,
 you should have 1000 subscribers at least,
  and 4000 public watch hours in the last 12 months.
   Write a program that prints whether 
   a YouTuber can join the program and earn money or not using the following variables:
    • subscriberNumber 
    • hoursWatched 
    • videoType (Ex: Public – Private – Unlisted – Members only) 
    • monthsPassed

*/

fun main() {
    print("No. of Subscribers: ")
    val subscriberNumber = readln().toInt()
    print("No. of hours watched ur videos: ")
    val hoursWatched = readln().toInt()
    print("Video Type (Ex: Public - Private - Unlisted - Members only): ")
    val videoType = readln().lowercase()
    print("Months Passed: ")
    val monthsPassed = readln().toInt()
    val canJoinProgram = subscriberNumber >= 1000 &&
            hoursWatched >= 4000 &&
            videoType == "public" &&
            monthsPassed <= 12 &&
            monthsPassed >= 0
    if (canJoinProgram) {
        println("You can join the YouTube Partner Program.")
    } else {
        println("You cannot join the YouTube Partner Program.")
    }
}