package com.ecode.ecar.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ecode.ecar.R;

/**
 * Created by matuszewski on 27/07/16.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle bundle){
        super.onCreate(bundle);
    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onStop(){
        super.onStop();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    /*
     TODO It will have to be changed for applying multiple layouts for application,
     but as basic blueprint leave it now as it is
      */
    protected void setActivityContentView(int contentViewID){
        setContentView(R.layout.activity_main);
    }
}
