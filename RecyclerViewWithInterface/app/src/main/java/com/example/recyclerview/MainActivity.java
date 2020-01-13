package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CustomAdapter.OnItemListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.rv_numbers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String[] title = {"C","Java","C++","Python","Perl","Ruby","R","php","Javascript","C#"};
        int[] images = {R.drawable.c,
                R.drawable.java,
                R.drawable.cplusplus,
                R.drawable.python,
                R.drawable.perl,
                R.drawable.ruby,
                R.drawable.r,
                R.drawable.php,
                R.drawable.javascript,
                R.drawable.csharp};

        recyclerView.setAdapter(new CustomAdapter(title,images));

    }

    @Override
    public void onItemClick(int position) {
        Intent intent=new Intent(MainActivity.this, Main2Activity.class);
        Bundle bundle=new Bundle();
        bundle.putInt("image",position);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
