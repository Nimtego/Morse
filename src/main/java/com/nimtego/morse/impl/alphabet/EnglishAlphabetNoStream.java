package com.nimtego.morse.impl.alphabet;

/**
 * Created by Pavel Gavrilov
 */
public class EnglishAlphabetNoStream extends AlphabetNoStream{
    public EnglishAlphabetNoStream() {
        super("english.morse.properties");
    }

    @Override
    public String getInRightCase(Character c) {
        return super.getInRightCase(c).toUpperCase();
    }
}
