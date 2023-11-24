package lesson_01

fun main() {
    println("Otus".shuffle())
    val c = "Otus".hasLength(4)
    val d = "Otus".hasLength(4)
    println(c == d)

// проверка на налл
    var s: String? = null
    println(s?.length?.inc())

// элвис оператор дает значение по умолчанию
    var t: String? = null
    println(t?.length ?: "Non-defined")

// указание, что налла не будет
    var h: String? = ""
    println(h!!.length)

    s.isNull()

    printMessages("Hi", "Hello", "Hey")

// оператор * позволяет передать параметру элементы массива
    val messages = arrayOf("Hi", "Hello", "Hey")
    printMessages(*messages)

// ::add - ссылка на функцию
    operation(2, 3, 5, ::add)

// передача лямбды
    operation(3, 4, 7, { a, b -> a + b })
// если нет ничего то, левую часть дропаем, пример {"Hi"}
// если есть 1 аргумент, то it

// еще более короткий вариант - если функция - аргумент последняя в записи,
// то ее можно вынести за блок:
    operation(4, 4, 6) { a, b -> a + b }

}


// функция - расширение для класса Стринг
fun String.shuffle() = asIterable().shuffled().joinToString("")

// Unit - ничего, которое можно сохранить в переменную
fun String.hasLength(i: Int, message: String = "Error"): Unit {
    assert(this.length == i)
}

// функция - расширение, что что-либо (Any - прородитель всех классов) есть налл
fun String?.isNull() {
    assert(this == null)
}

// аргументы функций
fun sum(a: Int, b: Int = 5) = a + b

// варарги - переменное кол-во аргументов (список строк для этого примера)
fun printMessages(vararg messages: String) {
    for (message in messages) {
        println(message)
    }
}

fun add(a: Int, b: Int) = a + b

// функциональные аргументы
fun operation(a: Int, b: Int, expected: Int, op: (Int, Int) -> Int) {
    println("A = $a")
    println("B = $b")
    println("Expected = $expected")
    val result = op(a, b)
    assert(result == expected) { "Failed" }
    println("OK")
}