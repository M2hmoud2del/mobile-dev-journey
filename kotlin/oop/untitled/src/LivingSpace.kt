abstract class LivingSpace {
    abstract fun printDetails()

    fun acceptPolicy(isAccepted: Boolean){
        println("Accept terms and conditions: $isAccepted")
    }
}