package com.nimtego.morse.impl;

import com.nimtego.morse.impl.alphabet.RussianAlphabetNoStream;
import com.nimtego.morse.impl.converter.TextToMorseArrayNoStreamConverter;
import com.nimtego.morse.impl.converter.UnitConverter;

/**
 * Created by Pavel Gavrilov
 */
public class RussianNoStreamWordConversion extends AbstractWordConversion {
    private UnitConverter<String[], String> textToMorseArrayConverter;

    public RussianNoStreamWordConversion() {
        textToMorseArrayConverter = new TextToMorseArrayNoStreamConverter(new RussianAlphabetNoStream());
    }

    @Override
    protected String[] convertToStringArray(String text) {
        return textToMorseArrayConverter.from(text);
    }
}
