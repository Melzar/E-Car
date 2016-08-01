package com.ecode.ecar.datasource.bluetooth.impl;

import com.ecode.ecar.datasource.bluetooth.CarIgnitionStatusListener;
import com.ecode.ecar.event.CarIgnitionStatusEvent;
import com.openxc.measurements.Measurement;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by matuszewski on 01/08/16.
 */
public class CarIgnitionStatusListenerImpl implements CarIgnitionStatusListener {

    @Override
    public void receive(Measurement measurement) {
        EventBus.getDefault().post(new CarIgnitionStatusEvent(measurement));
    }
}
