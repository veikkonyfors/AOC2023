package fi.viware.aoc2023.day7

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class HandsTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getHands() {
    }

    @Test
    fun sortHands() {
        val hands = Hands("32T3K 765\nT55J5 684\nKK677 28\nKTJJT 220\nQQQJA 483".split("\n"))

        println(hands.sortedHands)
    }

    @Test
    fun main() {
        val listOfStrings = listOf("orange", "a", "gr", "banana", "kiwi")

        // Sort the list from longest to shortest
        val sortedList = listOfStrings.sortedByDescending { it.length }

        // Print the sorted list
        println("Original list: $listOfStrings")
        println("Sorted list from longest to shortest: $sortedList")
    }
}