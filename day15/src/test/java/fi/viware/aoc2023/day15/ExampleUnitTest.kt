package fi.viware.aoc2023.day15

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    class OmaLuokka {
        companion object {
            fun omaFunktio() {
                println("Tämä on oma funktio")
            }
        }
    }

    @Test
    fun main() {
        val muuttuja: () -> Unit = OmaLuokka.Companion::omaFunktio
        muuttuja() // Kutsutaan funktiota muuttujan avulla
    }
}