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
    private double fuelLevel = 0.0;
    private double fuelConsumed = 0.0;
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

    @Bindable
    public double getFuelLevel() {
        return fuelLevel;
    }

    @Bindable
    public double getFuelConsumed() {
        return fuelConsumed;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
        notifyPropertyChanged(BR.fuelLevel);
    }

    public void setFuelConsumed(double fuelConsumed) {
        this.fuelConsumed = fuelConsumed;
        notifyPropertyChanged(BR.fuelConsumed);
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
