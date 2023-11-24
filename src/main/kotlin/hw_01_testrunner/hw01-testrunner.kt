package hw_01_testrunner

import kotlin.reflect.full.declaredFunctions


fun main() {
    val myRunner = MyTestRunner<Steps>()
    val mySteps = Steps()
    myRunner.runTest(steps = mySteps, test = { test() })
    println("Проверка второго класса")
    MyTestRunner<Steps2>().runTest(steps = Steps2(), test = { test() })
}

interface TestRunner<T> {
    fun runTest(steps: T, test: () -> Unit)
}

class Steps {
    fun beforeAll() {
        println("Clear cache")
    }

    fun beforeEach() {
        println("Log in")
    }

    fun afterAll() {
        println("Save logs")
    }

    fun afterEach() {
        println("Log out")
    }

    fun randomFunction() {
        println("Some random function")
    }
}
class Steps2 {
    fun beforeAll2() {
        println("Clear cache2")
    }

    fun beforeEach2() {
        println("Log in2")
    }

    fun afterAll2() {
        println("Save logs2")
    }

    fun afterEach2() {
        println("Log out2")
    }

    fun randomFunction2() {
        println("Some random function2")
    }
}

fun test() {
    println("Run test")
}

class MyTestRunner<T:Any> : TestRunner<T> {
    override fun runTest(steps: T, test: () -> Unit) {

        steps::class.declaredFunctions.filter { it.name.contains("before") }.forEach{
            println("BEFORE FUNCTION: ${it.name}")
            it.call(steps)
        }

        test.run {
            println("TEST")
            invoke()
        }

        steps::class.declaredFunctions.filter { it.name.contains("after") }.forEach{
            println("AFTER FUNCTIONS ${it.name}")
            it.call(steps)
        }
    }
}