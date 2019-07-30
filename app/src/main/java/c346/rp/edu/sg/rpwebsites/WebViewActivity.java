package c346.rp.edu.sg.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());

        Intent getIntent = getIntent();

        String url = getIntent.getStringExtra("URL");

        webView.loadUrl(url);

        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(false);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
