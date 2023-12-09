package fi.viware.aoc2023.day7

class Hand(val handString: String) {

    var inputList = handString.split(" ")
    val cardString = inputList[0]
    val bid = inputList[1].toInt()


    fun getStrenght(): Int{
        return when( numDistinct(cardString)){
            1 -> FIVES
            5 -> HIGH
            4 -> PAIR
            3 -> when(cardString.count{it == cardString[0]}){
                3 -> THREES
                2 -> TWOPAIRS
                1 -> when(cardString.count{it == cardString[1]}){
                    3, 1 -> THREES
                    else -> TWOPAIRS
                }
                else -> -1
            }
            2 -> when(cardString.count{it == cardString[0]}){
                    2, 3 -> FULLHOUSE
                    else -> FOURS
                 }
            else -> -1
        }

    }
    fun getStrenght2(): Int{
        val countJokers = countJokers()
        return when( numDistinct(cardString)){

            5 -> when(countJokers) {
                1 -> PAIR
                else -> HIGH
            }

            4 -> when(countJokers) {
                0 -> PAIR // T235T
                1 -> THREES // TJ35T
                2 -> THREES // TJ35J
                else -> -1
            }

            3 -> when(countJokers) {
                0->    when(cardString.count{it == cardString[0]}){ //
                    3 -> THREES
                    2 -> TWOPAIRS
                    1 -> when(cardString.count{it == cardString[1]}){
                        3, 1 -> THREES
                        else -> TWOPAIRS
                    }
                    else -> -1
                }

                1 -> when(maxSame()) {
                    1 -> PAIR // AKQJT
                    2 -> FULLHOUSE // AJAKK
                    3 -> FOURS // QQQJA
                    else -> -1
                }

                2 -> FOURS // AJJAK

                3 -> FOURS //AJKJJ
                else -> -1  //???????
            }

            2 -> when(countJokers){ // QQQQJ
                    0 -> when(cardString.count{ it == cardString[0]}){
                            2, 3 -> FULLHOUSE
                            else -> FOURS
                        }
                    else -> FIVES
                }

            1 -> FIVES

            else -> -1
        }

    }

    fun compareHigh(otherHand: Hand): Int{
        val rank = "AKQJT98765432"
        cardString.forEachIndexed { index, c ->
            val c1 = c
            val c2 = if (index < otherHand.cardString.length) otherHand.cardString[index] else '\u0000'
            val i1 = rank.indexOf(c1)
            val i2 = rank.indexOf(c2)
            if (i1 != i2) return i2 - i1
        }

        return 0
    }

    fun compareHigh2(otherHand: Hand): Int{
        val rank = "AKQT98765432J"
        cardString.forEachIndexed { index, c ->
            val c1 = c
            val c2 = if (index < otherHand.cardString.length) otherHand.cardString[index] else '\u0000'
            val i1 = rank.indexOf(c1)
            val i2 = rank.indexOf(c2)
            if (i1 != i2) return i2 - i1
        }

        return 0
    }

    fun countJokers(): Int{
        return cardString.count { it ==  'J' }
    }

    fun maxSame():Int{
        val charCountMap = mutableMapOf<Char, Int>()

        for (char in cardString) {
            charCountMap[char] = charCountMap.getOrDefault(char, 0) + 1
        }

        // Find the maximum count
        val maxCount = charCountMap.values.maxOrNull() ?: 0

        return maxCount
    }

    fun numDistinct(card: String): Int{
        return card.toSet().size
    }
    override fun toString(): String {
        return "$cardString $bid"
    }
}