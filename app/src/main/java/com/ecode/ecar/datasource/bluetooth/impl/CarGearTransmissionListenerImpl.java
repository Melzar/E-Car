package com.ecode.ecar.datasource.bluetooth.impl;

import com.ecode.ecar.datasource.bluetooth.CarGearTransmissionListener;
import com.ecode.ecar.event.CarGearTransmissionEvent;
import com.openxc.measurements.Measurement;
import com.openxc.measurements.TransmissionGearPosition;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by matuszewski on 31/07/16.
 */
public class CarGearTransmissionListenerImpl implements CarGearTransmissionListener {
    @Override
    public void receive(Measurement measurement) {
        EventBus.getDefault().post( new CarGearTransmissionEvent(measurement));
    }
}
