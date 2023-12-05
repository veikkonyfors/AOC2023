package fi.viware.aoc2023.day5

import org.junit.Assert.*
import org.junit.Test

class SeedsTest(){

    @Test
    fun toStringTest(){

        val seeds = Seeds("seeds: 79 14 55 13")
        println(seeds)
        assertEquals("79, 14, 55, 13",seeds.toString())

    }
}