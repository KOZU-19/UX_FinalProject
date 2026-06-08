package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class DetailItem extends AppCompatActivity {

    private String sizeSelected = "Normal";
    private String iceSelected = "Normal Ice";
    private String sugarSelected = "Normal Sugar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_item);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView imageProduct = findViewById(R.id.ProdImg);
        TextView productName = findViewById(R.id.ProdName);
        TextView productPrice = findViewById(R.id.ProdHarga);
        Button btnCart = findViewById(R.id.BtnCart);

        CardView sizeContainer = findViewById(R.id.SizeContainer);
        CardView iceContainer = findViewById(R.id.IceContainer);
        CardView sugarContainer = findViewById(R.id.SugarContainer);

        CardView sizeSmall = findViewById(R.id.SizeSmall);
        CardView sizeMedium = findViewById(R.id.SizeMedium);
        CardView sizeLarge = findViewById(R.id.SizeLarge);
        
        CardView iceNo = findViewById(R.id.IceNo);
        CardView iceLess = findViewById(R.id.IceLess);
        CardView iceNormal = findViewById(R.id.IceNormal);

        CardView sugarNo = findViewById(R.id.SugarNo);
        CardView sugarLess = findViewById(R.id.SugarLess);
        CardView sugarNormal = findViewById(R.id.SugarNormal);

        Intent intent = getIntent();
        String product = intent.getStringExtra("product");
        String harga = intent.getStringExtra("Harga");
        int gambarResId = intent.getIntExtra("Gambar", R.drawable.image_23);
        String type = intent.getStringExtra("Type");

        imageProduct.setImageResource(gambarResId);
        productName.setText(product);
        productPrice.setText(harga);

        if (Objects.equals(type, "Drink")) {
            sizeContainer.setVisibility(View.VISIBLE);
            sugarContainer.setVisibility(View.VISIBLE);
            iceContainer.setVisibility(View.VISIBLE);
        } else {
            sizeContainer.setVisibility(View.GONE);
            sugarContainer.setVisibility(View.GONE);
            iceContainer.setVisibility(View.GONE);
        }

        // Selection Logic
        sizeSmall.setOnClickListener(v -> {
            sizeSelected = "Small";
            updateSelection(sizeSmall, sizeMedium, sizeLarge);
        });
        sizeMedium.setOnClickListener(v -> {
            sizeSelected = "Medium";
            updateSelection(sizeMedium, sizeSmall, sizeLarge);
        });
        sizeLarge.setOnClickListener(v -> {
            sizeSelected = "Large";
            updateSelection(sizeLarge, sizeSmall, sizeMedium);
        });

        iceNo.setOnClickListener(v -> {
            iceSelected = "No Ice";
            updateSelection(iceNo, iceLess, iceNormal);
        });
        iceLess.setOnClickListener(v -> {
            iceSelected = "Less Ice";
            updateSelection(iceLess, iceNo, iceNormal);
        });
        iceNormal.setOnClickListener(v -> {
            iceSelected = "Normal Ice";
            updateSelection(iceNormal, iceNo, iceLess);
        });

        sugarNo.setOnClickListener(v -> {
            sugarSelected = "No Sugar";
            updateSelection(sugarNo, sugarLess, sugarNormal);
        });
        sugarLess.setOnClickListener(v -> {
            sugarSelected = "Less Sugar";
            updateSelection(sugarLess, sugarNo, sugarNormal);
        });
        sugarNormal.setOnClickListener(v -> {
            sugarSelected = "Normal Sugar";
            updateSelection(sugarNormal, sugarNo, sugarLess);
        });

        btnCart.setOnClickListener(v -> {
            // Add to CartStorage
            CartStorage.names.add(product);
            // Parse price from string if needed, or just store it. 
            // The original code used ints, but extras were strings.
            // Let's stick to what's expected in Checkoutpage.
            
            Toast.makeText(this, "Added to Cart", Toast.LENGTH_SHORT).show();
            
            Intent checkoutIntent = new Intent(DetailItem.this, Checkoutpage.class);
            checkoutIntent.putExtra("name", product);
            checkoutIntent.putExtra("price", 35000); // Dummy price or parse from 'harga'
            checkoutIntent.putExtra("image", gambarResId);
            checkoutIntent.putExtra("size", sizeSelected);
            checkoutIntent.putExtra("sugar", sugarSelected);
            checkoutIntent.putExtra("ice", iceSelected);
            startActivity(checkoutIntent);
        });
    }

    private void updateSelection(CardView selected, CardView... others) {
        selected.setCardBackgroundColor(Color.parseColor("#808080"));
        for (CardView other : others) {
            other.setCardBackgroundColor(Color.WHITE);
        }
    }
}