class User {
    var name = ""
    var email = ""
    var password = ""
        set(value) {
            field = "$value${(1000..9999).random()}"
            println("Password Saved")
        }
        get() = field.dropLast(4)
}