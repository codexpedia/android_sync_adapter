package com.codexpedia.syncadapter.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyServiceSync extends Service {
    private static final Object sSyncAdapterLock = new Object();
    private static MyServiceSyncAdapter myServiceSyncAdapter = null;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyServiceSync", "onCreate");
        synchronized (sSyncAdapterLock) {
            if (myServiceSyncAdapter == null) {
                myServiceSyncAdapter = new MyServiceSyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("MyServiceSync", "onBind");
        return myServiceSyncAdapter.getSyncAdapterBinder();
    }
}
