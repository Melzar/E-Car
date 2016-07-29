package com.ecode.ecar.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.ecode.ecar.BR;

/**
 * Created by matuszewski on 29/07/16.
 */
public class CarAction extends BaseObservable{

    private double speed;

    public CarAction(double speed) {
        this.speed = speed;
    }

    @Bindable
    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
        notifyPropertyChanged(BR.speed);
    }
}
