package com.ecode.ecar.event;

import com.openxc.measurements.Measurement;

/**
 * Created by matuszewski on 01/08/16.
 */
public class CarHighBeamStatusEvent extends BaseCarActionEvent {

    public CarHighBeamStatusEvent(Measurement measurement) {
        super(measurement);
    }
}
