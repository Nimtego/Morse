package com.nimtego.morse.impl.converter;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Pavel Gavrilov
 */
public class MorseArrayToByteArrayNoStreamConverter extends MorseArrayToByteArrayConverter {
    @Override
    protected Byte[] stringToBytes(String s) {
        String[] strings = s.split("");
        List<Byte> byteList = new LinkedList<>();
        for (String string : strings) {
            Byte aByte = symbolToByte(string);
            if (aByte == null)
                continue;
            byteList.add(aByte);
        }
        return byteList.toArray(new Byte[0]);
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
