package com.ecode.ecar.event;

import com.openxc.measurements.Measurement;

/**
 * Created by matuszewski on 31/07/16.
 */
public class CarSpeedEvent extends BaseCarActionEvent {

    public CarSpeedEvent(Measurement measurement) {
        super(measurement);
    }
}
