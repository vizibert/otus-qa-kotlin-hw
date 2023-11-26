package lesson_03_extensions_delegate_dsl

//typealias Point = Pair<Int, Int>; val (x, y) = Point (1, 2)

fun main() {

    page("https://www.ya.ru") {

        waitForLoad()

        field(".//div") {
            typeText("test")
            click()
        }
    }

}

class Page {
    fun waitForLoad() {
        println("Wait for load")
    }

}

// ограничение функций только функциями, которые могут быть применены к классу Page
// и которые ничего не принимают и ничего не возвращают
fun page(url: String, func: Page.() -> Unit) : Page {
    // здесь должны быть действия

    // вернем результат того, что сделает функция, примененная к классу page
    return Page().apply(func)
}

class Field(locator: String) {
    fun typeText(text : String) {

    }

    fun click() {

    }
}

fun field(locator: String, action: Field.() -> Unit): Field {
    val field = Field(locator)
    field.apply(action)
    return field
}