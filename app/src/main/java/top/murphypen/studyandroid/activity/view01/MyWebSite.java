package top.murphypen.studyandroid.activity.view01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import top.murphypen.studyandroid.activity.R;
import top.murphypen.studyandroid.activity.base.BaseActivity;

public class MyWebSite extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_web_site);

        String content = getIntent().getStringExtra("content");
        Intent resultIntent = new Intent();
        resultIntent.putExtra("result", "Result string...");
        setResult(RESULT_OK, resultIntent);
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }
}
