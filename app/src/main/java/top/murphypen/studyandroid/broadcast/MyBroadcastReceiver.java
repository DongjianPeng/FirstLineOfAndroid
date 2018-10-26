/*
 * ***************************************
 * Copyright (C) 2018. MurphyPen All rights reserved.
 * web site:www.murphypen.top
 * mail:pengdongjian@gmail.com
 * ***************************************
 */

package top.murphypen.studyandroid.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import top.murphypen.studyandroid.util.ToastUtil;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        ToastUtil.show(context, "Received in MyBroadcastReceiver.msg:" + msg);

        //截断广播传递
        abortBroadcast();
    }
}
