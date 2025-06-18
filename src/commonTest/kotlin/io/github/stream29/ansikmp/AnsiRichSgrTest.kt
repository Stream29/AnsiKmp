package io.github.stream29.ansikmp

import kotlin.test.Test
import kotlin.test.assertEquals

class AnsiRichSgrTest {
    
    @Test
    fun testRgbColor() {
        val rgb = AnsiControlSequence.RichSgr.Color.Rgb(255, 100, 50)
        assertEquals("2;255;100;50", rgb.toString())
    }
    
    @Test
    fun testIndexedColor() {
        val indexed = AnsiControlSequence.RichSgr.Color.Indexed(16)
        assertEquals("5;16", indexed.toString())
    }
    
    @Test
    fun testForeground() {
        val rgb = AnsiControlSequence.RichSgr.Color.Rgb(255, 100, 50)
        val foreground = AnsiControlSequence.RichSgr.Foreground(rgb)
        assertEquals("\u001B[38;2;255;100;50m", foreground.toString())
        
        val indexed = AnsiControlSequence.RichSgr.Color.Indexed(16)
        val indexedForeground = AnsiControlSequence.RichSgr.Foreground(indexed)
        assertEquals("\u001B[38;5;16m", indexedForeground.toString())
    }
    
    @Test
    fun testBackground() {
        val rgb = AnsiControlSequence.RichSgr.Color.Rgb(255, 100, 50)
        val background = AnsiControlSequence.RichSgr.Background(rgb)
        assertEquals("\u001B[48;2;255;100;50m", background.toString())
        
        val indexed = AnsiControlSequence.RichSgr.Color.Indexed(16)
        val indexedBackground = AnsiControlSequence.RichSgr.Background(indexed)
        assertEquals("\u001B[48;5;16m", indexedBackground.toString())
    }
    
    @Test
    fun testShortHands() {
        // Test RGB foreground shorthand
        val rgbFg = AnsiControlSequence.RichSgr.rgbForeground(255, 100, 50)
        assertEquals("\u001B[38;2;255;100;50m", rgbFg.toString())
        
        // Test RGB background shorthand
        val rgbBg = AnsiControlSequence.RichSgr.rgbBackground(255, 100, 50)
        assertEquals("\u001B[48;2;255;100;50m", rgbBg.toString())
        
        // Test indexed foreground shorthand
        val indexedFg = AnsiControlSequence.RichSgr.indexedForeground(16)
        assertEquals("\u001B[38;5;16m", indexedFg.toString())
        
        // Test indexed background shorthand
        val indexedBg = AnsiControlSequence.RichSgr.indexedBackground(16)
        assertEquals("\u001B[48;5;16m", indexedBg.toString())
    }
    
    @Test
    fun testEdgeCases() {
        // Test with minimum RGB values
        val minRgb = AnsiControlSequence.RichSgr.Color.Rgb(0, 0, 0)
        assertEquals("2;0;0;0", minRgb.toString())
        
        // Test with maximum RGB values
        val maxRgb = AnsiControlSequence.RichSgr.Color.Rgb(255, 255, 255)
        assertEquals("2;255;255;255", maxRgb.toString())
        
        // Test with minimum indexed value
        val minIndexed = AnsiControlSequence.RichSgr.Color.Indexed(0)
        assertEquals("5;0", minIndexed.toString())
        
        // Test with maximum-indexed value
        val maxIndexed = AnsiControlSequence.RichSgr.Color.Indexed(255)
        assertEquals("5;255", maxIndexed.toString())
    }
}