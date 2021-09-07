package main.java.senior

class SpellBook {
    val spells = listOf("Magic Ms . L", "Lay onHans")

    @JvmField
    val spells1 = listOf("Magic Ms . L", "Lay onHans")

    companion object{
        @JvmField
        val MAX_SPELL_COUNT = 10
        fun getSpellbookGreeting() = println("I am the Great man!")
    }
}