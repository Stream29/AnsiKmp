package io.github.stream29.ansikmp

import kotlin.test.Test
import kotlin.test.assertEquals

class AnsiSgrTest {
    
    @Test
    fun testSgrToString() {
        val sgr = AnsiControlSequence.Sgr(1)
        assertEquals("\u001B[1m", sgr.toString())
    }
    
    @Test
    fun testSgrIntrinsics() {
        // Test reset
        assertEquals("\u001B[0m", AnsiControlSequence.Sgr.reset.toString())
        
        // Test text styles
        assertEquals("\u001B[1m", AnsiControlSequence.Sgr.bold.toString())
        assertEquals("\u001B[2m", AnsiControlSequence.Sgr.dim.toString())
        assertEquals("\u001B[3m", AnsiControlSequence.Sgr.italic.toString())
        assertEquals("\u001B[4m", AnsiControlSequence.Sgr.underline.toString())
        assertEquals("\u001B[5m", AnsiControlSequence.Sgr.blink.toString())
        assertEquals("\u001B[6m", AnsiControlSequence.Sgr.rapidBlink.toString())
        assertEquals("\u001B[7m", AnsiControlSequence.Sgr.reverse.toString())
        assertEquals("\u001B[8m", AnsiControlSequence.Sgr.hidden.toString())
        assertEquals("\u001B[9m", AnsiControlSequence.Sgr.strikethrough.toString())
        
        // Test reset styles
        assertEquals("\u001B[22m", AnsiControlSequence.Sgr.resetBoldDim.toString())
        assertEquals("\u001B[23m", AnsiControlSequence.Sgr.resetItalic.toString())
        assertEquals("\u001B[24m", AnsiControlSequence.Sgr.resetUnderline.toString())
        assertEquals("\u001B[25m", AnsiControlSequence.Sgr.resetBlink.toString())
        assertEquals("\u001B[27m", AnsiControlSequence.Sgr.resetReverse.toString())
        assertEquals("\u001B[28m", AnsiControlSequence.Sgr.resetHidden.toString())
        assertEquals("\u001B[29m", AnsiControlSequence.Sgr.resetStrikethrough.toString())
        
        // Test foreground colors
        assertEquals("\u001B[30m", AnsiControlSequence.Sgr.fgBlack.toString())
        assertEquals("\u001B[31m", AnsiControlSequence.Sgr.fgRed.toString())
        assertEquals("\u001B[32m", AnsiControlSequence.Sgr.fgGreen.toString())
        assertEquals("\u001B[33m", AnsiControlSequence.Sgr.fgYellow.toString())
        assertEquals("\u001B[34m", AnsiControlSequence.Sgr.fgBlue.toString())
        assertEquals("\u001B[35m", AnsiControlSequence.Sgr.fgMagenta.toString())
        assertEquals("\u001B[36m", AnsiControlSequence.Sgr.fgCyan.toString())
        assertEquals("\u001B[37m", AnsiControlSequence.Sgr.fgWhite.toString())
        assertEquals("\u001B[39m", AnsiControlSequence.Sgr.fgDefault.toString())
        
        // Test background colors
        assertEquals("\u001B[40m", AnsiControlSequence.Sgr.bgBlack.toString())
        assertEquals("\u001B[41m", AnsiControlSequence.Sgr.bgRed.toString())
        assertEquals("\u001B[42m", AnsiControlSequence.Sgr.bgGreen.toString())
        assertEquals("\u001B[43m", AnsiControlSequence.Sgr.bgYellow.toString())
        assertEquals("\u001B[44m", AnsiControlSequence.Sgr.bgBlue.toString())
        assertEquals("\u001B[45m", AnsiControlSequence.Sgr.bgMagenta.toString())
        assertEquals("\u001B[46m", AnsiControlSequence.Sgr.bgCyan.toString())
        assertEquals("\u001B[47m", AnsiControlSequence.Sgr.bgWhite.toString())
        assertEquals("\u001B[49m", AnsiControlSequence.Sgr.bgDefault.toString())
        
        // Test bright foreground colors
        assertEquals("\u001B[90m", AnsiControlSequence.Sgr.fgBrightBlack.toString())
        assertEquals("\u001B[91m", AnsiControlSequence.Sgr.fgBrightRed.toString())
        assertEquals("\u001B[92m", AnsiControlSequence.Sgr.fgBrightGreen.toString())
        assertEquals("\u001B[93m", AnsiControlSequence.Sgr.fgBrightYellow.toString())
        assertEquals("\u001B[94m", AnsiControlSequence.Sgr.fgBrightBlue.toString())
        assertEquals("\u001B[95m", AnsiControlSequence.Sgr.fgBrightMagenta.toString())
        assertEquals("\u001B[96m", AnsiControlSequence.Sgr.fgBrightCyan.toString())
        assertEquals("\u001B[97m", AnsiControlSequence.Sgr.fgBrightWhite.toString())
        
        // Test bright background colors
        assertEquals("\u001B[100m", AnsiControlSequence.Sgr.bgBrightBlack.toString())
        assertEquals("\u001B[101m", AnsiControlSequence.Sgr.bgBrightRed.toString())
        assertEquals("\u001B[102m", AnsiControlSequence.Sgr.bgBrightGreen.toString())
        assertEquals("\u001B[103m", AnsiControlSequence.Sgr.bgBrightYellow.toString())
        assertEquals("\u001B[104m", AnsiControlSequence.Sgr.bgBrightBlue.toString())
        assertEquals("\u001B[105m", AnsiControlSequence.Sgr.bgBrightMagenta.toString())
        assertEquals("\u001B[106m", AnsiControlSequence.Sgr.bgBrightCyan.toString())
        assertEquals("\u001B[107m", AnsiControlSequence.Sgr.bgBrightWhite.toString())
    }
}