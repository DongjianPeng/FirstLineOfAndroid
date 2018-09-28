package top.murphypen.studyandroid.activity.view02;

import android.os.Bundle;

import top.murphypen.studyandroid.activity.R;
import top.murphypen.studyandroid.activity.base.BaseActivity;
import top.murphypen.studyandroid.activity.base.value.OpenViewValue;

public class NormalActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        showLifeLogger();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        addOnClickListenerForOpenView(new OpenViewValue(R.id.back_start_activity_life_btn,ActivityLife.class));
    }
}
