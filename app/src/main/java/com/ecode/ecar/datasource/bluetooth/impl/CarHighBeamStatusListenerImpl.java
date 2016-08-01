package com.ecode.ecar.datasource.bluetooth.impl;

import com.ecode.ecar.datasource.bluetooth.CarHighBeamStatusListener;
import com.ecode.ecar.event.CarHighBeamStatusEvent;
import com.openxc.measurements.HighBeamStatus;
import com.openxc.measurements.Measurement;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by matuszewski on 01/08/16.
 */
public class CarHighBeamStatusListenerImpl implements CarHighBeamStatusListener {

    @Override
    public void receive(Measurement measurement) {
        EventBus.getDefault().post(new CarHighBeamStatusEvent(measurement));
    }
}
