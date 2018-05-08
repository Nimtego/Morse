package com.nimtego.morse.impl.converter;

/**
 * Created by Pavel Gavrilov
 */
public class MorseArrayToByteArrayNoStreamConverter extends MorseArrayToByteArrayConverter {
    @Override
    protected Byte[] stringToBytes(String s) {
        String[] strings = s.split("");
        Byte[] bytes = new Byte[strings.length];
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            bytes[i] = symbolToByte(string);
        }
        return bytes;
    }

    @Override
    protected String bytesToString(Byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Byte aByte : bytes) {
            stringBuilder.append(aByte);
        }
        return stringBuilder.toString();
    }
}
