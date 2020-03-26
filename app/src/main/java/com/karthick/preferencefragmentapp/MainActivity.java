package com.karthick.preferencefragmentapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int splashScreenTimeout = 1000;
    TextView welcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeText = findViewById(R.id.welcome_text);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String username = sharedPreferences.getString("edit_pref", "");

        if (username != null) {
            welcomeText.setText("Welcome " + username);
        }


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);

                //WILL STOP GOING BACK TO WELCOME SCREEN, WHEN BACK BUTTON IS PRESSED
                finish();
            }
        }, splashScreenTimeout);
    }
}
