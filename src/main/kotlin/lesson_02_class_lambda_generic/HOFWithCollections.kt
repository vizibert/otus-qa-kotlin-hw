package lesson_02_class_lambda_generic

// forEach(), map(), filter(), groupBy(), fold(), and sortedBy()
// .first, .last(), .partition(), .zip() - делает хэш мапу
// .flatMap, .take(), .dropLast()

fun main() {

    val list = mutableListOf(1, 2, 3, 4)

// filter создаст новый список
    val list1 = list.filter { (it > 2) }

// The Kotlin List.map() function returns a list containing the results of applying the given transform
// function to each element in the original list.
    val list2 = list1.map { it.toDouble() }
    println(list2)
}

