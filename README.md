# ANSI-KMP

ANSI-KMP is a Kotlin Multiplatform library for working with ANSI escape sequences, which are used for terminal control such as text styling, cursor movement, and screen manipulation.

## Features

- Cross-platform support through Kotlin Multiplatform
- Comprehensive API for ANSI escape sequences
- Type-safe DSL for creating ANSI sequences
- Support for:
  - Text styling (bold, italic, underline, etc.)
  - Standard and bright colors (foreground and background)
  - 24-bit RGB colors and 8-bit indexed colors
  - Cursor movement and positioning
  - Screen and line erasing
  - Scrolling

## Installation

Add the dependency to your `build.gradle.kts` file:

```kotlin
dependencies {
    implementation("io.github.stream29:ansi-kmp:1.0.0")
}
```

## API Overview

### Main Components

- `AnsiControlSequence.Sgr` - Select Graphic Rendition parameters for text styling and basic colors
- `AnsiControlSequence.RichSgr` - Advanced color support (RGB and indexed colors)
- `AnsiControlSequence.Cursor` - Cursor movement and positioning
- `AnsiControlSequence.Erase` - Screen and line erasing
- `AnsiControlSequence.Scroll` - Screen scrolling

### Constants

The `AnsiConstants` object provides constants for all standard ANSI escape sequence codes:

- `csi` - Control Sequence Introducer (ESC [)
- `sgr` - Select Graphic Rendition (m)
- `background`, `foreground` - SGR color mode selectors
- `indexedColor`, `rgbColor` - SGR color parameter selectors
- Cursor movement: `cursorUp`, `cursorDown`, `cursorForward`, etc.
- Screen/line clearing: `eraseInDisplay`, `eraseInLine`
- Scrolling: `scrollUp`, `scrollDown`