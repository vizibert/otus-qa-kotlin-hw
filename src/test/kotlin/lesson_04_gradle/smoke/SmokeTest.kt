package lesson_04_gradle.smoke

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Tag
import kotlin.test.Test

class SmokeTest {

    @Test
    @Tag("positive")
    fun testSmokeSampleOne() {
        Assertions.assertTrue(true)
    }

    @Test
    fun testSmokeSampleTwo() {
        Assertions.assertTrue(true)
    }
}