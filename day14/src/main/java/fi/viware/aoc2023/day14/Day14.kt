package fi.viware.aoc2023.day14

import android.net.PlatformVpnProfile
import java.net.URL

const val NORTH: Int = 0

class Day14(inputFileName: String) {

    val platform:Platform

    init {

        val url: URL? = javaClass.classLoader.getResource(inputFileName)?.toURI()?.toURL()
        val inputLines = url!!.openStream().bufferedReader().readLines()
        platform = Platform(inputLines)
    }

    fun solvePuzz1(): Int{
        val load = platform.getLoadNorth()
        return load
    }

    fun solvePuzz2(): Int{
        platform.tilt(NORTH)
        val load = platform.getLoad()
        return load
    }
    
}