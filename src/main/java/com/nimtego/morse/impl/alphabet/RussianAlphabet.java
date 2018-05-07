package com.nimtego.morse.impl.alphabet;

/**
 * Created by Pavel Gavrilov
 */
public class RussianAlphabet extends AlphabetImpl {
    public RussianAlphabet() {
        super("russian.morse.properties");
    }

    @Override
    protected String getInRightCase(Character c) {
        return super.getInRightCase(c).toUpperCase();
    }
}
