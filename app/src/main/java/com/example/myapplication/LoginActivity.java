package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private AppCompatButton btnLogin;
    private TextView tvSignUpLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initializing views
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvSignUpLink = findViewById(R.id.tvSignUpLink);

        // Setup the interactive Sign Up link text
        setupSignUpLink();

        // Handle Log In Button Click
        btnLogin.setOnClickListener(v -> {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Perform your auth logic here
                    Toast.makeText(LoginActivity.this, "Logging in...", Toast.LENGTH_SHORT).show();

                    // ==========================================
                    // ADDED CODE: Navigate to Home Activity
                    // ==========================================
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.putExtra("USER_NAME", username); // Passes your 'username' variable
                    startActivity(intent);

                    finish(); // Optional: Closes LoginActivity so pressing "Back" doesn't return here
                    // ==========================================
                }
        });
    }

    private void setupSignUpLink() {
        String completeText = "Don't have an account? Sign Up";
        SpannableString spannableString = new SpannableString(completeText);

        // Find the index positions of "Sign Up" to apply styles specifically to it
        int startIndex = completeText.indexOf("Sign Up");
        int endIndex = completeText.length();

        // Underline "Sign Up"
        spannableString.setSpan(new UnderlineSpan(), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Make "Sign Up" clickable
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(LoginActivity.this, "Navigate to Sign Up Screen", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        };

        spannableString.setSpan(clickableSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tvSignUpLink.setText(spannableString);
        // Allows the framework to handle link clicking safely
        tvSignUpLink.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
        tvSignUpLink.setHighlightColor(Color.TRANSPARENT);
    }
}