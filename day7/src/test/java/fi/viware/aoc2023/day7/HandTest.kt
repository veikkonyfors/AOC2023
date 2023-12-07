package fi.viware.aoc2023.day7

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class HandTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getBid() {
    }

    @Test
    fun getStrenght(){
        var hand = Hand("QQQQQ 1956")
        assertEquals(FIVES, hand.getStrenght())
        hand = Hand("AAAAK 1977")
        assertEquals(FOURS, hand.getStrenght())
        hand = Hand("AAAKK 1985")
        assertEquals(FULLHOUSE, hand.getStrenght())
        hand = Hand("23AA3 1987")
        assertEquals(TWOPAIRS, hand.getStrenght())
        hand = Hand("T235T 1998")
        assertEquals(PAIR, hand.getStrenght())
        hand = Hand("6879T 1977")
        assertEquals(HIGH, hand.getStrenght())
        hand = Hand("QQQJA 1956")
        assertEquals(THREES, hand.getStrenght())
        hand = Hand("AJJJQ 1956")
        assertEquals(THREES, hand.getStrenght())
        hand = Hand("78882 1956")
        assertEquals(THREES, hand.getStrenght())
        hand = Hand("12322 1956")
        assertEquals(THREES, hand.getStrenght())
    }

    @Test
    fun compareHigh(){
        var hand = Hand("T55J5 1956")
        var hand2 = Hand("QQQJA 1956")

        println("${hand.compareHigh(hand2)}")
    }
}