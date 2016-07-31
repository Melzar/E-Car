package com.ecode.ecar.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.ecode.ecar.BR;
import com.ecode.ecar.R;

/**
 * Created by matuszewski on 29/07/16.
 */
public class CarAction extends BaseObservable{

    private int engineSpeed = 0;
    private int carSpeed = 0;
    private String gearNumber = "N";

    public CarAction() {
    }

    @Bindable
    public int getEngineSpeed() {
        return engineSpeed;
    }

    @Bindable
    public String getGearNumber() {
        return gearNumber;
    }

    @Bindable
    public int getCarSpeed() {
        return carSpeed;
    }

    public void setEngineSpeed(int engineSpeed) {
        this.engineSpeed = engineSpeed;
        notifyPropertyChanged(BR.engineSpeed);
    }

    public void setGearNumber(String gearNumber) {
        this.gearNumber = gearNumber;
        notifyPropertyChanged(BR.gearNumber);
    }

    public void setCarSpeed(int carSpeed) {
        this.carSpeed = carSpeed;
        notifyPropertyChanged(BR.carSpeed);
    }

}
