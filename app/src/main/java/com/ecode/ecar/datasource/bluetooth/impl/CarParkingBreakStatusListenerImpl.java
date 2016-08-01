package com.ecode.ecar.datasource.bluetooth.impl;

import com.ecode.ecar.datasource.bluetooth.CarParkingBreakStatusListener;
import com.ecode.ecar.event.CarParkingBreakStatusEvent;
import com.openxc.measurements.Measurement;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by matuszewski on 01/08/16.
 */
public class CarParkingBreakStatusListenerImpl implements CarParkingBreakStatusListener {

    @Override
    public void receive(Measurement measurement) {
        EventBus.getDefault().post(new CarParkingBreakStatusEvent(measurement));
    }
}
