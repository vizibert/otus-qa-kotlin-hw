package lesson_02_class_lambda_generic

import java.io.File

fun main() {
// apply и also возвращают объект контекста.
// let, run и with возвращают результат лямбды.

// apply ссылается на объект контекста как лябда-получатель
    val file = File("test.txt").apply {
        setReadable(true)
        setExecutable(true)
        setWritable(true)
    }

// let передает контекстный объект как аргумент в лямбду
    val str = "String"
    val strLenght = str?.let{
        println("Длина строки: ${it.length}")
    }

    var list: List<String> = listOf("1", "2", "3")
    list.also { it.size }.also { it.isEmpty()}
}


