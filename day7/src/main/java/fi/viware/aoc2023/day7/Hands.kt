package fi.viware.aoc2023.day7

class Hands(listOfHandsString: List<String>) {

    val hands:MutableList<Hand> = mutableListOf()
    var sortedHands:List<Hand> = listOf()

    init {
        listOfHandsString.forEach {
            hands.add(Hand(it))
        }

        sortedHands = sortHands()
    }

    private fun sortHands(): List<Hand>{
            val comparator: Comparator<Hand> = Comparator { h1, h2 ->
                val s1 = h1.getStrenght()
                val s2 = h2.getStrenght()
                //h1.getStrenght() -  h2.getStrenght()
                if (s1 == s2){
                    h2.compareHigh(h1)
                }
                else s2 - s1

            }
            val s = hands.sortedWith(comparator)
            //val s = hands.sortedByDescending {
             //   it.getStrenght()
            //}
            return s
    }

}