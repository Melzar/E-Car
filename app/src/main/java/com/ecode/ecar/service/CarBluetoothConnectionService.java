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

//public class StarterActivity extends Activity {
//    private static final String TAG = "StarterActivity";
//
//    private VehicleManager mVehicleManager;
//    private TextView mEngineSpeedView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_starter);
//        // grab a reference to the engine speed text object in the UI, so we can
//        // manipulate its value later from Java code
//        mEngineSpeedView = (TextView) findViewById(R.id.engine_speed);
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        // When the activity goes into the background or exits, we want to make
//        // sure to unbind from the service to avoid leaking memory
//        if(mVehicleManager != null) {
//            Log.i(TAG, "Unbinding from Vehicle Manager");
//            // Remember to remove your listeners, in typical Android
//            // fashion.
//            mVehicleManager.removeListener(EngineSpeed.class,
//                    mSpeedListener);
//            unbindService(mConnection);
//            mVehicleManager = null;
//        }
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        // When the activity starts up or returns from the background,
//        // re-connect to the VehicleManager so we can receive updates.
//        if(mVehicleManager == null) {
//            Intent intent = new Intent(this, VehicleManager.class);
//            bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
//        }
//    }
//
//    /* This is an OpenXC measurement listener object - the type is recognized
//     * by the VehicleManager as something that can receive measurement updates.
//     * Later in the file, we'll ask the VehicleManager to call the receive()
//     * function here whenever a new EngineSpeed value arrives.
//     */
//    EngineSpeed.Listener mSpeedListener = new EngineSpeed.Listener() {
//        @Override
//        public void receive(Measurement measurement) {
//            // When we receive a new EngineSpeed value from the car, we want to
//            // update the UI to display the new value. First we cast the generic
//            // Measurement back to the type we know it to be, an EngineSpeed.
//            final EngineSpeed speed = (EngineSpeed) measurement;
//            // In order to modify the UI, we have to make sure the code is
//            // running on the "UI thread" - Google around for this, it's an
//            // important concept in Android.
//            StarterActivity.this.runOnUiThread(new Runnable() {
//                public void run() {
//                    // Finally, we've got a new value and we're running on the
//                    // UI thread - we set the text of the EngineSpeed view to
//                    // the latest value
//                    mEngineSpeedView.setText("Engine speed (RPM): "
//                            + speed.getValue().doubleValue());
//                }
//            });
//        }
//    };
