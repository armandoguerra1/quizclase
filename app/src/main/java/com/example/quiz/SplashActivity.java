package com.example.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spladh);

        new Handler().postDelayed(() -> {
            SharedPreferences prefs = getSharedPreferences("quiz", MODE_PRIVATE);
            String categoria = prefs.getString("categoria", "");

            Intent intent;
            switch (categoria) {
                case "Deportes":
                    intent = new Intent(SplashActivity.this, DeportesActivity.class);
                    break;
                case "Música":
                    intent = new Intent(SplashActivity.this, MusicaActivity.class);
                    break;
                case "Cine":
                    intent = new Intent(SplashActivity.this, CineActivity.class);
                    break;
                default:
                    intent = new Intent(SplashActivity.this, MainActivity.class);
                    break;
            }

            startActivity(intent);
            finish();
        }, SPLASH_DELAY);
    }
}