package com.ecode.ecar.event;

import com.openxc.measurements.Measurement;

/**
 * Created by matuszewski on 01/08/16.
 */
public class CarFuelConsumptionEvent extends BaseCarActionEvent {

    public CarFuelConsumptionEvent(Measurement measurement) {
        super(measurement);
    }
}
