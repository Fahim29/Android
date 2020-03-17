package com.example.darkthemetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button switch_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences appSettingsPref = getSharedPreferences("AppSettingPrefs",MODE_PRIVATE);
        final SharedPreferences.Editor sharedPrefEdit = appSettingsPref.edit();
        final Boolean isNightModeOn = appSettingsPref.getBoolean("NightMode",false);
        switch_btn = findViewById(R.id.switch_btn);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View decor = getWindow().getDecorView();
            if (!isNightModeOn) {
                decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            } else {
                // We want to change tint color to white again.
                // You can also record the flags in advance so that you can turn UI back completely if
                // you have set other flags before, such as translucent or full screen.
                decor.setSystemUiVisibility(0);
            }
        }


        if(isNightModeOn){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            switch_btn.setText("Disable Dark Theme");
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            switch_btn.setText("Enable Dark Theme");
        }


        switch_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNightModeOn){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    sharedPrefEdit.putBoolean("NightMode",false);
                    sharedPrefEdit.apply();
                    switch_btn.setText("Enable Dark Theme");
                }else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    sharedPrefEdit.putBoolean("NightMode",true);
                    sharedPrefEdit.apply();
                    switch_btn.setText("Disable Dark Theme");
                }
            }
        });
    }
}
