package lesson_02_class_lambda_generic

fun main() {
    val book = Book("Pushkin")
    val magazine = Magazine("Vogue")
    val calendar = Calendar(2024)
    val box1 = Box(book)
    val list = listOf("string", book, magazine)
    CustomAssertion().simpleAssertion(magazine, list)

    val (status, result) = getStatusWithResult()
}

// В скобках обпределяем, что нам может прийти экземпляр класса, наследованный от Пейпер
class Box<T : Paper>(item: T) {
    var open = false
    private var things = item

    fun fetch(): T? {
        return things.takeIf { open }
    }
}

abstract class Paper {}

data class Book(
    val author: String
) : Paper()

data class Magazine(
    val publisher: String
) : Paper()

data class Calendar(
    val year: Int
)

class CustomAssertion {
    inline fun <reified T> simpleAssertion(item: T, list: List<Any>) {
        val thing = list.last()
        if (thing is T) println(item) else println("incorrect")
    }
}

fun getStatusWithResult(): Pair<Int,String> {
    return Pair(200, "String")
}
