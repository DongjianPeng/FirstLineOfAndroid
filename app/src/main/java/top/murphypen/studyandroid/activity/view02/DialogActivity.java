package top.murphypen.studyandroid.activity.view02;

import android.os.Bundle;

import top.murphypen.studyandroid.activity.R;
import top.murphypen.studyandroid.activity.base.BaseActivity;

public class DialogActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        showLifeLogger();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }
}
