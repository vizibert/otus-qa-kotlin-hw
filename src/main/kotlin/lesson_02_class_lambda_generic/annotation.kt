package lesson_02_class_lambda_generic

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class TestRunning

fun main() {
    val myTestClass = TestClass()

// рефлексия - зайди во все методы (declaredMethods), сделай {} для каждого
    myTestClass::class.java.declaredMethods.forEach { func -> func.annotations.forEach {
        if (it is TestRunning)
            func.invoke(myTestClass)
    } }
}

class TestClass {

    @TestRunning
    fun testFuncWithAnnotation() {
        println("Test run")
    }

    fun testFuncWithoutAnnotations() {
        println("Test run")
    }
}
