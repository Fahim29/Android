package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.rv_numbers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String[] title = {"C","Java","C++","Python","Perl","Ruby","R","php","Javascript","C#","C","Java","C++","Python","Perl","Ruby","R","php","Javascript","C#"};

        recyclerView.setAdapter(new CustomAdapter(title));

    }
}
