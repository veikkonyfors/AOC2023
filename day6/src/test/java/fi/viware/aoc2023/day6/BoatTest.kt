package fi.viware.aoc2023.day6

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class BoatTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun sail(){
        val boat = Boat()
        var sailDistance = boat.sailDistance(1, 7)
        println(sailDistance)
        assertEquals(6, sailDistance)

        sailDistance = boat.sailDistance(4, 7)
        println(sailDistance)
        assertEquals(12, sailDistance)

        sailDistance = boat.sailDistance(7, 7)
        println(sailDistance)
        assertEquals(0, sailDistance)
    }
}