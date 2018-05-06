package com.nimtego.morse.model;

public interface WordConversion {
    // 1 - Dot 2 - Dash  3 - Space
    byte[] convert(final String text);
}
