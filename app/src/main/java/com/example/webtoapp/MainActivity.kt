package com.example.webtoapp

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.webtoapp.ui.theme.WebToAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WebToAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WebScreen()
                }
            }
        }
    }
}

@Composable
fun WebScreen() {
    AndroidView(
        factory = {
            context->
            return@AndroidView WebView(context).apply {
                settings.javaScriptEnabled=true
                webViewClient= WebViewClient()
            }
        },
        update = {
            it.loadUrl("https://cms.must.edu.pk:8082/login.aspx")
        }
    )
}


