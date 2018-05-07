package com.nimtego.morse.impl;

import com.nimtego.morse.impl.alphabet.RussianAlphabet;
import com.nimtego.morse.impl.converter.TextToMorseArrayConverter;
import com.nimtego.morse.impl.converter.UnitConverter;

/**
 * Created by Pavel Gavrilov
 */
public class RussianWordConversion extends AbstractWordConversion {
    private UnitConverter<String[], String> textToMorseArrayConverter;

    public RussianWordConversion() {
        textToMorseArrayConverter = new TextToMorseArrayConverter(new RussianAlphabet());
    }

    @Override
    protected String[] convertToStringArray(String text) {
        return textToMorseArrayConverter.from(text);
    }
}
