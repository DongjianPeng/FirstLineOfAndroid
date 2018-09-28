package top.murphypen.studyandroid.activity.View03;

import android.os.Bundle;

import top.murphypen.studyandroid.activity.R;
import top.murphypen.studyandroid.activity.base.BaseActivity;
import top.murphypen.studyandroid.activity.base.value.OpenViewValue;

public class WidgetViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_view);
        addOnClickListenerForOpenView(new OpenViewValue(R.id.show_widget_btn, WidgetViewActivity.class));
    }
}
