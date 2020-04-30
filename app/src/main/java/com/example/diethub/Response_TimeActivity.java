package com.example.diethub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

public class Response_TimeActivity extends AppCompatActivity {
    RingProgressBar progressBar;
    TextView textCounter;

    MyCountDownTimer myCountDownTimer;
    private long TimeLeftInMillis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response__time);
        getWindow().getDecorView().setSystemUiVisibility
                (View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR |
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        progressBar = findViewById(R.id.progressbar);
        textCounter = findViewById(R.id.counter);

        myCountDownTimer = new MyCountDownTimer(300000, 1000);
        myCountDownTimer.start();
    }

    public class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            TimeLeftInMillis = millisUntilFinished;
            int progress = (int) (millisUntilFinished / 100);
            progressBar.setProgress(progress);
            updateCountDownText();
        }

        @Override
        public void onFinish() {
            textCounter.setText("00:00");
            progressBar.setProgress(0);
            myCountDownTimer.cancel();
        }

    }

    private void updateCountDownText() {
        int minutes = (int) (TimeLeftInMillis / 1000) / 60;
        int seconds = (int) (TimeLeftInMillis / 1000) % 60;


        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        //        String newtime = hours + ":" + minutes + ":" + seconds;

        textCounter.setText(timeLeftFormatted);

    }
}