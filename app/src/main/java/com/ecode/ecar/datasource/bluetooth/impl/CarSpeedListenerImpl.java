package com.ecode.ecar.datasource.bluetooth.impl;

import com.ecode.ecar.datasource.bluetooth.CarSpeedListener;
import com.ecode.ecar.event.CarSpeedEvent;
import com.openxc.measurements.Measurement;
import com.openxc.measurements.VehicleSpeed;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by matuszewski on 31/07/16.
 */
public class CarSpeedListenerImpl implements CarSpeedListener{

    @Override
    public void receive(Measurement measurement) {
        EventBus.getDefault().post(new CarSpeedEvent(measurement));
    }
}
