package com.ecode.ecar;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.widget.TextView;

import com.ecode.ecar.activity.BaseActivity;
import com.ecode.ecar.common.enumeration.car.CarGearEnumMapper;
import com.ecode.ecar.datasource.bluetooth.CarBreakPedalStatusListener;
import com.ecode.ecar.datasource.bluetooth.CarFuelLevelListener;
import com.ecode.ecar.datasource.bluetooth.CarSpeedListener;
import com.ecode.ecar.event.CarAcceleratorPedalPositionEvent;
import com.ecode.ecar.event.CarBreakPedalStatusEvent;
import com.ecode.ecar.event.CarEngineSpeedEvent;
import com.ecode.ecar.event.CarFuelConsumptionEvent;
import com.ecode.ecar.event.CarFuelLevelEvent;
import com.ecode.ecar.event.CarGearTransmissionEvent;
import com.ecode.ecar.event.CarHeadlampStatusEvent;
import com.ecode.ecar.event.CarHighBeamStatusEvent;
import com.ecode.ecar.event.CarParkingBreakStatusEvent;
import com.ecode.ecar.event.CarSpeedEvent;
import com.ecode.ecar.model.CarAction;
import com.ecode.ecar.service.CarBluetoothConnectionService;
import com.openxc.measurements.AcceleratorPedalPosition;
import com.openxc.measurements.BrakePedalStatus;
import com.openxc.measurements.EngineSpeed;
import com.openxc.measurements.FuelConsumed;
import com.openxc.measurements.FuelLevel;
import com.openxc.measurements.HeadlampStatus;
import com.openxc.measurements.HighBeamStatus;
import com.openxc.measurements.ParkingBrakeStatus;
import com.openxc.measurements.TransmissionGearPosition;
import com.openxc.measurements.VehicleSpeed;

import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    private CarAction carAction;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setActivityContentView(R.layout.activity_main);
        carAction = new CarAction();
        ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setVariable(BR.car_action, carAction);
        binding.executePendingBindings();
    }

    @Subscribe
    public void onEvent(final CarEngineSpeedEvent event) {
        carAction.setEngineSpeed(((EngineSpeed)event.getMeasurement()).getValue().intValue());
    }

    @Subscribe
    public void onEvent(final CarSpeedEvent event) {
        carAction.setCarSpeed(((VehicleSpeed) event.getMeasurement()).getValue().intValue());
    }

    @Subscribe
    public void onEvent(final CarGearTransmissionEvent event) {
        carAction.setGearNumber(
                getString(CarGearEnumMapper.getMappedGearValue(
                        ((TransmissionGearPosition) event.getMeasurement())
                        .getValue().enumValue().ordinal()))
        );
    }

    @Subscribe
    public void onEvent(final CarFuelLevelEvent event) {
        carAction.setFuelLevel(((FuelLevel) event.getMeasurement()).getValue().doubleValue());
    }

    @Subscribe
    public void onEvent(final CarFuelConsumptionEvent event){
        carAction.setFuelConsumption(((FuelConsumed) event.getMeasurement()).getValue()
                .doubleValue());
    }

    @Subscribe
    public void onEvent(final CarBreakPedalStatusEvent event){
        carAction.setBreakPedalEnabled(((BrakePedalStatus) event.getMeasurement()).getValue()
                .booleanValue());
    }

    @Subscribe
    public void onEvent(final CarAcceleratorPedalPositionEvent event){
        carAction.setCarAcceleration(((AcceleratorPedalPosition) event.getMeasurement()).getValue()
                .doubleValue());
    }

    @Subscribe
    public void onEvent(final CarParkingBreakStatusEvent event){
        carAction.setParkingBreakPedalEnabled(((ParkingBrakeStatus) event.getMeasurement())
                .getValue().booleanValue());
    }

    @Subscribe
    public void onEvent(final CarHeadlampStatusEvent event){
        carAction.setHeadlampEnabled(((HeadlampStatus)event.getMeasurement()).getValue()
                .booleanValue());
    }

    @Subscribe
    public void onEvent(final CarHighBeamStatusEvent event){
        carAction.setHighBeamEnabled(((HighBeamStatus)event.getMeasurement()).getValue()
                .booleanValue());
    }

}
