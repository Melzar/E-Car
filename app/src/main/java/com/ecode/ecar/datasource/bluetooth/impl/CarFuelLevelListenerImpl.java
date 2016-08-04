package com.ecode.ecar.datasource.bluetooth.impl;

import com.ecode.ecar.datasource.bluetooth.CarFuelLevelListener;
import com.ecode.ecar.event.CarFuelLevelEvent;
import com.openxc.measurements.Measurement;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by matuszewski on 01/08/16.
 */
public class CarFuelLevelListenerImpl implements CarFuelLevelListener {
    @Override
    public void receive(Measurement measurement) {
        EventBus.getDefault().post(new CarFuelLevelEvent(measurement));
    }
}
