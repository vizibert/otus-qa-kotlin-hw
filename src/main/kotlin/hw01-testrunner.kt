import kotlin.reflect.full.declaredFunctions


fun main(args: Array<String>) {
    val myRunner = MyTestRunner()
    val mySteps = Steps()
    myRunner.runTest(steps = mySteps, test = { test() })
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

fun test() {
    println("Run test")
}

class MyTestRunner : TestRunner<Steps> {
    override fun runTest(steps: Steps, test: () -> Unit) {

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