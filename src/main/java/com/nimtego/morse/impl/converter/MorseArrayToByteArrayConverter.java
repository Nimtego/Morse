package com.nimtego.morse.impl.converter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Pavel Gavrilov
 */
public class MorseArrayToByteArrayConverter implements UnitConverter<byte[], String[]> {
    @Override
    public byte[] from(String[] smth) {
        List<Byte> bytes = new LinkedList<>();
        for (int i = 0; i < smth.length - 1; i++) {
            String s = smth[i];
            Byte[] word = stringToBytes(s);
            bytes.addAll(Arrays.asList(word));
            bytes.add((byte) 3);
            bytes.add((byte) 3);
        }
        String s = smth[smth.length - 1];
        Byte[] word = stringToBytes(s);
        bytes.addAll(Arrays.asList(word));
        Byte[] boxed = bytes.toArray(new Byte[0]);
        byte[] unboxed = new byte[boxed.length];
        for (int i = 0; i < boxed.length; i++) {
            unboxed[i] = boxed[i];
        }
        return unboxed;
    }

    @Override
    public String[] to(byte[] smth) {
        Byte[] boxed = new Byte[smth.length];
        for (int i = 0; i < smth.length; i++) {
            boxed[i] = smth[i];
        }
        String raw = bytesToString(boxed);
        String converted = raw
                .replaceAll("1", ".")
                .replaceAll("2", "-")
                .replaceAll("3", " ");
        return converted.split("  ");
    }

    private Byte[] stringToBytes(String s) {
        String[] strings = s.split("");
        return Arrays.stream(strings)
                .map(this::symbolToByte)
                .toArray(Byte[]::new);
    }

    private Byte symbolToByte(String symbol) {
        switch (symbol) {
            case ".":
                return (byte) 1;
            case "-":
                return (byte) 2;
            case " ":
                return (byte) 3;
            default:
                return null;
        }
    }

    private String bytesToString(Byte[] bytes) {
        return Arrays.stream(bytes)
                .map(String::valueOf)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
