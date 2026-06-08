package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Branches extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_branches);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton homeBtn = findViewById(R.id.HomeBtn);
        homeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Branches.this, HomeActivity.class);
            startActivity(intent);
        });

        ImageButton browseBtn = findViewById(R.id.BrowseBtn);
        browseBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Branches.this, Item.class);
            startActivity(intent);
        });
    }
}