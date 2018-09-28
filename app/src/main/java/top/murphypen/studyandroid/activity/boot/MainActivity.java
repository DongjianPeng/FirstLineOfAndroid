package top.murphypen.studyandroid.activity.boot;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import top.murphypen.studyandroid.activity.R;
import top.murphypen.studyandroid.activity.view02.ActivityLife;
import top.murphypen.studyandroid.activity.base.BaseActivity;
import top.murphypen.studyandroid.activity.base.value.OpenViewValue;
import top.murphypen.studyandroid.activity.view01.SIntent;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        addOnClickListener(R.id.main_btn_1);
        addOnClickListenerForOpenView(new OpenViewValue(R.id.show_activity_life_btn, ActivityLife.class));
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "Click :" + v.getId(), Toast.LENGTH_SHORT).show();
        switch (v.getId()) {
            case R.id.main_btn_1: {
                Intent intent = new Intent(MainActivity.this, SIntent.class);
                startActivity(intent);
            }
            break;
            default:
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_menu_btn_1:
                break;


            case R.id.main_menu_btn_exit:
                finish();
                break;
            default:
        }
        return true;
    }
}
