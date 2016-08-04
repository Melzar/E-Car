package com.ecode.ecar.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;

import com.openxc.VehicleManager;
import com.openxc.measurements.EngineSpeed;
import com.openxc.measurements.Measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

/**
 * Created by matuszewski on 27/07/16.
 */
public class CarBluetoothConnectionService implements ServiceConnection {

    private VehicleManager vehicleManager;
    private HashMap<Class, Measurement.Listener> serviceListeners;

    public CarBluetoothConnectionService(
            HashMap<Class, Measurement.Listener> serviceListeners
    ){
        this.serviceListeners = serviceListeners;
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        vehicleManager = ((VehicleManager.VehicleBinder) service).getService();
        attachServiceListeners();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        detachServiceListeners();
        vehicleManager = null;
    }

    public boolean isVehicleManagerAvailable(){
        return vehicleManager != null;
    }

    public void attachServiceListeners(){
        Iterator<Entry<Class, Measurement.Listener>> iterator =
                serviceListeners.entrySet().iterator();
        while(iterator.hasNext()){
            Entry<Class, Measurement.Listener> entry = iterator.next();
            vehicleManager.addListener(entry.getKey(), entry.getValue());
        }
    }

    public void detachServiceListeners(){
        Iterator<Entry<Class, Measurement.Listener>> iterator =
                serviceListeners.entrySet().iterator();
        while(iterator.hasNext()){
            Entry<Class, Measurement.Listener> entry = iterator.next();
            vehicleManager.removeListener(entry.getKey(), entry.getValue());
        }
    }
}
