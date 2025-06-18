package io.github.stream29.ansikmp

import io.github.stream29.ansikmp.AnsiConstants.background
import io.github.stream29.ansikmp.AnsiConstants.csi
import io.github.stream29.ansikmp.AnsiConstants.cursorBackward
import io.github.stream29.ansikmp.AnsiConstants.cursorDown
import io.github.stream29.ansikmp.AnsiConstants.cursorForward
import io.github.stream29.ansikmp.AnsiConstants.cursorHorizontalAbsolute
import io.github.stream29.ansikmp.AnsiConstants.cursorNextLine
import io.github.stream29.ansikmp.AnsiConstants.cursorPosition
import io.github.stream29.ansikmp.AnsiConstants.cursorPreviousLine
import io.github.stream29.ansikmp.AnsiConstants.cursorUp
import io.github.stream29.ansikmp.AnsiConstants.eraseInDisplay
import io.github.stream29.ansikmp.AnsiConstants.eraseInLine
import io.github.stream29.ansikmp.AnsiConstants.foreground
import io.github.stream29.ansikmp.AnsiConstants.indexedColor
import io.github.stream29.ansikmp.AnsiConstants.restoreCursor
import io.github.stream29.ansikmp.AnsiConstants.rgbColor
import io.github.stream29.ansikmp.AnsiConstants.saveCursor
import io.github.stream29.ansikmp.AnsiConstants.scrollDown
import io.github.stream29.ansikmp.AnsiConstants.scrollUp
import io.github.stream29.ansikmp.AnsiConstants.sgr
import kotlin.jvm.JvmInline

/**
 * Base interface for all ANSI control sequences.
 *
 * This interface is implemented by all classes that represent different types
 * of ANSI control sequences (SGR, cursor movement, erase, scroll, etc.).
 * Each implementation must provide a toString() method that returns the
 * appropriate sequence string.
 */
