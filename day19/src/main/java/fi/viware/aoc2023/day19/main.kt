package fi.viware.aoc2023.day19

fun main(){
    var day19 = Day19("day19/src/main/res/input_test")
    day19.sort()
    println("${day19.solvePuzz1()}")

    day19 = Day19("day19/src/main/res/input")
    day19.sort()
    println("${day19.solvePuzz1()}")
}