package leetcode.backtrack.combination

import org.junit.Test

import org.junit.Assert.*

class LC332Test {

    @Test
    fun findItinerary() {
        println(LC332().findItinerary(listOf(listOf("JFK", "KUL"), listOf("JFK", "NRT"), listOf("NRT", "JFK"))))
        println(
            LC332().findItinerary(
                listOf(
                    listOf("MUC", "LHR"),
                    listOf("JFK", "MUC"),
                    listOf("SFO", "SJC"),
                    listOf("LHR", "SFO")
                )
            )
        )
    }


    @Test
    fun findItineraryJava() {
        LC332JAVA().findItinerary(listOf(listOf("JFK", "KUL"), listOf("JFK", "NRT"), listOf("NRT", "JFK")))
    }
}