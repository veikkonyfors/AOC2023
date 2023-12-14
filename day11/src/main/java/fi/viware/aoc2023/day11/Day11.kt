package fi.viware.aoc2023.day11

import java.net.URL



class Day11(val inputFileName: String) {

    val url: URL? = javaClass.classLoader.getResource(inputFileName)?.toURI()?.toURL()
    val inputLines = url!!.openStream().bufferedReader().readLines()

    val image = Image(inputLines)

    fun solvePuzz1():Int{
        val enlargedImageArray = image.getEnlargedImageColumns(image.getEnlargedImageRows(image.imageArray))
        image.imageArray = enlargedImageArray

        val galaxies = Galaxies(image)
        val n = galaxies.sumUpDistances()
        return n
    }

}