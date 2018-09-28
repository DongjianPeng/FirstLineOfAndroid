package top.murphypen.studyandroid.activity.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import top.murphypen.studyandroid.activity.base.value.OpenViewValue;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    protected String TAG = getClass().getSimpleName();
    private boolean lifeLogger;

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
    }

    @Override
    protected void onPause() {
        if (lifeLogger) {
            Log.d(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>[" + TAG + "]:onPause");
        }
        super.onPause();
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
