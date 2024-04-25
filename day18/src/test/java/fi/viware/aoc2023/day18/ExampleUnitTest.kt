package fi.viware.aoc2023.day18

import org.junit.Test

import org.junit.Assert.*
import kotlin.math.abs

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

    fun shoeLaceAreaTest() {

        fun shoelaceAreaRosetta(outline: List<Pair<Long, Long>>): Double {
            val n = outline.size
            var a = 0.0
            for (i in 0 until n - 1) {
                val prevSum = a
                a += outline[i].first * outline[i + 1].second - outline[i + 1].first * outline[i].second
                if (i in listOf(2, 3))
                    print("$i: $prevSum += ${outline[i].first} * ${outline[i + 1].second} - ${outline[i + 1].first} * ${outline[i].second} = $a, ")
            }
            println()
            return Math.abs(a + outline[n - 1].first * outline[0].second - outline[0].first * outline[n -1].second) / 2.0
        }

        fun shoelaceArea(outline: List<Pair<Long, Long>>): Long {
            var sum = 0L

            for (i in outline.indices) {
                val prevSum = sum
                sum += outline[i].first * outline[(i + 1) % outline.size].second - outline[(i + 1) % outline.size].first * outline[i].second
            }
            return Math.abs(sum) / 2
        }

        //461937+56407+356671+863240+367720+266681+577262+829975+112010+829975+491645+686074+5411+500254
        //6405262
        fun numPointsInOutline(outline: List<Pair<Long, Long>>): Long{
            var numPoints = 0L
            outline.forEachIndexed { i, pair ->
                numPoints += abs(outline[i].first - outline[(i + 1) % outline.size].first)
                numPoints += abs(outline[i].second - outline[(i + 1) % outline.size].second)
            }
            return numPoints
        }

        val polygonOutline = listOf(
            Pair(0L, 0L),
            Pair(461937L, 0L),
            Pair(461937L, 56407L),
            Pair(818608L, 56407L),
            Pair(818608L, 919647L),
            Pair(1186328L, 919647L),
            Pair(1186328L, 1186328L),
            Pair(609066L, 1186328L),
            Pair(609066L, 356353L),
            Pair(497056L, 356353L),
            Pair(497056L, 1186328L),
            Pair(5411L, 1186328L),
            Pair(5411L, 500254L),
            Pair(0L, 500254L),
            Pair(0L, 0L)
        )

        val polygonOutline2 = listOf(
            Pair(3L, 4L), Pair(5L, 11L), Pair(12L, 8L), Pair(9L, 5L),  Pair(5L, 6L)
        )

        val AreaRosettCode = shoelaceAreaRosetta(polygonOutline)
        println("Polygon AreaRosettCode: $AreaRosettCode")
        val AreaChatGpt = shoelaceArea(polygonOutline)
        println("Polygon AreaChatGpt: $AreaChatGpt")
        val numOutlinePoints = numPointsInOutline(polygonOutline)
        println("$numOutlinePoints, ${numOutlinePoints + AreaChatGpt}")

    }


}