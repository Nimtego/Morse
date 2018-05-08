package com.nimtego.morse.impl.alphabet;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pavel Gavrilov
 */
public class EnglishAlphabetTest {
    private static EnglishAlphabetNoStream alphabet;

    @BeforeClass
    public static void init() {
        alphabet = new EnglishAlphabetNoStream();
    }

    @Test
    public void caseInsensitivityTest() {
        final String expected = ".-";
        String actual = alphabet.toMorse('A');
        assertEquals(expected, actual);
        actual = alphabet.toMorse('a');
        assertEquals(expected, actual);
    }
}