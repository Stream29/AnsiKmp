package io.github.stream29.ansikmp

import kotlin.test.Test
import kotlin.test.assertEquals

class AnsiEraseTest {
    
    @Test
    fun testEraseInDisplay() {
        // Test with the default value (0 - erase from cursor to end of screen)
        val eraseToEnd = AnsiControlSequence.Erase.InDisplay()
        assertEquals("\u001B[0J", eraseToEnd.toString())
        
        // Test with value 1 (erase from cursor to beginning of screen)
        val eraseToBeginning = AnsiControlSequence.Erase.InDisplay(1)
        assertEquals("\u001B[1J", eraseToBeginning.toString())
        
        // Test with value 2 (erase the entire screen)
        val eraseAll = AnsiControlSequence.Erase.InDisplay(2)
        assertEquals("\u001B[2J", eraseAll.toString())
        
        // Test with value 3 (erase the entire screen and scrollback buffer)
        val eraseAllAndScrollback = AnsiControlSequence.Erase.InDisplay(3)
        assertEquals("\u001B[3J", eraseAllAndScrollback.toString())
    }
    
    @Test
    fun testEraseInLine() {
        // Test with default value (0 - erase from cursor to end of line)
        val eraseToEnd = AnsiControlSequence.Erase.InLine()
        assertEquals("\u001B[0K", eraseToEnd.toString())
        
        // Test with value 1 (erase from cursor to beginning of line)
        val eraseToBeginning = AnsiControlSequence.Erase.InLine(1)
        assertEquals("\u001B[1K", eraseToBeginning.toString())
        
        // Test with value 2 (erase the entire line)
        val eraseAll = AnsiControlSequence.Erase.InLine(2)
        assertEquals("\u001B[2K", eraseAll.toString())
    }
    
    @Test
    fun testEdgeCases() {
        // Test with an invalid value (not recommended but should still work)
        val invalidValue = AnsiControlSequence.Erase.InDisplay(4)
        assertEquals("\u001B[4J", invalidValue.toString())
        
        // Test with negative value (not recommended but should still work)
        val negativeValue = AnsiControlSequence.Erase.InLine(-1)
        assertEquals("\u001B[-1K", negativeValue.toString())
    }
}