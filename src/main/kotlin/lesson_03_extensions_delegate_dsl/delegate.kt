package lesson_03_extensions_delegate_dsl

import kotlin.properties.Delegates

fun main() {
    val studen = Studen()
    println(studen.name)
    println(studen.name)

    studen.course = "Biology"

    println(studen.age)
    studen.age = 21
    studen.age = 17
    println(studen.age)

}

class Studen {

    // Ключевое слово by lazy служит для отложенной инициализации через механизм делегатов.
// Делегат lazy принимает лямбда-выражение с кодом, который вы бы хотели выполнить для инициализации свойства.
    val name: String by lazy {
        println("lazy delegate")
        "name"
    }

    // Observable выполняет лямбду при изменениях переменной
    var course: String by Delegates.observable("Not set") { property, old, new ->
        println("$old -> $new")
    }

    // vetoable накладывает вето на изменение значения
    var age: Int by Delegates.vetoable(18) { property, oldValue, newValue ->
        newValue > oldValue
    }
}
