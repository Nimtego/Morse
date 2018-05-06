package com.nimtego.morse.presenter;

import android.view.View;

import com.nimtego.morse.view.CommonView;

public interface Presenter<T extends CommonView> extends View.OnClickListener {
    void attach(T view);
    void detach();
}
