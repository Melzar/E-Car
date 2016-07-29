package com.ecode.ecar.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ecode.ecar.R;
import com.ecode.ecar.datasource.bluetooth.CarEngineSpeedListener;
import com.ecode.ecar.service.CarBluetoothConnectionService;
import com.openxc.VehicleManager;
import com.openxc.measurements.EngineSpeed;
import com.openxc.measurements.Measurement;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

/**
 * Created by matuszewski on 27/07/16.
 */
public class BaseActivity extends AppCompatActivity {

    private CarBluetoothConnectionService carBluetoothConnectionService;

    @Override
    public void onCreate(@Nullable Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        carBluetoothConnectionService = new CarBluetoothConnectionService(new HashMap<Class, Measurement.Listener>(){{
               put(EngineSpeed.class, new CarEngineSpeedListener());
        }});
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onPause(){
        super.onPause();
        if(carBluetoothConnectionService.isVehicleManagerAvailable()) {
            unbindService(carBluetoothConnectionService);
            carBluetoothConnectionService.onServiceDisconnected(null);
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        if(!carBluetoothConnectionService.isVehicleManagerAvailable()) {
            Intent intent = new Intent(this, VehicleManager.class);
            bindService(intent, carBluetoothConnectionService, Context.BIND_AUTO_CREATE);
        }
    }

    @Override
    public void onStop(){
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    /*
     TODO It will have to be changed for applying multiple layouts for application,
     but as basic blueprint leave it now as it is
      */
    protected void setActivityContentView(int contentViewID){
        setContentView(contentViewID);
    }
}
