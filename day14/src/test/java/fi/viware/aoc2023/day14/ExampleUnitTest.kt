package fi.viware.aoc2023.day14

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

    @Test
    fun tst() {

        val map: MutableMap<Int, MutableList<Int>> = mutableMapOf(
            1 to mutableListOf(1, 2, 3),
            2 to mutableListOf(4, 5, 6, 7),
            3 to mutableListOf(8, 9)
        )

        val (avain, lista) = map.maxByOrNull { it.value.size }
            ?: throw NoSuchElementException("Map ei sisällä arvoja")

        println("Pisin lista on avaimella $avain: $lista")
    }
}