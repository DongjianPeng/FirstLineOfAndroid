package top.murphypen.studyandroid.activity.boot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import top.murphypen.studyandroid.activity.R;
import top.murphypen.studyandroid.activity.base.BaseActivity;
import top.murphypen.studyandroid.activity.base.value.OpenViewValue;
import top.murphypen.studyandroid.activity.view01.SIntent;
import top.murphypen.studyandroid.activity.view02.ActivityLife;
import top.murphypen.studyandroid.activity.view03.LayoutActivity;
import top.murphypen.studyandroid.activity.view03.RecyclerViewActivity;
import top.murphypen.studyandroid.activity.view03.WidgetViewActivity;
import top.murphypen.studyandroid.activity.view03.listview.ListViewActivity;
import top.murphypen.studyandroid.broadcast.MyLocalBroadcastReceiver;
import top.murphypen.studyandroid.util.ToastUtil;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    NetWorkChange netWorkChange;

    private LocalBroadcastManager localBroadcastManager;
    private MyLocalBroadcastReceiver myLocalBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle(R.string.app_name);

        addOnClickListener(R.id.main_btn_1);
        addOnClickListenerForOpenView(new OpenViewValue(R.id.show_activity_life_btn, ActivityLife.class),
                new OpenViewValue(R.id.show_widget_btn, WidgetViewActivity.class),
                new OpenViewValue(R.id.show_layout_btn, LayoutActivity.class),
                new OpenViewValue(R.id.show_listview_btn, ListViewActivity.class),
                new OpenViewValue(R.id.show_recycler_btn, RecyclerViewActivity.class)
        );
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        netWorkChange = new NetWorkChange();
        registerReceiver(netWorkChange, intentFilter);

        //注册本地广播
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        String myBroadcastAction = Thread.currentThread().getName();
        localBroadcastManager.registerReceiver(new MyLocalBroadcastReceiver(), new IntentFilter(myBroadcastAction));
        Intent myBroadcastIntent = new Intent(myBroadcastAction);
        myBroadcastIntent.putExtra("msg", myBroadcastAction);
        //发送本地广播
        localBroadcastManager.sendBroadcast(myBroadcastIntent);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (netWorkChange != null) {
            unregisterReceiver(netWorkChange);
        }
        if (myLocalBroadcastReceiver != null) {
            localBroadcastManager.unregisterReceiver(myLocalBroadcastReceiver);
        }
    }

    class NetWorkChange extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                ToastUtil.show(context, "Connected");
            } else {
                ToastUtil.show(context, "Not connected");
            }
        }
    }
}
