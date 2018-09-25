package top.murphypen.studyandroid.activity.view01;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import top.murphypen.studyandroid.activity.R;
import top.murphypen.studyandroid.activity.base.BaseActivity;

public class SIntent extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view01);
        addOnClickListener(R.id.sient_btn, R.id.open_website_btn, R.id.opem_call_btn, R.id.extra_btn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sient_btn: {
                Intent intent = new Intent("android.intent.action.SHidIntent");
                startActivity(intent);
            }
            break;
            case R.id.open_website_btn: {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.bing.com"));
                startActivity(intent);
            }
            break;

            case R.id.open_my_website_btn: {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.setData(Uri.parse("http://www.bing.com"));
                startActivity(intent);

            }
            break;
            case R.id.opem_call_btn: {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10010"));
                startActivity(intent);
            }
            break;

            case R.id.extra_btn: {
                Intent intent = new Intent(this, MyWebSite.class);
                intent.putExtra("content", "Hahahahahaha");
                startActivityForResult(intent, 1);
            }
            break;


            default:
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 1: {
                if (resultCode == RESULT_OK) {
                    String result = data.getStringExtra("result");
                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                }
            }
            break;

            default:

        }
    }
}
