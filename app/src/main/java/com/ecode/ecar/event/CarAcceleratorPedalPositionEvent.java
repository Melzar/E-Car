package com.ecode.ecar.event;

import com.openxc.measurements.Measurement;

/**
 * Created by matuszewski on 01/08/16.
 */
public class CarAcceleratorPedalPositionEvent extends BaseCarActionEvent {

    public CarAcceleratorPedalPositionEvent(Measurement measurement) {
        super(measurement);
    }
}
