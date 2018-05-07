package com.nimtego.morse.impl;

import com.nimtego.morse.impl.alphabet.EnglishAlphabet;
import com.nimtego.morse.impl.converter.TextToMorseArrayConverter;
import com.nimtego.morse.impl.converter.UnitConverter;

/**
 * Created by Pavel Gavrilov
 */
public class EnglishWordConversion extends AbstractWordConversion {
    private UnitConverter<String[], String> textToMorseArrayConverter;

    public EnglishWordConversion() {
        textToMorseArrayConverter = new TextToMorseArrayConverter(new EnglishAlphabet());
    }

    @Override
    protected String[] convertToStringArray(String text) {
        return textToMorseArrayConverter.from(text);
    }
}
