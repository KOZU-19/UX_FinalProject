package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Item extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_item);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton homeBtn = findViewById(R.id.HomeBtn);
        ImageButton browseBtn = findViewById(R.id.BrowseBtn);
        ImageButton branchesBtn = findViewById(R.id.BranchesBtn);
        CardView cardMenu1 = findViewById(R.id.CardMenu1);
        CardView cardMenu2 = findViewById(R.id.Cardmenu2);
        CardView cardMenu3 = findViewById(R.id.CardMenu3);
        CardView cardMenu4 = findViewById(R.id.CardMenu4);

        homeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Item.this, HomeActivity.class);
            startActivity(intent);
        });

        browseBtn.setOnClickListener(v -> {
            // Already on Browse screen or refresh
        });

        branchesBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Item.this, Branches.class);
            startActivity(intent);
        });

        cardMenu1.setOnClickListener(v -> {
            Intent intent = new Intent(Item.this, DetailItem.class);
            intent.putExtra("product", "Matcha Latte");
            intent.putExtra("Harga", "Rp 35.000");
            intent.putExtra("Gambar", R.drawable.image_23);
            intent.putExtra("Type", "Drink");
            startActivity(intent);
        });

        cardMenu2.setOnClickListener(v -> {
            Intent intent = new Intent(Item.this, DetailItem.class);
            intent.putExtra("product", "Ceremonial Matcha");
            intent.putExtra("Harga", "Rp 35.000");
            intent.putExtra("Gambar", R.drawable.image_24__1_);
            intent.putExtra("Type", "Drink");
            startActivity(intent);
        });

        cardMenu3.setOnClickListener(v -> {
            Intent intent = new Intent(Item.this, DetailItem.class);
            intent.putExtra("product", "Matcha Strawberry Cake");
            intent.putExtra("Harga", "Rp 55.000");
            intent.putExtra("Gambar", R.drawable.image_25);
            intent.putExtra("Type", "Food");
            startActivity(intent);
        });

        cardMenu4.setOnClickListener(v -> {
            Intent intent = new Intent(Item.this, DetailItem.class);
            intent.putExtra("product", "Matcha Ice Cream");
            intent.putExtra("Harga", "Rp 22.000");
            intent.putExtra("Gambar", R.drawable.image_26__1_);
            intent.putExtra("Type", "Food");
            startActivity(intent);
        });
    }
}