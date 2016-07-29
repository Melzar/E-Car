package com.ecode.ecar.event;

import com.openxc.measurements.Measurement;

/**
 * Created by matuszewski on 29/07/16.
 */
public class BaseCarActionEvent {

    protected Measurement measurement;

    public BaseCarActionEvent(Measurement measurement){
        this.measurement = measurement;
    }

    public Measurement getMeasurement() {
        return measurement;
    }
}
