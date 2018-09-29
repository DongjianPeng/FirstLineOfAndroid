package top.murphypen.studyandroid.activity.view03;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import top.murphypen.studyandroid.activity.R;
import top.murphypen.studyandroid.activity.base.BaseActivity;

public class ImageView1Activity extends BaseActivity {

    ImageView imageView = null;
    ProgressBar progressBar = null;
    Button progressStartBtn = null;
    Button progressStopBtn = null;
    int progress = 0;
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view1);

        addOnClickListener(R.id.switch_image_btn1, R.id.progress_start_btn, R.id.progress_stop_btn);

        TextView textView = findViewById(R.id.image_text_1);
        imageView = findViewById(R.id.image_view_1);

        progressStartBtn = findViewById(R.id.progress_start_btn);
        progressStopBtn = findViewById(R.id.progress_stop_btn);
        progressStopBtn.setEnabled(false);
        progressBar = findViewById(R.id.progress_1);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.switch_image_btn1: {
                imageView.setImageResource(R.drawable.abstract101_fhd);
            }
            break;
            case R.id.progress_start_btn: {
                class StartProgress implements Runnable {
                    private ImageView1Activity activity;
                    private ProgressBar progressBar = null;
                    private Button progressStartBtn = null;
                    private Button progressStopBtn = null;
                    private int progress = 0;

                    public StartProgress(ImageView1Activity activity) {
                        this.activity = activity;
                        this.progressBar = activity.progressBar;
                        this.progressStartBtn = activity.progressStartBtn;
                        this.progressStopBtn = activity.progressStopBtn;
                        this.progress = activity.progress;
                    }

                    @Override
                    public void run() {
                        try {
                            while (progress < progressBar.getMax()) {
                                progress++;
                                progressBar.setProgress(progress);
                                Thread.sleep(5);
                            }
                        } catch (InterruptedException e) {
                            Log.e(TAG, "Stopping progress and init progress.");
                            progress = 0;
                            progressBar.setProgress(progress);
                        }
                    }
                }
                if (executorService.isShutdown()) {
                    executorService = Executors.newSingleThreadExecutor();
                }
                executorService.execute(new StartProgress(ImageView1Activity.this));
                progressStartBtn.setEnabled(false);
                progressStopBtn.setEnabled(true);
            }
            break;
            case R.id.progress_stop_btn: {
                executorService.shutdownNow();
                progressStopBtn.setEnabled(false);
                progressStartBtn.setEnabled(true);
            }
            break;

            default:

        }
    }
}
