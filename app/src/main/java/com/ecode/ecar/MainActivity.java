package com.ecode.ecar;

import android.os.Bundle;

import com.ecode.ecar.activity.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActivityContentView(R.layout.activity_main);
    }
}
