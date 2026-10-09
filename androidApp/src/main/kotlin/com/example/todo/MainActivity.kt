package com.example.todo

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.OnApplyWindowInsetsListener
import androidx.core.view.ViewCompat
import androidx.core.view.ViewGroupCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()

        super.onCreate(savedInstanceState)

        setContent {
            App()
        }
    }

    private fun applyWindowInset(){
        val contentView = findViewById<ViewGroup>(android.R.id.content).getChildAt(0) ?: return
        ViewCompat.setOnApplyWindowInsetsListener(contentView
        ) { view, insets ->
            val systemBarInset = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(
                /*left = */systemBarInset.left,
               /* top =*/ systemBarInset.top,
               /* right = */systemBarInset.right,
              /*  bottom =*/ 0,
            )

            insets
        }

        ViewCompat.requestApplyInsets(contentView)
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}