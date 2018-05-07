package com.nimtego.morse.impl.converter;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Pavel Gavrilov
 */
public class MorseArrayToByteArrayConverterTest {
    private static UnitConverter<byte[], String[]> converter;

    @BeforeClass
    public static void init() {
        converter = new MorseArrayToByteArrayConverter();
    }

    @Test
    public void singleWordConvertTest() {
        final String[] array = {"... --- .-.- --..--"};
        final byte[] expected = {1,1,1,3,2,2,2,3,1,2,1,2,3,2,2,1,1,2,2};
        byte[] actual = converter.from(array);
        if (actual.length == 0)
            fail("Array is empty");
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void multiWordConvertTest() {
        final String[] array = {"... --- .-.- --..--", "--..-- .-.- --- ..."};
        final byte[] expected = {1,1,1,3,2,2,2,3,1,2,1,2,3,2,2,1,1,2,2,3,3,2,2,1,1,2,2,3,1,2,1,2,3,2,2,2,3,1,1,1};
        byte[] actual = converter.from(array);
        if (actual.length == 0)
            fail("Array is empty");
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void singleMorseWordTest() {
        final byte[] array = {1,1,1,3,2,2,2,3,1,2,1,2,3,2,2,1,1,2,2};
        final String[] expected = {"... --- .-.- --..--"};
        String[] actual = converter.to(array);
        if (actual.length == 0)
            fail("Array is empty");
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void multiMorseWordConvertTest() {
        final byte[] array = {1,1,1,3,2,2,2,3,1,2,1,2,3,2,2,1,1,2,2,3,3,2,2,1,1,2,2,3,1,2,1,2,3,2,2,2,3,1,1,1};
        final String[] expected = {"... --- .-.- --..--", "--..-- .-.- --- ..."};
        String[] actual = converter.to(array);
        if (actual.length == 0)
            fail("Array is empty");
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
}
