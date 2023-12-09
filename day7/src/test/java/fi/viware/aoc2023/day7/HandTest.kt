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
    fun testStrength() {
        var hand = Hand("QQQJA 1956")
        assertEquals(THREES, hand.getStrenght())
        hand = Hand("T55J5 1956")
        assertEquals(THREES, hand.getStrenght())
    }

    @Test
    fun getStrenght(){
        PUZZ2 = false
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
    fun getStrenght2(){
        PUZZ2 = true

        //1 distinct
        var hand = Hand("AAAAA 1956")
        assertEquals(FIVES, hand.getStrenght2())
        hand = Hand("JJJJ 1956")
        assertEquals(FIVES, hand.getStrenght2())

        // 2 distinct
        hand = Hand("QQQQA 1956")
        assertEquals(FOURS, hand.getStrenght2())
        hand = Hand("QQQQJ 1956")
        assertEquals(FIVES, hand.getStrenght2())
        hand = Hand("QQQJJ 1956")
        assertEquals(FIVES, hand.getStrenght2())
        hand = Hand("QQJJJ 1956")
        assertEquals(FIVES, hand.getStrenght2())
        hand = Hand("JJJJQ 1956")
        assertEquals(FIVES, hand.getStrenght2())


        // 3 distinct
        hand = Hand("QQQTA 1956")
        assertEquals(THREES, hand.getStrenght2())
        hand = Hand("AQAKK 1985")
        assertEquals(TWOPAIRS, hand.getStrenght2())
        hand = Hand("QQQJA 1956")
        assertEquals(FOURS, hand.getStrenght2())
        hand = Hand("AJAKK 1985")
        assertEquals(FULLHOUSE, hand.getStrenght2())
        hand = Hand("QQJJA 1956")
        assertEquals(FOURS, hand.getStrenght2())
        hand = Hand("AJJAK 1985") // <-
        assertEquals(FOURS, hand.getStrenght2())
        hand = Hand("AJKJJ 1985")
        assertEquals(FOURS, hand.getStrenght2())


        //  4 distinct
        hand = Hand("T235T 1998")
        assertEquals(PAIR, hand.getStrenght2())
        hand = Hand("TJ35T 1998")
        assertEquals(THREES, hand.getStrenght2())
        hand = Hand("TJ35J 1998")
        assertEquals(THREES, hand.getStrenght2())

        // 5 distinct
        hand = Hand("6879T 1977")
        assertEquals(HIGH, hand.getStrenght2())
        hand = Hand("6J79T 1956")
        assertEquals(PAIR, hand.getStrenght2())

    }

    @Test
    fun compareGetStrength12(){ //[QQQJA 483, T55J5 684, KK677 28, KTJJT 220, 32T3K 765]
        var hand = Hand("QQQJA 1956")
        assertEquals(THREES, hand.getStrenght())
        hand = Hand("QQQJA 1956")
        assertEquals(FOURS, hand.getStrenght2())



    }

    @Test
    fun compareHigh(){
        var hand = Hand("T55J5 1956")
        var hand2 = Hand("QQQJA 1956")

        println("${hand.compareHigh(hand2)}")
    }

    @Test
    fun maxSame(){
        var hand = Hand("T55J5 1956")
        var hand2 = Hand("6879T 1956")

        println("${hand.maxSame()}, ${hand2.maxSame()}")
        assertEquals("3, 1", "${hand.maxSame()}, ${hand2.maxSame()}")
    }

    //var hand = Hand("QQQQA 1956")

}