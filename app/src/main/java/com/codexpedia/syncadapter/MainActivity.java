package com.codexpedia.syncadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codexpedia.syncadapter.sync.MyServiceSyncAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyServiceSyncAdapter.initializeSyncAdapter(getApplicationContext());
    }
}