public sealed interface AnsiControlSequence {
    public override fun toString(): String
    /**
     * Represents a Select Graphic Rendition (SGR) parameter.
     *
     * SGR parameters are used to control text styling such as color, bold, italic, etc.
     * This class encapsulates a single SGR parameter value and provides constants for
     * all standard SGR parameters.
     *
     * Example:
     * ```kotlin
     * // Set text to bold red
     * val boldRed = Ansi { Sgr.bold }
     * println("${boldRed}This text is bold${Ansi { Sgr.reset }}")
     * ```
     *
     * @property value The integer value of the SGR parameter
     */
    @JvmInline
    public value class Sgr(public val value: Int): AnsiControlSequence {
        override fun toString(): String = "$csi$value$sgr"

        /**
         * Provides constants for all standard SGR parameters.
         *
         * These constants include text styles (bold, italic, etc.),
         * standard colors (both foreground and background),
         * and bright colors (both foreground and background).
         */
        public companion object Intrinsics {
            /** Reset all attributes */
            public val reset: Sgr = Sgr(0)
            /** Bold or increased intensity */
            public val bold: Sgr = Sgr(1)
            /** Faint or decreased intensity */
            public val dim: Sgr = Sgr(2)
            /** Italic style */
            public val italic: Sgr = Sgr(3)
            /** Underline */
            public val underline: Sgr = Sgr(4)
            /** Slow blink */
            public val blink: Sgr = Sgr(5)
            /** Rapid blink */
            public val rapidBlink: Sgr = Sgr(6)
            /** Reverse video (swap foreground and background colors) */
            public val reverse: Sgr = Sgr(7)
            /** Conceal (hide text) */
            public val hidden: Sgr = Sgr(8)
            /** Crossed-out text */
            public val strikethrough: Sgr = Sgr(9)
            /** Reset bold and dim */
            public val resetBoldDim: Sgr = Sgr(22)
            /** Reset italic */
            public val resetItalic: Sgr = Sgr(23)
            /** Reset underline */
            public val resetUnderline: Sgr = Sgr(24)
            /** Reset blink */
            public val resetBlink: Sgr = Sgr(25)
            /** Reset reverse */
            public val resetReverse: Sgr = Sgr(27)
            /** Reset hidden */
            public val resetHidden: Sgr = Sgr(28)
            /** Reset strikethrough */
            public val resetStrikethrough: Sgr = Sgr(29)
            /** Black foreground color */
            public val fgBlack: Sgr = Sgr(30)
            /** Red foreground color */
            public val fgRed: Sgr = Sgr(31)
            /** Green foreground color */
            public val fgGreen: Sgr = Sgr(32)
            /** Yellow foreground color */
            public val fgYellow: Sgr = Sgr(33)
            /** Blue foreground color */
            public val fgBlue: Sgr = Sgr(34)
            /** Magenta foreground color */
            public val fgMagenta: Sgr = Sgr(35)
            /** Cyan foreground color */
            public val fgCyan: Sgr = Sgr(36)
            /** White foreground color */
            public val fgWhite: Sgr = Sgr(37)
            /** Default foreground color */
            public val fgDefault: Sgr = Sgr(39)
            /** Black background color */
            public val bgBlack: Sgr = Sgr(40)
            /** Red background color */
            public val bgRed: Sgr = Sgr(41)
            /** Green background color */
            public val bgGreen: Sgr = Sgr(42)
            /** Yellow background color */
            public val bgYellow: Sgr = Sgr(43)
            /** Blue background color */
            public val bgBlue: Sgr = Sgr(44)
            /** Magenta background color */
            public val bgMagenta: Sgr = Sgr(45)
            /** Cyan background color */
            public val bgCyan: Sgr = Sgr(46)
            /** White background color */
            public val bgWhite: Sgr = Sgr(47)
            /** Default background color */
            public val bgDefault: Sgr = Sgr(49)
            /** Bright black (gray) foreground color */
            public val fgBrightBlack: Sgr = Sgr(90)
            /** Bright red foreground color */
            public val fgBrightRed: Sgr = Sgr(91)
            /** Bright green foreground color */
            public val fgBrightGreen: Sgr = Sgr(92)
            /** Bright yellow foreground color */
            public val fgBrightYellow: Sgr = Sgr(93)
            /** Bright blue foreground color */
            public val fgBrightBlue: Sgr = Sgr(94)
            /** Bright magenta foreground color */
            public val fgBrightMagenta: Sgr = Sgr(95)
            /** Bright cyan foreground color */
            public val fgBrightCyan: Sgr = Sgr(96)
            /** Bright white foreground color */
            public val fgBrightWhite: Sgr = Sgr(97)
            /** Bright black (gray) background color */
            public val bgBrightBlack: Sgr = Sgr(100)
            /** Bright red background color */
            public val bgBrightRed: Sgr = Sgr(101)
            /** Bright green background color */
            public val bgBrightGreen: Sgr = Sgr(102)
            /** Bright yellow background color */
            public val bgBrightYellow: Sgr = Sgr(103)
            /** Bright blue background color */
            public val bgBrightBlue: Sgr = Sgr(104)
            /** Bright magenta background color */
            public val bgBrightMagenta: Sgr = Sgr(105)
            /** Bright cyan background color */
            public val bgBrightCyan: Sgr = Sgr(106)
            /** Bright white background color */
            public val bgBrightWhite: Sgr = Sgr(107)
        }
    }
    /**
     * Represents advanced SGR parameters for rich color support.
     *
     * This interface provides support for 24-bit RGB colors and 8-bit indexed colors
     * for both foreground and background.
     *
     * Example:
     * ```kotlin
     * // Set foreground to RGB color (255, 100, 50)
     * val orangeText = Ansi { RichSgr.rgbForeground(255, 100, 50) }
     * println("${orangeText}This text is orange${Ansi { Sgr.reset }}")
     * ```
     */
    public sealed interface RichSgr: AnsiControlSequence {
        /**
         * Represents a color value for use with RichSgr.
         *
         * This interface has two implementations:
         * - [Rgb] for 24-bit true color (RGB)
         * - [Indexed] for 8-bit indexed color
         */
        public sealed interface Color {
            public override fun toString(): String

