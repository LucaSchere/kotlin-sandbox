import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

    // T2X2
    @Test
    fun numberOfWords() {
        assertEquals(2, numberOfWords("Hello, world!"))
        assertEquals(6, numberOfWords("Hello, world! I am a programmer."))
        assertEquals(1, numberOfWords("Hi"))
        assertEquals(0, numberOfWords(""))
    }

    // T2X3
    @Test
    fun alternatingCase() {
        assertEquals("HeLlOwOrLd", alternatingCase("Hello, world!"))
    }

    @Test
    fun alternatingCaseRecursive() {
        assertEquals("hAlLo", alternatingCaseRecursive(" Hallo"))
        assertEquals("HeLlOwOrLd", alternatingCaseRecursive("Hello, world!"))
    }
}
