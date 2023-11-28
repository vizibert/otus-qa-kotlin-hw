/*
1 Реализуйте расширение для Kotest, которое позволить повторить запуск тестов, в которых произошла ошибка.
2 Создайте класс RepeatOnFailureExtension, который импементирует TestCaseExtension
3 Создайте внутри класса переменную максимального количества перезапусков. Значение - любое на ваш выбор.
4 Переопределите метод intercept так, чтобы если результат выполнения теста - ошибка или неудача - тест перепрогонялся заново заданное в пункте 2 количество раз.
5 Примените данное расширение ко всем тестам в проекте.
6 Напишите минимум 1 позитивный и 1 негативный тест с использованием данного расширения
*/

package hw_03_kotest_extension

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.extensions.Extension
import io.kotest.core.extensions.TestCaseExtension
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import io.kotest.matchers.shouldBe

class TestSample : AnnotationSpec() {

    @Test
    fun test1() {
        1 shouldBe 1
    }

    @Test
    fun test2() {
        3 shouldBe 2
    }
}

object RepeatOnFailureExtension : TestCaseExtension {
    private var maxAttempt = 2

    override suspend fun intercept(testCase: TestCase, execute: suspend (TestCase) -> TestResult): TestResult {
        var result = execute(testCase)
        println("first attempt")
        while (maxAttempt !=0 && result.isErrorOrFailure) {
            println("New attempt")
            result = execute(testCase)
            maxAttempt--
        }
        return result
    }
}

object MyConfig : AbstractProjectConfig() {
    override fun extensions(): List<Extension> = listOf(RepeatOnFailureExtension)
}