            /**
             * Represents a 24-bit RGB color.
             *
             * @property r Red component (0-255)
             * @property g Green component (0-255)
             * @property b Blue component (0-255)
             */
            public class Rgb(
                public val r: Int,
                public val g: Int,
                public val b: Int,
            ): Color {
                override fun toString(): String = "$rgbColor;$r;$g;$b"
            }

            /**
             * Represents an 8-bit indexed color.
             *
             * Standard indexed colors:
             * - 0-7: Standard colors (same as SGR 30-37)
             * - 8-15: High intensity colors (same as SGR 90-97)
             * - 16-231: 6×6×6 color cube
             * - 232-255: Grayscale from black to white in 24 steps
             *
             * @property index Color index (0-255)
             */
            @JvmInline
            public value class Indexed(public val index: Int): Color {
                override fun toString(): String = "$indexedColor;$index"
            }
        }

        /**
         * Sets the background color using advanced color modes.
         *
         * @property color The color to use for the background
         */
        @JvmInline
        public value class Background(public val color: Color): RichSgr {
            override fun toString(): String = "$csi$background;$color$sgr"
        }

        /**
         * Sets the foreground color using advanced color modes.
         *
         * @property color The color to use for the foreground
         */
        @JvmInline
        public value class Foreground(public val color: Color): RichSgr {
            override fun toString(): String = "$csi$foreground;$color$sgr"
        }

        /**
         * Provides convenience methods for creating RichSgr instances.
         */
        public companion object ShortHands {
            /**
             * Creates a foreground color using RGB values.
             *
             * @param r Red component (0-255)
             * @param g Green component (0-255)
             * @param b Blue component (0-255)
             * @return A RichSgr instance for the specified RGB foreground color
             */
            public fun rgbForeground(r: Int, g: Int, b: Int): RichSgr = Foreground(Color.Rgb(r, g, b))

            /**
             * Creates a background color using RGB values.
             *
             * @param r Red component (0-255)
             * @param g Green component (0-255)
             * @param b Blue component (0-255)
             * @return A RichSgr instance for the specified RGB background color
             */
            public fun rgbBackground(r: Int, g: Int, b: Int): RichSgr = Background(Color.Rgb(r, g, b))

            /**
             * Creates a foreground color using an indexed color.
             *
             * @param index Color index (0-255)
             * @return A RichSgr instance for the specified indexed foreground color
             */
            public fun indexedForeground(index: Int): RichSgr = Foreground(Color.Indexed(index))

            /**
             * Creates a background color using an indexed color.
             *
             * @param index Color index (0-255)
             * @return A RichSgr instance for the specified indexed background color
             */
            public fun indexedBackground(index: Int): RichSgr = Background(Color.Indexed(index))
        }
    }
    /**
     * Represents cursor movement and positioning operations.
     *
     * This interface provides various implementations for moving the cursor
     * in different directions, positioning it at specific coordinates,
     * and saving/restoring cursor positions.
     *
     * Example:
     * ```kotlin
     * // Move cursor up 2 lines
     * val moveUp = Ansi { Cursor.Up(2) }
     * println(moveUp)
     *
     * // Position cursor at row 5, column 10
     * val position = Ansi { Cursor.Position(5, 10) }
     * println(position)
     * ```
     */
    public sealed interface Cursor: AnsiControlSequence {
        /**
         * Moves the cursor up by the specified number of lines.
         *
         * @property n Number of lines to move (default: 1)
         */
        @JvmInline
        public value class Up(public val n: Int = 1): Cursor {
            override fun toString(): String = "$csi$n$cursorUp"
        }

        /**
         * Moves the cursor down by the specified number of lines.
         *
         * @property n Number of lines to move (default: 1)
         */
        @JvmInline
        public value class Down(public val n: Int = 1): Cursor {
            override fun toString(): String = "$csi$n$cursorDown"
        }

        /**
         * Moves the cursor forward (right) by the specified number of columns.
         *
         * @property n Number of columns to move (default: 1)
         */
        @JvmInline
        public value class Forward(public val n: Int = 1): Cursor {
            override fun toString(): String = "$csi$n$cursorForward"
        }

        /**
         * Moves the cursor backward (left) by the specified number of columns.
         *
         * @property n Number of columns to move (default: 1)
         */
        @JvmInline
        public value class Backward(public val n: Int = 1): Cursor {
            override fun toString(): String = "$csi$n$cursorBackward"
        }

