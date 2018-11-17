package top.murphypen.studyandroid.activity.view03;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import top.murphypen.studyandroid.activity.R;
import top.murphypen.studyandroid.activity.base.BaseActivity;
import top.murphypen.studyandroid.activity.base.value.OpenViewValue;
import top.murphypen.studyandroid.util.ToastUtil;

public class WidgetViewActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_view);

        addOnClickListenerForOpenView(new OpenViewValue(R.id.show_image1_btn, ImageView1Activity.class)

        );
        addOnClickListener(R.id.show_alert_btn,
                R.id.show_progress_dialog_btn,
                R.id.show_progress_dialog2_btn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.show_alert_btn: {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                alertDialog.setTitle("Title");
                alertDialog.setMessage("Message ...");

                alertDialog.setPositiveButton("OOKK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.show(WidgetViewActivity.this, "Click Positive");
                    }
                });

                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.show(WidgetViewActivity.this, "Click Negative");
                    }
                });

                alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        ToastUtil.show(WidgetViewActivity.this, "Cancel");
                    }
                });
                alertDialog.show();
            }
            break;

            case R.id.show_progress_dialog_btn: {
                ProgressDialog progressDialog = new ProgressDialog(WidgetViewActivity.this);
                progressDialog.setTitle("Title");
                progressDialog.setMessage("message...");
                progressDialog.setCancelable(true);
                progressDialog.show();
            }
            break;

            case R.id.show_progress_dialog2_btn: {

            }
            break;

            default:

        }
    }
}
