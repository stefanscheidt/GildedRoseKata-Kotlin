package com.gildedrose

import org.junit.jupiter.api.Test
import java.io.File
import java.io.File.createTempFile
import java.io.FileWriter
import java.io.PrintWriter
import java.nio.file.Files.readAllLines
import java.nio.file.Path
import kotlin.test.assertEquals


class GildedRoseTextTest {

    @Test
    fun `validate output`() {
        val expectedLines = readAllLines(Path.of(TEXT_FIXTURE_FILENAME))
        val actualLines = readAllLines(actualFixtureFile().toPath())

        assertEquals(expectedLines.size, actualLines.size)
        expectedLines.zip(actualLines).forEach { (expected, actual) ->
            assertEquals(expected, actual)
        }
    }

    private fun actualFixtureFile(): File =
        createTempFile("gildedrose-", ".txt").also {
            it.deleteOnExit()
            PrintWriter(FileWriter(it)).use(PrintWriter::printFixture)
        }

}