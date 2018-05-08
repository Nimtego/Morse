package com.nimtego.morse.impl.alphabet;

import java.util.Map;

/**
 * Created by Pavel Gavrilov
 */
public class AlphabetNoStream extends AlphabetImpl implements NoStreamAlphabet {
    public AlphabetNoStream(String properties) {
        super(properties);
    }

    @Override
    public Character fromMorse(String s) {
        Character result = null;
        for (Map.Entry<Object, Object> pair: alphabet.entrySet()){
            if (pair.getValue().equals(s))
                result = ((String)pair.getKey()).charAt(0);
        }
        return result;
    }
}
