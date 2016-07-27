package com.ecode.ecar.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.openxc.VehicleManager;

/**
 * Created by matuszewski on 27/07/16.
 */
public class CarBluetoothConnectionService implements ServiceConnection {

    private VehicleManager vehicleManager;

    public CarBluetoothConnectionService(){

    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        vehicleManager = ((VehicleManager.VehicleBinder) service).getService();

        // ADD listeners
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        vehicleManager = null;
    }
}
