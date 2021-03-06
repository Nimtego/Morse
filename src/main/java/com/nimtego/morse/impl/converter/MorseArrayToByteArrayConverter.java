package com.nimtego.morse.impl.converter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Pavel Gavrilov
 */
public abstract class MorseArrayToByteArrayConverter implements UnitConverter<byte[], String[]> {
    @Override
    public byte[] from(String[] smth) {
        if (smth.length == 0) {
            byte[] res = {3,3};
            return res;
        }
        List<Byte> bytes = new LinkedList<>();
        for (int i = 0; i < smth.length - 1; i++) {
            String s = smth[i];
            if (s.isEmpty())
                continue;
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
            Byte aByte = boxed[i];
            unboxed[i] = aByte;
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

    protected abstract Byte[] stringToBytes(String s);

    protected Byte symbolToByte(String symbol) {
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

    protected abstract String bytesToString(Byte[] bytes);
}
