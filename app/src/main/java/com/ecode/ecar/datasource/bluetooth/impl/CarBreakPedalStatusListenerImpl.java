package com.ecode.ecar.datasource.bluetooth.impl;

import com.ecode.ecar.datasource.bluetooth.CarBreakPedalStatusListener;
import com.ecode.ecar.event.CarBreakPedalStatusEvent;
import com.openxc.measurements.Measurement;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by matuszewski on 01/08/16.
 */
public class CarBreakPedalStatusListenerImpl implements CarBreakPedalStatusListener {

    @Override
    public void receive(Measurement measurement) {
        EventBus.getDefault().post(new CarBreakPedalStatusEvent(measurement));
    }
}
