/*
 * ***************************************
 * Copyright (C) 2018. MurphyPen All rights reserved.
 * web site:www.murphypen.top
 * mail:pengdongjian@gmail.com
 * ***************************************
 */

package top.murphypen.studyandroid.broadcast;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import java.io.Serializable;

import top.murphypen.studyandroid.activity.view03.WidgetViewActivity;
import top.murphypen.studyandroid.util.ToastUtil;
import top.murphypen.studyandroid.value.broadcast.local.FroceOfflineValue;

public class LocalBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Serializable data = intent.getSerializableExtra("data");
        if (data != null) {

            if (data instanceof FroceOfflineValue) {
                forceOffline(context, intent, (FroceOfflineValue) data);
            }
        }
    }

    private void forceOffline(final Context context, Intent intent, FroceOfflineValue value) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle("Title");
        alertDialog.setMessage("Message ...");

        alertDialog.setPositiveButton("OOKK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {

            }
        });
        alertDialog.show();

//        new AlertDialog.Builder(context)
//                .setCancelable(false)
//                .setTitle("Info")
//                .setMessage(value.getMsg())
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        ToastUtil.show(context, "Click OK..");
//                    }
//                })
//                .show();
    }
}
