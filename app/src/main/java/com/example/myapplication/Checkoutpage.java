package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Checkoutpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_checkoutpage);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnCheckout = findViewById(R.id.BtnCheckout);
        btnCheckout.setOnClickListener(v -> {
            Intent intent = new Intent(Checkoutpage.this, OrderSuccesfulPage.class);
            startActivity(intent);
        });

        ImageButton btnBack = findViewById(R.id.Btnback);
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(Checkoutpage.this, DetailItem.class);
            startActivity(intent);
        });

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int price = intent.getIntExtra("price", 0);
        int image = intent.getIntExtra("image", 0);

        TextView cartName = findViewById(R.id.cartText);
        TextView cartPrice = findViewById(R.id.cartPrice);
        ImageView cartImage = findViewById(R.id.cartImage);

        cartName.setText(name);
        cartPrice.setText(String.valueOf(price));
        cartImage.setImageResource(image);
    }
}