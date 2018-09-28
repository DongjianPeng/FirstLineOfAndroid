package top.murphypen.studyandroid.activity.view02;

import android.os.Bundle;

import top.murphypen.studyandroid.activity.R;
import top.murphypen.studyandroid.activity.base.BaseActivity;
import top.murphypen.studyandroid.activity.base.value.OpenViewValue;
import top.murphypen.studyandroid.util.ToastUtil;

public class ActivityLife extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        showLifeLogger();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);

        if (savedInstanceState != null) {
            String value = savedInstanceState.getString("save");
            ToastUtil.show(this, value);
        }


//        addOnClickListener(R.id.start_normal_btn,R.id.start_dialog_btn);
        addOnClickListenerForOpenView(
                new OpenViewValue(R.id.start_self_btn, ActivityLife.class),
                new OpenViewValue(R.id.start_normal_btn, NormalActivity.class),
                new OpenViewValue(R.id.start_dialog_btn, DialogActivity.class));
    }


    /**
     * 在活动被系统回收时一定会调用的方法，在Bundle中保存数据，重新进入活动时用savedInstanceState恢复数据
     *
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("save", "Value....");
    }
}
