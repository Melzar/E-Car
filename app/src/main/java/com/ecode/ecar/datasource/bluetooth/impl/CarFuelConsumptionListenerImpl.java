package com.ecode.ecar.datasource.bluetooth.impl;

import com.ecode.ecar.datasource.bluetooth.CarFuelConsumptionListener;
import com.ecode.ecar.event.CarFuelConsumptionEvent;
import com.openxc.measurements.Measurement;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by matuszewski on 01/08/16.
 */
public class CarFuelConsumptionListenerImpl implements CarFuelConsumptionListener {

    @Override
    public void receive(Measurement measurement) {
        EventBus.getDefault().post(new CarFuelConsumptionEvent(measurement));
    }
}
