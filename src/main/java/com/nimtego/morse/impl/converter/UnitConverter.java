package com.nimtego.morse.impl.converter;

/**
 * Created by Pavel Gavrilov
 */
public interface UnitConverter<T, S> {
    T from(S smth);

    S to(T smth);
}
