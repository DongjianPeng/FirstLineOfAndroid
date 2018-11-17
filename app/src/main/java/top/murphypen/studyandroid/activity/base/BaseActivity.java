package top.murphypen.studyandroid.activity.base;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import top.murphypen.studyandroid.activity.base.value.OpenViewValue;
import top.murphypen.studyandroid.broadcast.LocalBroadcastReceiver;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    protected String TAG = getClass().getSimpleName();
    private boolean lifeLogger;

    private LocalBroadcastManager localBroadcastManager;
    private LocalBroadcastReceiver localBroadcastReceiver;
    private IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>[" + TAG + "]:onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        if (lifeLogger) {
            Log.d(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>[" + TAG + "]:onStart");
        }
        super.onStart();
    }

    @Override
    protected void onResume() {
        if (lifeLogger) {
            Log.d(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>[" + TAG + "]:onResume");
        }
        super.onResume();
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        intentFilter = new IntentFilter("com.murphy.broadcast.local");
        localBroadcastReceiver = new LocalBroadcastReceiver();
//        localBroadcastManager.registerReceiver(localBroadcastReceiver, intentFilter);
        registerReceiver(localBroadcastReceiver,intentFilter);
    }


    @Override
    protected void onPause() {
        if (lifeLogger) {
            Log.d(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>[" + TAG + "]:onPause");
        }
        super.onPause();
        if (localBroadcastManager != null && localBroadcastReceiver != null) {
            localBroadcastManager.unregisterReceiver(localBroadcastReceiver);
        }
        unregisterReceiver(localBroadcastReceiver);
    }

    @Override
    protected void onStop() {
        if (lifeLogger) {
            Log.d(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>[" + TAG + "]:onStop");
        }
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        if (lifeLogger) {
            Log.d(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>[" + TAG + "]:onDestroy");
        }
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        if (lifeLogger) {
            Log.d(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>[" + TAG + "]:onRestart");
        }
        super.onRestart();
    }

    protected void addOnClickListener(int... ids) {
        for (int id : ids) {
            findViewById(id).setOnClickListener(this);
        }
    }

    protected void addOnClickListenerForOpenView(OpenViewValue... values) {
        for (final OpenViewValue value : values)
            findViewById(value.getId()).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(BaseActivity.this, value.getClasz());
                    startActivity(intent);
                }
            });
    }

    protected void showLifeLogger() {
        this.lifeLogger = true;
    }

    @Override
    public void onClick(View v) {

    }
}
