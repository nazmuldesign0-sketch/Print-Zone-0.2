package com.printzone.calculator;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

/** Shows the Print Zone splash image for 3 seconds, then opens the calculator. */
public class SplashActivity extends Activity {
    private static final long SPLASH_MS = 3000;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable go = new Runnable() {
        @Override public void run() {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout root = new FrameLayout(this);
        root.setBackgroundColor(Color.parseColor("#71BF44"));
        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.splash);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        root.addView(iv, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        setContentView(root);
        handler.postDelayed(go, SPLASH_MS);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(go);
        super.onDestroy();
    }
}