        /**
         * Moves the cursor to the beginning of the line n lines down.
         *
         * @property n Number of lines to move down (default: 1)
         */
        @JvmInline
        public value class NextLine(public val n: Int = 1): Cursor {
            override fun toString(): String = "$csi$n$cursorNextLine"
        }

        /**
         * Moves the cursor to the beginning of the line n lines up.
         *
         * @property n Number of lines to move up (default: 1)
         */
        @JvmInline
        public value class PreviousLine(public val n: Int = 1): Cursor {
            override fun toString(): String = "$csi$n$cursorPreviousLine"
        }

        /**
         * Moves the cursor to the specified column in the current row.
         *
         * @property n Column number (1-based, default: 1)
         */
        @JvmInline
        public value class HorizontalAbsolute(public val n: Int = 1): Cursor {
            override fun toString(): String = "$csi$n$cursorHorizontalAbsolute"
        }

        /**
         * Positions the cursor at the specified row and column.
         *
         * @property row Row number (1-based, default: 1)
         * @property column Column number (1-based, default: 1)
         */
        public class Position(public val row: Int = 1, public val column: Int = 1): Cursor {
            override fun toString(): String = "$csi$row;$column$cursorPosition"
        }

        /**
         * Saves the current cursor position.
         *
         * The position can be restored later using [Restore].
         */
        public object Save: Cursor {
            override fun toString(): String = "$csi$saveCursor"
        }

        /**
         * Restores the cursor to a previously saved position.
         *
         * The position must have been saved using [Save].
         */
        public object Restore: Cursor {
            override fun toString(): String = "$csi$restoreCursor"
        }
    }
    /**
     * Represents screen and line erasing operations.
     *
     * This interface provides implementations for erasing parts of the display
     * or individual lines.
     *
     * Example:
     * ```kotlin
     * // Clear entire screen
     * val clearScreen = Ansi { Erase.InDisplay(2) }
     * println(clearScreen)
     *
     * // Clear from cursor to end of line
     * val clearToEndOfLine = Ansi { Erase.InLine() }
     * println(clearToEndOfLine)
     * ```
     */
    public sealed interface Erase: AnsiControlSequence {
        /**
         * Erases parts of the display/screen.
         *
         * @property n Erase mode:
         *   - 0 (default): Erase from cursor to end of screen
         *   - 1: Erase from cursor to beginning of screen
         *   - 2: Erase the entire screen
         *   - 3: Erase the entire screen and scrollback buffer (if supported)
         */
        @JvmInline
        public value class InDisplay(public val n: Int = 0): Erase {
            override fun toString(): String = "$csi$n$eraseInDisplay"
        }

        /**
         * Erases parts of the current line.
         *
         * @property n Erase mode:
         *   - 0 (default): Erase from cursor to end of line
         *   - 1: Erase from cursor to beginning of line
         *   - 2: Erase the entire line
         */
        @JvmInline
        public value class InLine(public val n: Int = 0): Erase {
            override fun toString(): String = "$csi$n$eraseInLine"
        }
    }

    /**
     * Represents scrolling operations.
     *
     * This interface provides implementations for scrolling the screen
     * content up or down.
     *
     * Example:
     * ```kotlin
     * // Scroll up 3 lines
     * val scrollUp = Ansi { Scroll.Up(3) }
     * println(scrollUp)
     * ```
     */
    public sealed interface Scroll: AnsiControlSequence {
        /**
         * Scrolls the screen content up by the specified number of lines.
         * New lines are added at the bottom.
         *
         * @property n Number of lines to scroll (default: 1)
         */
        @JvmInline
        public value class Up(public val n: Int = 1): Scroll {
            override fun toString(): String = "$csi$n$scrollUp"
        }

        /**
         * Scrolls the screen content down by the specified number of lines.
         * New lines are added at the top.
         *
         * @property n Number of lines to scroll (default: 1)
         */
        @JvmInline
        public value class Down(public val n: Int = 1): Scroll {
            override fun toString(): String = "$csi$n$scrollDown"
        }
    }
}