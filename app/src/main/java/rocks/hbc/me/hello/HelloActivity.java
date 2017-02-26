package rocks.hbc.me.hello;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class HelloActivity extends AppCompatActivity {
    private View mView;
    private boolean inFullscreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hello);

        mView = findViewById(R.id.fullscreen_content_controls);

        enterFullScreen();

        findViewById(R.id.hello).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inFullscreen) {
                    exitFullScreen();
                } else {
                    enterFullScreen();
                }
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    private void enterFullScreen() {
        mView.setSystemUiVisibility(
               View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION  // hide nav bar
                | View.SYSTEM_UI_FLAG_FULLSCREEN  // hide status bar
                | View.SYSTEM_UI_FLAG_IMMERSIVE);
        inFullscreen = true;
    }

    private void exitFullScreen() {
        mView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        inFullscreen = false;
    }
}
