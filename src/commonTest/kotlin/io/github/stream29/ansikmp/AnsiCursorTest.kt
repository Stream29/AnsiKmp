package io.github.stream29.ansikmp

import kotlin.test.Test
import kotlin.test.assertEquals

class AnsiCursorTest {
    
    @Test
    fun testCursorUp() {
        // Test with a default value
        val up = AnsiControlSequence.Cursor.Up()
        assertEquals("\u001B[1A", up.toString())
        
        // Test with custom value
        val upCustom = AnsiControlSequence.Cursor.Up(5)
        assertEquals("\u001B[5A", upCustom.toString())
    }
    
    @Test
    fun testCursorDown() {
        // Test with a default value
        val down = AnsiControlSequence.Cursor.Down()
        assertEquals("\u001B[1B", down.toString())
        
        // Test with custom value
        val downCustom = AnsiControlSequence.Cursor.Down(5)
        assertEquals("\u001B[5B", downCustom.toString())
    }
    
    @Test
    fun testCursorForward() {
        // Test with a default value
        val forward = AnsiControlSequence.Cursor.Forward()
        assertEquals("\u001B[1C", forward.toString())
        
        // Test with custom value
        val forwardCustom = AnsiControlSequence.Cursor.Forward(5)
        assertEquals("\u001B[5C", forwardCustom.toString())
    }
    
    @Test
    fun testCursorBackward() {
        // Test with a default value
        val backward = AnsiControlSequence.Cursor.Backward()
        assertEquals("\u001B[1D", backward.toString())
        
        // Test with custom value
        val backwardCustom = AnsiControlSequence.Cursor.Backward(5)
        assertEquals("\u001B[5D", backwardCustom.toString())
    }
    
    @Test
    fun testCursorNextLine() {
        // Test with a default value
        val nextLine = AnsiControlSequence.Cursor.NextLine()
        assertEquals("\u001B[1E", nextLine.toString())
        
        // Test with custom value
        val nextLineCustom = AnsiControlSequence.Cursor.NextLine(5)
        assertEquals("\u001B[5E", nextLineCustom.toString())
    }
    
    @Test
    fun testCursorPreviousLine() {
        // Test with a default value
        val previousLine = AnsiControlSequence.Cursor.PreviousLine()
        assertEquals("\u001B[1F", previousLine.toString())
        
        // Test with custom value
        val previousLineCustom = AnsiControlSequence.Cursor.PreviousLine(5)
        assertEquals("\u001B[5F", previousLineCustom.toString())
    }
    
    @Test
    fun testCursorHorizontalAbsolute() {
        // Test with a default value
        val horizontalAbsolute = AnsiControlSequence.Cursor.HorizontalAbsolute()
        assertEquals("\u001B[1G", horizontalAbsolute.toString())
        
        // Test with custom value
        val horizontalAbsoluteCustom = AnsiControlSequence.Cursor.HorizontalAbsolute(5)
        assertEquals("\u001B[5G", horizontalAbsoluteCustom.toString())
    }
    
    @Test
    fun testCursorPosition() {
        // Test with default values
        val position = AnsiControlSequence.Cursor.Position()
        assertEquals("\u001B[1;1H", position.toString())
        
        // Test with custom values
        val positionCustom = AnsiControlSequence.Cursor.Position(5, 10)
        assertEquals("\u001B[5;10H", positionCustom.toString())
        
        // Test with only a row specified
        val positionRow = AnsiControlSequence.Cursor.Position(5)
        assertEquals("\u001B[5;1H", positionRow.toString())
    }
    
    @Test
    fun testCursorSave() {
        val save = AnsiControlSequence.Cursor.Save
        assertEquals("\u001B[s", save.toString())
    }
    
    @Test
    fun testCursorRestore() {
        val restore = AnsiControlSequence.Cursor.Restore
        assertEquals("\u001B[u", restore.toString())
    }
    
    @Test
    fun testEdgeCases() {
        // Test with zero value (although not recommended, should still work)
        val upZero = AnsiControlSequence.Cursor.Up(0)
        assertEquals("\u001B[0A", upZero.toString())
        
        // Test with a large value
        val upLarge = AnsiControlSequence.Cursor.Up(9999)
        assertEquals("\u001B[9999A", upLarge.toString())
        
        // Test position with large values
        val positionLarge = AnsiControlSequence.Cursor.Position(9999, 9999)
        assertEquals("\u001B[9999;9999H", positionLarge.toString())
    }
}