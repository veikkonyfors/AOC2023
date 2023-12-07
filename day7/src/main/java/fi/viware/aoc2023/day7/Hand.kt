package fi.viware.aoc2023.day7

class Hand(val handString: String) {

    var inputList = handString.split(" ")
    val cardString = inputList[0]
    val sortedCardString = sort(inputList[0])
    val bid = inputList[1].toInt()

    fun sort(inputCardsString: String): String{
        val customOrder = "AKQJT98765432"
        val comparator: Comparator<Char> = Comparator { c1, c2 ->
            customOrder.indexOf(c1) - customOrder.indexOf(c2)
        }
        val sortedCardsString = inputCardsString.toCharArray().sortedWith(comparator).joinToString("")
        return sortedCardsString
    }

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
    fun numDistinct(card: String): Int{
        return card.toSet().size
    }
    override fun toString(): String {
        return "$cardString $bid"
    }
}