package com.example.todomovies.ui.splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.todomovies.MainActivity;
import com.example.todomovies.R;

public class SplashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent splashIntent = new Intent(this, MainActivity.class);
            startActivity(splashIntent);
            finish();
    }
}
