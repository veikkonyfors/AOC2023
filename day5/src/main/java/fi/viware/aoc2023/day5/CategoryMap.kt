package fi.viware.aoc2023.day5

class CategoryMap() {
    val transFormLines: MutableList<TransFormLine> = mutableListOf()

    fun add(transFormLineString: String){
        transFormLines.add(TransFormLine(transFormLineString))
    }

    fun getTarget(source: Long): Long {

        var target = source
        transFormLines.forEach {
            if ( it.sourceStart <= source && source < it.sourceStart + it.rangeLenght)
                target = it.destinationStart + source - it.sourceStart
        }
        return target
    }

    override fun toString(): String {

        return CategoryMap::class.simpleName + ":\n" + transFormLines.joinToString("\n")
    }
}