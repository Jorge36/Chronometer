package com.example.Chronometer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchAct extends AppCompatActivity {

    private Button btnStart, btnStop;
    private ImageView icanchor;
    private Animation roundingAlone;
    private Chronometer timerHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        icanchor = findViewById(R.id.icanchor);
        timerHere = findViewById(R.id.timerHere);

        // create optional animation
        btnStop.setAlpha(0);

        // load animations
        roundingAlone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);

        // import font
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");

        btnStart.setTypeface(MMedium);
        btnStop.setTypeface(MMedium);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // passing animation
                icanchor.startAnimation(roundingAlone);
                btnStart.animate().alpha(0).start();
                btnStop.animate().alpha(1).translationY(-150).start();
                // start time
                timerHere.setBase(SystemClock.elapsedRealtime());
                timerHere.start();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icanchor.clearAnimation();
                btnStop.animate().alpha(0).translationY(150).start();
                btnStart.animate().alpha(1).start();
                timerHere.setBase(SystemClock.elapsedRealtime());
                timerHere.stop();
            }
        });

    }
}
