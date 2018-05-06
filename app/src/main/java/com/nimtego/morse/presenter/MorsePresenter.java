package com.nimtego.morse.presenter;

import android.view.View;

import com.nimtego.morse.model.TestWordConversion;
import com.nimtego.morse.model.WordConversion;

public class MorsePresenter extends AbstractBasePresenter {
    private WordConversion mWordConversion;

    @Override
    public void onClick(View view) {
        if (mWordConversion == null)
            mWordConversion = new TestWordConversion();

     }
}
