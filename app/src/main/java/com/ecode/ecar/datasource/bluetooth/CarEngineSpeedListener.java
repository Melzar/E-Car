package com.ecode.ecar.datasource.bluetooth;

import com.ecode.ecar.event.CarEngineSpeedEvent;
import com.openxc.measurements.EngineSpeed;
import com.openxc.measurements.Measurement;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by matuszewski on 29/07/16.
 */
public class CarEngineSpeedListener implements EngineSpeed.Listener {
    @Override
    public void receive(Measurement measurement) {
        EventBus.getDefault().post(new CarEngineSpeedEvent(measurement));
    }
}
