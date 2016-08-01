package com.ecode.ecar.datasource.bluetooth.impl;

import com.ecode.ecar.datasource.bluetooth.CarAcceleratorPedalPositionListener;
import com.ecode.ecar.event.CarAcceleratorPedalPositionEvent;
import com.openxc.measurements.Measurement;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by matuszewski on 01/08/16.
 */
public class CarAcceleratorPedalPositionListenerImpl implements CarAcceleratorPedalPositionListener {

    @Override
    public void receive(Measurement measurement) {
        EventBus.getDefault().post(new CarAcceleratorPedalPositionEvent(measurement));
    }
}
