package lesson_03_extensions_delegate_dsl

fun main() {

// функция - расширение
    fun User.printData() {
        println(name)
        println(phone)
    }

    User().apply { printData() }

    val green = "green"
    green.addWord(" apple").also { println(it) }

// здесь лямбда {} это функция которая взвращает стрингу
    green.log { " apple" }.also { println(it) }
// здесь мы передаем ссылку на другую функцию
    green.log(::printApple).also { println(it) }

// TODO: разобраться, что-то непонятное
    log {
        logMessage("Log message")
        logError("Log error")
    }
}

class User {
    val name: String = "User"
    val phone: Int = 123
}

fun String.addWord(word: String): String {
    return this + word
}

fun String.log(actions: () -> String): String {
    val result = actions()
    return "$this: $result"
}

fun printApple(): String {
    return " apple"
}

// TODO: разобраться, что-то непонятное
fun log(func: Log.() -> Unit) {
    val log = Log()
    log.func()
}

class Log {
    fun logMessage(message: String) {
        println("Logging: $message")
    }

    fun logError(error: String) {
        println("Error logging: $error")
    }
}