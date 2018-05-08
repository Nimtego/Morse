package com.nimtego.morse.impl.alphabet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Pavel Gavrilov
 */
public abstract class AlphabetImpl implements Alphabet {
    protected Properties alphabet = new Properties();

    public AlphabetImpl(String properties) {
        try {
            InputStream stream = getClass().getClassLoader().getResourceAsStream(properties);
            alphabet.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toMorse(Character c) {
        return alphabet.getProperty(getInRightCase(c));
    }

    protected String getInRightCase(Character c) {
        return String.valueOf(c);
    }

    @Override
    public abstract Character fromMorse(String s);
}
