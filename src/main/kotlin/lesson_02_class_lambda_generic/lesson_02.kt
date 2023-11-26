package lesson_02_class_lambda_generic

fun main() {
    val student1 = Student(Id(2),"Ivan", Faculty.BIOLOGY, false)
    val student2 = Student(Id(3),"Petr", Faculty.CHEMISTRY, true)
    student1.learn()

    println(student2.faculty.vacultyId.id)

    student1.faculty = Faculty.MATH

    println(Student.Companion.counter)

    println(student1)
    -student1
    println(student1)
}

interface Action {
    fun learn() {
        println("Learning")
    }
}

abstract class Human {
    abstract fun eat()
    abstract fun sleep()
}

// наследование абстрактного класса
open class Person : Human() {
    open val fio: String = "FIO"

    override fun eat() {
        println("Eating")
    }

    override fun sleep() {
        println("Sleeping")
    }

    open fun read() {
        println("Reading")
    }
}

// наследование класса, иплементация интерфейса.
// Имплементировать можно несколько интерфейсов
// Дата классы - классы для хранения данных
data class Student(
    val id: Id,
    val name: String,
    var faculty: Faculty,
    var expelled: Boolean = false
) : Person(), Action {

    override val fio = ""

    // на класс мб только 1 компаньон обжект,
// где определяются все статические переменные
    companion object {
        var counter: Int = 0
    }

// блок инициализации
    init {
        counter++
    }

//переопределение оператора
    operator fun unaryMinus() {
        this.expelled = true
    }

    override fun learn() {
        println("Learning material")
    }

}