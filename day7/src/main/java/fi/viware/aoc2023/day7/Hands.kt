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
            val s1 = getStrength(h1) //h1.getStrenght()
            val s2 = getStrength(h2) //h2.getStrenght()
            //val s3 = h1.getStrenght()
            //val s4 = h2.getStrenght()
            //println("$h1 $h2 $s1, $s2, $s3, $s4")
            if (s1 == s2){
                if (PUZZ2 != true)  h2.compareHigh(h1)
                else h2.compareHigh2(h1)
            }
            else s2 - s1

        }
        val s = hands.sortedWith(comparator)
        //val s = hands.sortedByDescending {
         //   it.getStrenght()
        //}
        return s
    }

    fun getStrength(h: Hand): Int{
        return when(PUZZ2){
            true-> h.getStrenght2();
            false -> h.getStrenght()}
    }

    fun getCompareHigh(h: Hand): Int{
        return when(PUZZ2){
            true-> h.compareHigh2(h);
            false -> h.compareHigh(h)}
    }


}
