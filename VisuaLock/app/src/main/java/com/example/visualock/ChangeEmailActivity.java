package com.example.visualock;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;





public class ChangeEmailActivity extends AppCompatActivity {

    private EditText currentEmailField, newEmail;
    private Button changeEmailButton;
    private FirebaseAuth auth;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_email);

        currentEmailField = findViewById(R.id.current_email);
        newEmail = findViewById(R.id.new_email);
        changeEmailButton = findViewById(R.id.send_confirm_button);


        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        changeEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v ){
                String currentEmail = currentEmailField.getText().toString().trim();
                String newEmailText = newEmail.getText().toString().trim();

                if (TextUtils.isEmpty(currentEmail) || TextUtils.isEmpty(newEmailText)) {
                    Toast.makeText(ChangeEmailActivity.this, "Both email fields are required", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (currentEmail.equals(newEmailText)) {
                    Toast.makeText(ChangeEmailActivity.this, "New email should be different from the current one", Toast.LENGTH_SHORT).show();
                    return;
                }

                checkEmailExists(currentEmail, newEmailText);
            }
        });



        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(ChangeEmailActivity.this, MainActivity.class)});
                finish();
            }
        });

    }

    private void checkEmailExists(final String currentEmail, final String newEmail) {
        FirebaseUser user = auth.getCurrentUser();
        if (user != null) {

            if (!user.getEmail().equals(currentEmail)) {
                Toast.makeText(ChangeEmailActivity.this, "Current email does not match signed-in user's email", Toast.LENGTH_SHORT).show();
                return;
            }

            firestore.collection("users").document(newEmail).get()
            .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if (documentSnapshot.exists()) {
                        Toast.makeText(ChangeEmailActivity.this, "New email already exists", Toast.LENGTH_SHORT).show();
                    } else {
                        updateEmail(newEmail);

                    }
                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(ChangeEmailActivity.this, "Failure to check new email existence", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }

    private void updateEmail(String newEmail) {
        FirebaseUser user = auth.getCurrentUser();
        if (user != null) {
            user.verifyBeforeUpdateEmail(newEmail)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(ChangeEmailActivity.this, "Email updated successfully", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(ChangeEmailActivity.this, "Failed to update email: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
            }
        }


        private void sendEmailConfirmation() {
            FirebaseUser user = auth.getCurrentUser();
            if (user != null) {
                user.sendEmailVerification()
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(ChangeEmailActivity.this, "Email confirmation sent", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ChangeEmailActivity.this, "Failure to send email confirmation", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        }
    }













