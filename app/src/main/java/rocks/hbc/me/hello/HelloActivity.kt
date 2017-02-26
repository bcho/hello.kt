package rocks.hbc.me.hello

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast

class HelloActivity : AppCompatActivity() {
    private var mView: View? = null
    private var inFullscreen: Boolean = false
    private var clickTimes: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_hello)

        mView = findViewById(R.id.fullscreen_content_controls)

        enterFullScreen()

        findViewById(R.id.hello).setOnClickListener {
            clickTimes = clickTimes + 1

            if (clickTimes % 5 == 0) {
                var intent = Intent(this, InfoActivity::class.java)
                intent.putExtra("CLICK_TIMES", "$clickTimes")
                startActivity(intent);
            } else if (inFullscreen) {
                exitFullScreen()
            } else {
                enterFullScreen()
            }
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
    }

    private fun enterFullScreen() {
        mView!!.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                .or(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)
                .or(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
                .or(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)  // hide nav bar
                .or(View.SYSTEM_UI_FLAG_FULLSCREEN)  // hide status bar
                .or(View.SYSTEM_UI_FLAG_IMMERSIVE)
        inFullscreen = true

        sendToast("full screen mode...")
    }

    private fun exitFullScreen() {
        mView!!.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                .or(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)
                .or(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        inFullscreen = false

        sendToast("normal mode...")
    }

    private fun sendToast(text: String) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT)
                .show();
    }
}
