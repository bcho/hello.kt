package rocks.hbc.me.hello

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        var query = getIntent().getStringExtra("CLICK_TIMES")
        var url = "http://wb.hbc.rocks/fibNext?number=$query"

        var mBrowser = findViewById(R.id.info_webview) as WebView
        mBrowser.loadUrl(url)
        mBrowser.getSettings().setJavaScriptEnabled(true)
        mBrowser.setWebViewClient(WebViewClient())
    }
}
