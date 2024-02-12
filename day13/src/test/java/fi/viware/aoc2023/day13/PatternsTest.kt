package fi.viware.aoc2023.day13

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.File

class PatternsTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun splitPatterns() {
        val tiedostonNimi = "src/findReflectingColumnZipped/resources/raw/input_test"  // Korvaa tiedoston polku ja nimi tarpeidesi mukaan

        try {

            //val url: URL? = javaClass.classLoader.getResource(tiedostonNimi)?.toURI()?.toURL()
            //val inputLines = url!!.openStream().bufferedReader().readLines()

            val tiedosto = File(tiedostonNimi)

            val ryhmat = tiedosto.useLines { lines ->
                lines.groupingBy { it.isBlank() }
                    .fold(mutableListOf<String>()) { acc, line ->
                        if (line.isBlank()) {
                            acc.also { it.add("") }  // Tyhjä rivi ryhmien välillä
                        } else {
                            acc.lastOrNull()?.let { last ->
                                if (last.isNotBlank()) {
                                    acc[acc.lastIndex] = last + " " + line
                                } else {
                                    acc.add(line)
                                }
                            }
                        }
                        acc
                    }
            }

            // Tulosta kolmannen ryhmän tiedot
            //ryhmat.getOrNull(2)?.forEach(::println)
            println("$ryhmat")

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @Test
    fun groubingByFold(){
        val sanat = listOf("kissa", "koira", "auto", "omena")
        val flatMap = sanat.flatMap {  it.toList() }
        val groupingBy = flatMap.groupingBy { it }
        val fold = groupingBy.fold(0) { acc, _ -> acc + 1 }
        println(fold)


        /*
        val kirjaintenMaarat = sanat
            .flatMap { it.toList() }  // Muunnetaan jokainen sana listaksi kirjaimia
            .groupingBy { it }         // Ryhmitellään kirjainten mukaan
            .fold(0) { acc, _ -> acc + 1 }  // Lasketaan kirjainten määrä kussakin ryhmässä

        println(kirjaintenMaarat)

         */
    }



    @Test
    fun windowedReflection() {
        val taulukko = arrayOf(
            charArrayOf('a', 'b', 'c'),
            charArrayOf('a', 'b', 'c'),
            charArrayOf('a', 'b', 'c'),
            charArrayOf('a', 'b', 'c')
        )


        val mappi = taulukko.map { it.toList() }
        val windowed = mappi.windowed(2)

        val ovatkoKaikkiSamat= windowed.all{ c -> //(rivi, seuraavaRivi) ->
            val rivi = c[0]
            val seuraavaRivi = c[1]
                rivi.equals(seuraavaRivi)
        }

        if (ovatkoKaikkiSamat) {
            println("Kaikki rivit ovat samat kuin edeltävä rivi.")
        } else {
            println("Rivit eivät ole kaikki samat kuin edeltävä rivi.")
        }
    }

    @Test
    fun findReflectingColumnArrayed() {
        val taulukko = arrayOf(
            charArrayOf('a', 'b', 'c', 'd', 'd'),
            charArrayOf('e', 'f', 'g', 'h', 'h'),
            charArrayOf('i', 'j', 'k', 'l', 'l'),
            charArrayOf('m', 'n', 'o', 'p', 'p')
        )

        val ensimmainenSamanlainenSarakepari = (0 until taulukko[0].size - 1)
            .asSequence()
            .map { sarake ->
                taulukko.map { rivi -> rivi[sarake] to rivi[sarake + 1] }
            }
            .indexOfFirst { sarakepari ->
                sarakepari.all { (ensimmainen, toinen) -> ensimmainen == toinen }
            }

        if (ensimmainenSamanlainenSarakepari != -1) {
            println("Ensimmäinen samanlainen rinnakkainen sarakepari löytyy sarakkeista $ensimmainenSamanlainenSarakepari ja ${ensimmainenSamanlainenSarakepari + 1}.")
        } else {
            println("Ei samanlaisia rinnakkaisia sarakepareja.")
        }
    }

    @Test
    fun findReflectingColumnListed() {
        val taulukko = listOf(
            listOf('a', 'b', 'c', 'd', 'd'),
            listOf('e', 'f', 'g', 'h', 'h'),
            listOf('i', 'j', 'k', 'l', 'l'),
            listOf('m', 'n', 'o', 'p', 'p')
        )

        val ensimmainenSamanlainenSarakepari = (0 until taulukko[0].size - 1)
            .asSequence()
            .map { sarake ->
                taulukko.map { rivi -> rivi[sarake] to rivi[sarake + 1] }
            }
            .indexOfFirst { sarakepari ->
                sarakepari.all { (ensimmainen, toinen) -> ensimmainen == toinen }
            }

        if (ensimmainenSamanlainenSarakepari != -1) {
            println("Ensimmäinen samanlainen rinnakkainen sarakepari löytyy sarakkeista $ensimmainenSamanlainenSarakepari ja ${ensimmainenSamanlainenSarakepari + 1}.")
        } else {
            println("Ei samanlaisia rinnakkaisia sarakepareja.")
        }
    }

    @Test
    fun findReflectingColumnListString() {
        val taulukko = listOf(
            "abcdd",
            "efghh",
            "ijkll",
            "mnopp"
        )

        val ensimmainenSamanlainenSarakepari = (0 until taulukko[0].length - 1)
            .asSequence()
            .map { sarake ->
                taulukko.map { rivi -> rivi[sarake] to rivi[sarake + 1] }
            }
            .indexOfFirst { sarakepari ->
                sarakepari.all { (ensimmainen, toinen) -> ensimmainen == toinen }
            }

        if (ensimmainenSamanlainenSarakepari != -1) {
            println("Ensimmäinen samanlainen rinnakkainen sarakepari löytyy sarakkeista $ensimmainenSamanlainenSarakepari ja ${ensimmainenSamanlainenSarakepari + 1}.")
        } else {
            println("Ei samanlaisia rinnakkaisia sarakepareja.")
        }
    }

    @Test
    fun extractColumn() {
        val taulukko = listOf(
            "abcdd",
            "efghh",
            "ijkll",
            "mnopp"
        )

        val kolmannetMerkitYhdistetty = taulukko.map { rivi ->
            rivi.getOrNull(2) ?: "" // Haetaan kolmas merkki tai tyhjä merkkijono, jos ei ole kolmatta merkkiä
        }.joinToString(separator = "")

        println("Kolmannet merkit yhdistettynä: $kolmannetMerkitYhdistetty")
    }

    @Test
    fun forEachIndexedReturn(){

        val lista = listOf(1, 2, 3, 4, 5)

        lista.forEachIndexed { indeksi, alkio ->
            if ( alkio == 2 ) {
                // Haluttu ehto täyttyi, keskeytä suoritus
                return@forEachIndexed
            }
            // Tee jotain alkion kanssa
            println(alkio)
        }
    }

    @Test
    fun testIsReflecting(){

        var b = isReflecting("abcd","abcd")
        println("$b")

        b = isReflecting("axcd","abcd")
        println("$b")

        b = isReflecting("axcd","abcy")
        println("$b")

        fun isReflecting(line1: String, line2: String): Boolean{
            if ( line1 == line2 ) return true

            val eroavienMerkkienLaskuri = line1.zip(line2).count { (c1, c2) -> c1 != c2 }

            return eroavienMerkkienLaskuri == 1
        }
    }
    fun isReflecting(line1: String, line2: String): Boolean{
        if ( line1 == line2 ) return true

        val eroavienMerkkienLaskuri = line1.zip(line2).count { (c1, c2) -> c1 != c2 }

        return eroavienMerkkienLaskuri == 1
    }

    @Test
    fun list_all() {
        val lista = listOf(
            Pair("merkkijono1a", "merkkijono1b"),
            Pair("merkkijono2a", "merkkijono2b"),
            Pair("merkkijono3a", "merkkijono3b")
        )

        val ovatkoKaikkiSamat = lista.all { (alkio1, alkio2) -> alkio1 == alkio2 }

        if (ovatkoKaikkiSamat) {
            println("Kaikki alkiot ovat samat.")
        } else {
            println("Ei kaikki alkiot ole samat.")
        }
    }
}




