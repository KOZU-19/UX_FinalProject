package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.myapplication.R;

public class HomeActivity extends AppCompatActivity {

    private TextView tvWelcomeName, tvProfileInitials;
    private RelativeLayout btnBrowseDrinks, btnStoreBranches;
    private AppCompatButton btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // 1. Initialize views using findViewById
        tvWelcomeName = findViewById(R.id.tv_welcome_name);
        tvProfileInitials = findViewById(R.id.tv_profile_initials);
        btnBrowseDrinks = findViewById(R.id.btn_browse_drinks);
        btnStoreBranches = findViewById(R.id.btn_store_branches);
        btnLogout = findViewById(R.id.btn_logout);

        // 2. Get the username from the Intent
        String username = getIntent().getStringExtra("USER_NAME");
        if (username == null || username.isEmpty()) {
            username = "Guest";
        }

        // 3. Set greeting text
        tvWelcomeName.setText("Welcome, " + username + " ✨");

        // 4. Extract initials
        String initials;
        if (username.length() >= 2) {
            initials = username.substring(0, 2).toUpperCase();
        } else {
            initials = username.toUpperCase() + " ";
        }
        tvProfileInitials.setText(initials);

        // 5. Setup Click Listeners
        btnBrowseDrinks.setOnClickListener(v -> Toast.makeText(HomeActivity.this, "Opening Menu...", Toast.LENGTH_SHORT).show());

        btnLogout.setOnClickListener(v -> finish());

        LinearLayout BrowseBtn;
        LinearLayout BranchesBtn;

        BrowseBtn = findViewById(R.id.BrowseBtn);
        BranchesBtn = findViewById(R.id.BranchesBtn);

        BrowseBtn.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this,
                    Item.class);
            startActivity(intent);
        });

        BranchesBtn.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this,
                    Branches.class);
            startActivity(intent);
        });
    }
}