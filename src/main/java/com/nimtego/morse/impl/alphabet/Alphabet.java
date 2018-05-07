package com.nimtego.morse.impl.alphabet;

/**
 * Created by Pavel Gavrilov
 */
public interface Alphabet {
    /**
     *
     * @param c character to convert
     * @return morse string composed of dash and dots if this character exists in alphabet, null otherwise
     */
    String toMorse(Character c);

    /**
     *
     * @param s morse string composed of dash and dots
     * @return character if param exist in alphabet, null otherwise
     */
    Character fromMorse(String s);
}
