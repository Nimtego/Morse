package com.nimtego.morse.impl.converter;

import com.nimtego.morse.impl.alphabet.AlphabetImpl;
import com.nimtego.morse.impl.alphabet.AlphabetNoStream;
import com.nimtego.morse.impl.converter.TextToMorseArrayConverter;
import com.nimtego.morse.impl.converter.UnitConverter;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pavel Gavrilov
 */
public class TextToMorseArrayConverterTest {
    private static UnitConverter<String[], String> morseConverter;

    @BeforeClass
    public static void init() {
        morseConverter = new TextToMorseArrayNoStreamConverter(new AlphabetNoStream("test.alphabet.properties"));
    }

    @Test
    public void singleWordConvertTest() {
        final String text = "ABCD";
        final String[] expected = {"... --- .-.- --..--"};
        String[] actual = morseConverter.from(text);
        if (actual.length == 0)
            fail("Array is empty");
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void multiWordConvertTest() {
        final String text = "ABCD DCBA";
        final String[] expected = {"... --- .-.- --..--", "--..-- .-.- --- ..."};
        String[] actual = morseConverter.from(text);
        if (actual.length == 0)
            fail("Array is empty");
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void singleMorseWordTest() {
        final String[] array = {"... --- .-.- --..--"};
        final String expected = "ABCD";
        String actual = morseConverter.to(array);
        assertEquals(expected, actual);
    }

    @Test
    public void multiMorseWordConvertTest() {
        final String[] array = {"... --- .-.- --..--", "--..-- .-.- --- ..."};
        final String expected = "ABCD DCBA";
        String actual = morseConverter.to(array);
        assertEquals(expected, actual);
    }
}