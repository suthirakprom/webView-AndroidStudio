package com.example.webview

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*
import android.webkit.WebChromeClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(webView!=null)
        {
            val webViewSetting = webView.settings
            webViewSetting.javaScriptEnabled = true
            webView.webViewClient = WebViewClient()
            webView.webChromeClient= WebChromeClient()
            webView.loadUrl("https://www.google.com")
            webView.webViewClient = object : WebViewClient(){
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    progressBar3.visibility = View.VISIBLE
                    super.onPageStarted(view, url, favicon)
                }
                override fun onPageFinished(view: WebView?, url: String?) {
                    progressBar3.visibility = View.GONE
                    super.onPageFinished(view, url)
                }
            }
        }
    }
    override fun onBackPressed() {
        if(webView.canGoBack())
            webView.goBack()
        else
            super.onBackPressed()
    }
}
