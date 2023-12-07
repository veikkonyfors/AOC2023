package fi.viware.aoc2023.day5

import org.junit.Test

import org.junit.Assert.*
import java.io.BufferedReader
import java.io.InputStreamReader
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
            //val tiedostonNimi = "file:/home/pappa/AndroidStudioProjects/AOC2023/day5/src/main/res/raw/input"
            val tiedostonNimi = "raw/input"

            // Luo URL-objekti resurssitiedostolle
            val url: URL? = javaClass.classLoader.getResource(tiedostonNimi)?.toURI()?.toURL()

            if (url != null) {
                println("Tiedoston URL: $url")

                // Voit käyttää url-oliota tarpeidesi mukaan
                // Esimerkiksi voit avata tiedoston InputStreamin avulla.
                println(url.openStream().bufferedReader().readLines())
            } else {
                println("Tiedostoa ei löytynyt.")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        assertEquals(4, 2 + 2)
    }

    @Test
    fun anotherGetResourceTest(){


        //import java.io.BufferedReader
        //import java.io.InputStreamReader

            // Assuming the raw resource file is in src/main/resources/raw
            val resourceName = "raw/input"

            // Open an InputStream for the specified resource
            val inputStream = object {}.javaClass.getResourceAsStream("/$resourceName")

            // Read the contents of the file using BufferedReader
            val reader = BufferedReader(InputStreamReader(inputStream))
            val stringBuilder = StringBuilder()
            var line: String?

            try {
                while (reader.readLine().also { line = it } != null) {
                    stringBuilder.append(line).append("\n")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                try {
                    inputStream?.close()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            // Print or use the contents of the raw file
            val fileContents = stringBuilder.toString()
            println("Raw file contents: $fileContents")
        }
}