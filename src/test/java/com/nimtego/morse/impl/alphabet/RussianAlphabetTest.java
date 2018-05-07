package com.nimtego.morse.impl.alphabet;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pavel Gavrilov
 */
public class RussianAlphabetTest {
    private static RussianAlphabet alphabet;

    @BeforeClass
    public static void init() {
        alphabet = new RussianAlphabet();
    }

    @Test
    public void caseInsensitivityTest() {
        final String expected = "--.-";
        String actual = alphabet.toMorse('Щ');
        assertEquals(expected, actual);
        actual = alphabet.toMorse('щ');
        assertEquals(expected, actual);
    }
}