package fi.viware.aoc2023.day5

class CategoryMap() {
    val transFormLines: MutableList<TransFormLine> = mutableListOf()

    fun add(transFormLineString: String){
        transFormLines.add(TransFormLine(transFormLineString))
    }

    fun getTarget(source: Long): Long {

        var target = source
        var numHits = 0

        transFormLines.forEach {
            if ( it.sourceStart <= source && source < it.sourceStart + it.rangeLenght) {
                target = it.destinationStart + source - it.sourceStart
                if (numHits++ > 1)
                    println("target $target, destinationStart ${it.destinationStart}, source $source, sourceStart ${it.sourceStart}, rangeLenght ${it.rangeLenght} ")
            }
        }
        return target
    }

    override fun toString(): String {

        return CategoryMap::class.simpleName + ":\n" + transFormLines.joinToString("\n")
    }
}