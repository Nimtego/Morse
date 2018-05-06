package com.nimtego.morse.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nimtego.morse.R;

public class MorseActivity extends AppCompatActivity implements CommonView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morse);
    }

    @Override
    public void toast(String message) {

    }

    @Override
    public void alarm(String message) {

    }
}
