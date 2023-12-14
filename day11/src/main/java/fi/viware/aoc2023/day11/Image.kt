package fi.viware.aoc2023.day11

class Image(inputLines: List<String>) {

    var imageArray = Array(inputLines.size) { row ->
        CharArray(inputLines[row].length) { col ->
            inputLines[row][col]
        }
    }

    fun getEnlargedImageRows(arrayToEnlarge: Array<CharArray>): Array<CharArray>{
        val enlargedImageArray = Array(arrayToEnlarge.size + numEmptyRows(arrayToEnlarge)) { CharArray(arrayToEnlarge[0].size)}
        var j = 0
        for (i in 0 until arrayToEnlarge.size) {
            enlargedImageArray[j] = arrayToEnlarge[i]
            if (isEmpty(arrayToEnlarge[i])){
                enlargedImageArray[++j] = arrayToEnlarge[i]
            }
            j++
        }
        return enlargedImageArray
    }

    fun getEnlargedImageColumns(arrayToEnlarge: Array<CharArray>): Array<CharArray>{

        val transposedImageArray = getTransPosedImageArray(arrayToEnlarge)
        val enlargedImageArray = getEnlargedImageRows(transposedImageArray)
        return getTransPosedImageArray(enlargedImageArray)
    }

    fun getTransPosedImageArray(arrayToTranspose: Array<CharArray>): Array<CharArray>{
        val transposedImageArray = Array(arrayToTranspose[0].size) { CharArray(arrayToTranspose.size)}

        for (row in 0 until arrayToTranspose.size) {
            for (col in 0 until arrayToTranspose[0].size) {
                transposedImageArray[col][row] = arrayToTranspose[row][col]
            }
        }
        return transposedImageArray
    }

    fun numEmptyColumns(array: Array<CharArray>): Int{
        var emptyColumns = 0
        var numCols = array[0].size
        var numRows = array.size
        val transposedImageArray = getTransPosedImageArray(array)

        transposedImageArray.forEach {
            if (isEmpty(it)) emptyColumns++
        }

        return emptyColumns
    }
    fun numEmptyRows(array: Array<CharArray>): Int{
        var emptyRows = 0
        array.forEach {
            if (isEmpty(it)) emptyRows++
        }

        return emptyRows
    }

    fun isEmpty(pixels: CharArray):Boolean{
        return pixels.toSet().size == 1
    }

    override fun toString(): String {
        var s = ""
        s = imageArray.joinToString(separator = "\n") { it.joinToString(separator = "") { it.toString()} }
        return s
    }
}