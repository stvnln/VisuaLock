package com.example.visualock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText loginEmail;
    private TextView registerRedirectText;
    private TextView forgot_passRedirectText;
    private FirebaseFirestore firestore;
    private Button loginButton;

    private Button password_redirect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Check if the user is already authenticated
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            // User is already signed in, redirect to MainActivity
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish(); // Finish LoginActivity so that the user cannot navigate back to it
        }

        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        loginEmail = findViewById(R.id.login_email);
        //loginPassword = findViewById(R.id.login_password);
        //loginButton = findViewById(R.id.login_button);
        registerRedirectText = findViewById(R.id.registerRedirectText);
        forgot_passRedirectText = findViewById(R.id.forgot_passRedirectText);
        password_redirect = findViewById(R.id.password_button);


        registerRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        forgot_passRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
            }
        });
        password_redirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(LoginActivity.this, PasswordActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("email", loginEmail.getText().toString());
                bundle.putString("from_activity", "login");
                startActivity(loginIntent.putExtras(bundle));

            }
        });
    }



}
