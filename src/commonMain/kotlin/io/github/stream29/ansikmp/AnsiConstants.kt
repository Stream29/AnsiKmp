package io.github.stream29.ansikmp

/**
 * ANSI escape sequence constants and helpers for terminal control.
 *
 * This object provides constants for common ANSI escape sequence codes, including
 * - [csi]: Control Sequence Introducer (`ESC[`)
 * - [sgr]: Select Graphic Rendition (m)
 * - [background], [foreground]: SGR color mode selectors
 * - [indexedColor], [rgbColor]: SGR color parameter selectors
 * - Cursor movement: [cursorUp], [cursorDown], [cursorForward], [cursorBackward],
 *   [cursorNextLine], [cursorPreviousLine], [cursorHorizontalAbsolute], [cursorPosition]
 * - Cursor state: [saveCursor], [restoreCursor]
 * - Screen/line clearing: [eraseInDisplay], [eraseInLine]
 * - Scrolling: [scrollUp], [scrollDown]
 *
 * These constants can be used to construct ANSI escape sequences for controlling
 * terminal output, such as moving the cursor, clearing the screen, or setting text styles/colors.
 *
 * For more details, see: [Wikipedia](https://en.wikipedia.org/wiki/ANSI_escape_code)
 */
@Suppress("ConstPropertyName")
public object AnsiConstants {
    public const val csi: String = "\u001B["
    public const val sgr: String = "m"
    public const val background: String = "48"
    public const val foreground: String = "38"
    public const val indexedColor: String = "5"
    public const val rgbColor: String = "2"
    public const val cursorUp: String = "A"
    public const val cursorDown: String = "B"
    public const val cursorForward: String = "C"
    public const val cursorBackward: String = "D"
    public const val cursorNextLine: String = "E"
    public const val cursorPreviousLine: String = "F"
    public const val cursorHorizontalAbsolute: String = "G"
    public const val cursorPosition: String = "H"
    public const val saveCursor: String = "s"
    public const val restoreCursor: String = "u"
    public const val eraseInDisplay: String = "J"
    public const val eraseInLine: String = "K"
    public const val scrollUp: String = "S"
    public const val scrollDown: String = "T"
}
