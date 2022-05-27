package com.browserstack.webview;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		WebView.setWebContentsDebuggingEnabled(true);
		WebView webview = (WebView) findViewById(R.id.webview);

		webview.setWebViewClient(new WebViewClient());
		webview.loadUrl("https://browserstack.com");

	}
} 