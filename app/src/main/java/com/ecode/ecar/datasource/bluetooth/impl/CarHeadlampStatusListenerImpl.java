package com.ecode.ecar.datasource.bluetooth.impl;

import com.ecode.ecar.datasource.bluetooth.CarHeadlampStatusListener;
import com.ecode.ecar.event.CarHeadlampStatusEvent;
import com.openxc.measurements.Measurement;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by matuszewski on 01/08/16.
 */
public class CarHeadlampStatusListenerImpl implements CarHeadlampStatusListener {

    @Override
    public void receive(Measurement measurement) {
        EventBus.getDefault().post(new CarHeadlampStatusEvent(measurement));
    }
}
