package com.nimtego.morse.impl.converter;

import com.nimtego.morse.impl.alphabet.Alphabet;

import java.util.Arrays;

/**
 * Created by Pavel Gavrilov
 */
public class TextToMorseArrayConverter implements UnitConverter<String[], String > {
    private Alphabet alphabet;

    public TextToMorseArrayConverter(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    @Override
    public String[] from(String text) {
        String[] raw = text.split(" ");
        return Arrays.stream(raw)
                .map(this::toMorse)
                .toArray(String[]::new);
    }

    @Override
    public String to(String[] smth) {
        return Arrays.stream(smth)
                .map(this::fromMorse)
                .map(s -> s+ " ")
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString().trim();
    }

    private String fromMorse(String text) {
        String[] strings = text.split(" ");
        return Arrays.stream(strings)
                .map(alphabet::fromMorse)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString().trim();
    }

    private String toMorse(String text) {
        String[] strings = text.split("");
        return Arrays.stream(strings)
                .map(s -> s.charAt(0))
                .map(alphabet::toMorse)
                .map(s -> s + " ")
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString().trim();
    }
}
