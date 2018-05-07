package com.nimtego.morse.impl;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Pavel Gavrilov
 */
public class AlphabetTest extends Assert {
    private static AlphabetImpl alphabet;

    @BeforeClass
    public static void init() {
        alphabet= new AlphabetImpl("test.alphabet.properties");
    }

    @Test
    public void presentLetterIsNotNullTest() {
        String a = alphabet.toMorse('A');
        assertNotNull(a);
        assertEquals("...", a);
    }

    @Test
    public void absentLetterIsNullTest() {
        String z = alphabet.toMorse('Z');
        assertNull(z);
    }

    @Test
    public void presentMorseIsNotNullTest() {
        Character character = alphabet.fromMorse("...");
        assertNotNull(character);
        assertEquals(String.valueOf('A'), String .valueOf(character));
    }

    @Test
    public void absentMorseIsNullTest() {
        Character character = alphabet.fromMorse(".");
        assertNull(character);
    }
}
