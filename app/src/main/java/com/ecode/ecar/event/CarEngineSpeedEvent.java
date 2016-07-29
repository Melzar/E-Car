package com.ecode.ecar.event;

import com.openxc.measurements.EngineSpeed;
import com.openxc.measurements.Measurement;

/**
 * Created by matuszewski on 29/07/16.
 */
public class CarEngineSpeedEvent extends BaseCarActionEvent {

    public CarEngineSpeedEvent(Measurement measurement) {
        super(measurement);
    }

}
