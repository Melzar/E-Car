package com.ecode.ecar.event;

import com.openxc.measurements.Measurement;

/**
 * Created by matuszewski on 01/08/16.
 */
public class CarHeadlampStatusEvent extends BaseCarActionEvent {

    public CarHeadlampStatusEvent(Measurement measurement) {
        super(measurement);
    }
}
