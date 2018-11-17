package top.murphypen.studyandroid.activity.view03;

import android.os.Bundle;

import top.murphypen.studyandroid.activity.R;
import top.murphypen.studyandroid.activity.base.BaseActivity;
import top.murphypen.studyandroid.activity.base.value.OpenViewValue;

public class LayoutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        addOnClickListenerForOpenView(
                new OpenViewValue(R.id.show_linear_layout_btn, LinearLayoutDemo.class),
                new OpenViewValue(R.id.show_relative_btn, RelativeDemoActivity.class),
                new OpenViewValue(R.id.show_frame_btn, FrameDemoActivity.class),
                new OpenViewValue(R.id.show_percent_frame_btn, PercentFrameActivity.class),
                new OpenViewValue(R.id.show_include_layout_btn, IncludeActivity.class)
        );
    }
}
