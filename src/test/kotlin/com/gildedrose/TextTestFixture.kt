package com.gildedrose

import java.io.FileWriter
import java.io.PrintWriter

const val TEXT_FIXTURE_DAYS = 30
const val TEXT_FIXTURE_FILENAME = "./texttest/stdout.txt"

class TextTestFixture {

    val items = arrayOf(
        Item("+5 Dexterity Vest", 10, 20),
        Item("Aged Brie", 2, 0),
        Item("Elixir of the Mongoose", 5, 7),
        Item("Sulfuras, Hand of Ragnaros", 0, 80),
        Item("Sulfuras, Hand of Ragnaros", -1, 80),
        Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
        Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
        // this conjured item does not work properly yet
        Item("Conjured Mana Cake", 3, 6)
    )

    val gildedRose = GildedRose(items)
}

fun PrintWriter.printFixture() {
    val fixture = TextTestFixture()
    println("OMGHAI!")

    for (i in 0..TEXT_FIXTURE_DAYS) {
        println("-------- day $i --------")
        println("name, sellIn, quality")
        fixture.items.forEach { println(it) }
        println()
        flush()
        fixture.gildedRose.updateQuality()
    }
}

fun main() {
    PrintWriter(FileWriter(TEXT_FIXTURE_FILENAME)).printFixture()
}
