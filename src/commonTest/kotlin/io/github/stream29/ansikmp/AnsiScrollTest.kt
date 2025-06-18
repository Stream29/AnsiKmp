package io.github.stream29.ansikmp

import kotlin.test.Test
import kotlin.test.assertEquals

class AnsiScrollTest {
    
    @Test
    fun testScrollUp() {
        // Test with default value
        val scrollUp = AnsiControlSequence.Scroll.Up()
        assertEquals("\u001B[1S", scrollUp.toString())
        
        // Test with custom value
        val scrollUpCustom = AnsiControlSequence.Scroll.Up(5)
        assertEquals("\u001B[5S", scrollUpCustom.toString())
    }
    
    @Test
    fun testScrollDown() {
        // Test with default value
        val scrollDown = AnsiControlSequence.Scroll.Down()
        assertEquals("\u001B[1T", scrollDown.toString())
        
        // Test with custom value
        val scrollDownCustom = AnsiControlSequence.Scroll.Down(5)
        assertEquals("\u001B[5T", scrollDownCustom.toString())
    }
    
    @Test
    fun testEdgeCases() {
        // Test with zero value (although not recommended, should still work)
        val scrollUpZero = AnsiControlSequence.Scroll.Up(0)
        assertEquals("\u001B[0S", scrollUpZero.toString())
        
        // Test with large value
        val scrollUpLarge = AnsiControlSequence.Scroll.Up(9999)
        assertEquals("\u001B[9999S", scrollUpLarge.toString())
        
        // Test with negative value (not recommended, but should still work)
        val scrollDownNegative = AnsiControlSequence.Scroll.Down(-1)
        assertEquals("\u001B[-1T", scrollDownNegative.toString())
    }
}