package com.ecode.ecar;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.widget.TextView;

import com.ecode.ecar.activity.BaseActivity;
import com.ecode.ecar.event.CarEngineSpeedEvent;
import com.ecode.ecar.model.CarAction;
import com.ecode.ecar.service.CarBluetoothConnectionService;
import com.openxc.measurements.EngineSpeed;

import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    private CarAction carAction;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setActivityContentView(R.layout.activity_main);
        carAction = new CarAction(0.00);
        ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setVariable(BR.car_action, carAction);
        binding.executePendingBindings();
    }

    @Subscribe
    public void onEvent(final CarEngineSpeedEvent event) {
        carAction.setSpeed(((EngineSpeed)event.getMeasurement()).getValue().doubleValue());
    }
}
