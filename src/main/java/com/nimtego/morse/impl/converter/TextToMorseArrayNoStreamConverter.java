package com.nimtego.morse.impl.converter;

import com.nimtego.morse.impl.alphabet.NoStreamAlphabet;

/**
 * Created by Pavel Gavrilov
 */
public class TextToMorseArrayNoStreamConverter implements UnitConverter<String[], String> {
    private NoStreamAlphabet alphabet;

    public TextToMorseArrayNoStreamConverter(NoStreamAlphabet alphabet) {
        this.alphabet = alphabet;
    }

    @Override
    public String[] from(String text) {
        String[] raw = text.split(" ");
        String[] morses = new String[raw.length];
        for (int i = 0; i < raw.length; i++) {
            String s = toMorse(raw[i]);
            morses[i] = s;
        }
        return morses;
    }

    @Override
    public String to(String[] smth) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : smth) {
            stringBuilder
                    .append(fromMorse(s))
                    .append(" ");
        }
        return stringBuilder.toString().trim();
    }

    private String fromMorse(String text) {
        String[] strings = text.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(alphabet.fromMorse(string));
        }
        return stringBuilder.toString().trim();
    }

    private String toMorse(String text) {
        String[] strings = text.split("");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) {
            if (!s.isEmpty()) {
                String ch = alphabet.toMorse(s.charAt(0));
                if (ch != null)
                    stringBuilder
                            .append(ch)
                            .append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }
}
