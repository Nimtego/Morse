package com.nimtego.morse.impl;

import com.nimtego.morse.api.WordConversion;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        WordConversion conversion = new RussianNoStreamWordConversion();
        byte[] писка = conversion.convert("Писка");
        for (int i = 0; i < писка.length; i++) {
            byte b = писка[i];
            System.out.print(b);
        }
    }
}