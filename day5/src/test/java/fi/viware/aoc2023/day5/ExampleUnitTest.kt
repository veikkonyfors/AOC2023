package fi.viware.aoc2023.day5

import org.junit.Test

import org.junit.Assert.*
import java.net.URL

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun openResource() {
        try {
            // Resurssitiedoston nimi (esimerkki: tiedosto.txt)
            val tiedostonNimi = "file:/home/pappa/AndroidStudioProjects/AOC2023/day5/src/main/res/raw/input"

            // Luo URL-objekti resurssitiedostolle
            val url: URL? = javaClass.classLoader.getResource(tiedostonNimi)?.toURI()?.toURL()

            if (url != null) {
                println("Tiedoston URL: $url")

                // Voit käyttää url-oliota tarpeidesi mukaan
                // Esimerkiksi voit avata tiedoston InputStreamin avulla.
            } else {
                println("Tiedostoa ei löytynyt.")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        assertEquals(4, 2 + 2)
    }
}