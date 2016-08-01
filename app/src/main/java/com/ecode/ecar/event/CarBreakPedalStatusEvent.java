package com.ecode.ecar.event;

import com.openxc.measurements.Measurement;

/**
 * Created by matuszewski on 01/08/16.
 */
public class CarBreakPedalStatusEvent extends BaseCarActionEvent {

    public CarBreakPedalStatusEvent(Measurement measurement) {
        super(measurement);
    }
}
