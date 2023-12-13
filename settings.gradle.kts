pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AOC2023"
include(":day2")
include(":day3")
include(":day5")
include(":day6")
include(":day62")
include(":day7")
include(":day8")
include(":day9")
include(":day10")
