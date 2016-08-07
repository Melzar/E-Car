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
    private double fuelConsumption = 0.0;
    private String gearNumber = "N";
    private boolean breakPedalEnabled = false;
    private boolean parkingBreakPedalEnabled = false;
    private boolean headlampEnabled = false;
    private boolean highBeamEnabled = false;
    private double carAcceleration = 0.0;

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
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @Bindable
    public boolean isBreakPedalEnabled() {
        return breakPedalEnabled;
    }

    @Bindable
    public double getCarAcceleration() {
        return carAcceleration;
    }

    @Bindable
    public boolean isParkingBreakPedalEnabled() {
        return parkingBreakPedalEnabled;
    }

    @Bindable
    public boolean isHeadlampEnabled() {
        return headlampEnabled;
    }

    @Bindable
    public boolean isHighBeamEnabled() {
        return highBeamEnabled;
    }

    public void setHeadlampEnabled(boolean headlampEnabled) {
        this.headlampEnabled = headlampEnabled;
        notifyPropertyChanged(BR.headlampEnabled);
    }

    public void setHighBeamEnabled(boolean highBeamEnabled) {
        this.highBeamEnabled = highBeamEnabled;
        notifyPropertyChanged(BR.highBeamEnabled);
    }

    public void setParkingBreakPedalEnabled(boolean parkingBreakPedalEnabled) {
        this.parkingBreakPedalEnabled = parkingBreakPedalEnabled;
        notifyPropertyChanged(BR.parkingBreakPedalEnabled);
    }

    public void setCarAcceleration(double carAcceleration) {
        this.carAcceleration = carAcceleration;
        notifyPropertyChanged(BR.carAcceleration);
    }

    public void setBreakPedalEnabled(boolean breakPedalEnabled) {
        this.breakPedalEnabled = breakPedalEnabled;
        notifyPropertyChanged(BR.breakPedalEnabled);
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
        notifyPropertyChanged(BR.fuelLevel);
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        notifyPropertyChanged(BR.fuelConsumption);
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
