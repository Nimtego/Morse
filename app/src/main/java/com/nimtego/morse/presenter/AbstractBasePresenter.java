package com.nimtego.morse.presenter;

import android.support.v7.app.AppCompatActivity;

import com.nimtego.morse.view.CommonView;
import com.nimtego.morse.view.task.SimpleToastAlarm;
import com.nimtego.morse.view.task.ToastAlarm;

public abstract class AbstractBasePresenter<T extends CommonView> implements Presenter<T> {
    protected T commonView;
    protected ToastAlarm toastAlarm;


    @Override
    public void attach(T view) {
        this.commonView = view;
        this.toastAlarm = new SimpleToastAlarm(
                ((AppCompatActivity)commonView).getApplicationContext());
    }

    @Override
    public void detach() {
        this.commonView = null;
    }
}
