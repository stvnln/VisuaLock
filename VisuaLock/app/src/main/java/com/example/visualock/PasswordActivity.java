package com.example.visualock;
import java.util.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.widget.GridView;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.AdapterView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.api.Distribution;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.DocumentSnapshot;

public class PasswordActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    FirebaseFirestore database;

    private FirebaseFirestore firestore;
    private ArrayList<String> colorImages;
    private ArrayList<String> treeImages;
    private ArrayList<String> dailyObjectsImages;
    private ArrayList<String> animalImages;
    private ArrayList<String> placesImages;
    private ArrayList<String> vehicleImages;

    private ArrayList<String> keyList;
    private final HashMap<String, List<String>> passwordKey = new HashMap<String, List<String>>();
    private Button enter;

    private LinearLayout inputView;




    public static class ImageAdapter extends BaseAdapter {
         private final Context mContext;
         private final ArrayList<String> mImageUrls;

         public ImageAdapter(Context context, ArrayList<String> imageUrls) {
             mContext = context;
             mImageUrls = imageUrls;
         }

         @Override
         public int getCount() {
             return mImageUrls.size();
         }

         @Override
         public Object getItem(int position) {
             return mImageUrls.get(position);
         }

         @Override
         public long getItemId(int position) {
             return position;
         }

         @Override
         public View getView(int position, View convertView, ViewGroup parent) {
             ImageView imageView;
             if (convertView == null) {
                 // If convertView is null, inflate a new ImageView
                 imageView = new ImageView(mContext);
                 imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200));
                 imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
             } else {
                 // If convertView is not null, reuse it
                 imageView = (ImageView) convertView;
             }

             // Set the image resource for the ImageView
             Glide.with(mContext).load(mImageUrls.get(position)).into(imageView);
             return imageView;
         }

     }




    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_input);

        Bundle bundle = new Bundle();

        bundle = getIntent().getExtras();



        database = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        enter = findViewById(R.id.enterButton);
        inputView = findViewById(R.id.inputView);



        DocumentReference key = firestore.collection("image_categories").document("key");
        key.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot document) {
                String documentID = document.getId();
                Map<String, Object> data = document.getData();
                if(data!=null){
                    for(Map.Entry<String,Object> entry: data.entrySet()){
                        String field = entry.getKey();
                        ArrayList<String> value = (ArrayList<String>) entry.getValue();
                        switch (field){
                            case "animalImages":
                                passwordKey.put("animalImages", value);
                                break;
                            case "colorImages":
                                passwordKey.put("colorImages", value);
                                break;
                            case "dailyObjectsImages":
                                passwordKey.put("dailyObjectsImages", value);
                                break;
                            case "placesImages":
                                passwordKey.put("placesImages", value);
                                break;
                            case "treeImages":
                                passwordKey.put("treeImages", value);
                                break;
                            case "vehicleImages":
                                passwordKey.put("vehicleImages", value);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        });
        DocumentReference image_categories =  firestore.collection("image_categories").document("qPQROdVyhejjFHqYySWo");
        Bundle finalBundle = bundle;
        image_categories.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot document) {
                String documentID = document.getId();
                Map<String, Object> data = document.getData();
                Log.d("PasswordActivity", "Document ID is here: " + documentID);
                if (data != null) {
                    for (Map.Entry<String, Object> entry : data.entrySet()) {
                        Log.d("PasswordActivity", "Document data is here: " + entry.getKey() + " = " + entry.getValue());
                        String field = entry.getKey();
                        ArrayList<String> value = (ArrayList<String>) entry.getValue();
                        switch (field) {
                            case "animalImages":
                                animalImages = value;
                                Log.d("PasswordActivity", "Animal Images: " + animalImages);
                                break;
                            case "colorImages":
                                colorImages = value;
                                Log.d("PasswordActivity", "Color Images: " + colorImages);
                                break;
                            case "dailyObjectsImages":
                                dailyObjectsImages = value;
                                Log.d("PasswordActivity", "Daily Objects Images: " + dailyObjectsImages);
                                break;
                            case "placesImages":
                                placesImages = value;
                                Log.d("PasswordActivity", "Places Images: " + placesImages);
                                break;
                            case "treeImages":
                                treeImages = value;
                                Log.d("PasswordActivity", "Tree Images: " + treeImages);
                                break;
                            case "vehicleImages":
                                vehicleImages = value;
                                Log.d("PasswordActivity", "Vehicle Images: " + vehicleImages);
                                break;
                            default:
                                break;
                        }
                    }
                }
                ListView Tree = findViewById(R.id.cat_tree);
                Tree.setAdapter(new ImageAdapter(PasswordActivity.this, treeImages));
                ListView Color = findViewById(R.id.cat_color);
                Color.setAdapter(new ImageAdapter(PasswordActivity.this, colorImages));
                ListView dailyObjects = findViewById(R.id.cat_dailyObjects);
                dailyObjects.setAdapter(new ImageAdapter(PasswordActivity.this,dailyObjectsImages));
                ListView Animals = findViewById(R.id.cat_animals);
                Animals.setAdapter(new ImageAdapter(PasswordActivity.this, animalImages));
                ListView Places = findViewById(R.id.cat_places);
                Places.setAdapter(new ImageAdapter(PasswordActivity.this, placesImages));
                ListView Vehicle = findViewById(R.id.cat_vehicles);
                Vehicle.setAdapter(new ImageAdapter(PasswordActivity.this,vehicleImages));
                ArrayList<String> inputImages = new ArrayList<>();
                ArrayList<String> input = new ArrayList<>();
                enter.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        String pass = input.toString();
                        String email = finalBundle.getString("email");
                        String from_activity = finalBundle.getString("from_activity");
                        if (from_activity.equals("login")) {


                            auth.signInWithEmailAndPassword(email, pass)
                                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                                @Override
                                                public void onSuccess(AuthResult authResult) {
                                                    Toast.makeText(PasswordActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                                    updatePasswordInFirestore(email, pass);
                                                    Intent intent = new Intent(PasswordActivity.this, MainActivity.class);
                                                    intent.putExtra("email", email);
                                                    startActivity(intent);
                                                    finish();
                                                }
                                            }).addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    Toast.makeText(PasswordActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                                }
                                            });
                        } else if (from_activity.equals("register")) {
                            String name = finalBundle.getString("name");

                            User user1 = new User(name, email, pass);


                            // Create user with email and password
                            auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                                        if (currentUser != null) {
                                            currentUser.sendEmailVerification()
                                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<Void> task) {
                                                            if (task.isSuccessful()) {
                                                                Toast.makeText(PasswordActivity.this, "Verification email sent. Please verify your email address.", Toast.LENGTH_SHORT).show();
                                                            } else {
                                                                Toast.makeText(PasswordActivity.this, "Failed to send verification email.", Toast.LENGTH_SHORT).show();
                                                            }
                                                        }
                                                    });
                                        }

                                        String uid = task.getResult().getUser().getUid();
                                        database
                                                .collection("users")
                                                .document(uid)
                                                .set(user1)
                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (task.isSuccessful()) {
                                                            Toast.makeText(PasswordActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                                            startActivity(new Intent(PasswordActivity.this, LoginActivity.class));
                                                            finish();
                                                        } else {
                                                            Toast.makeText(PasswordActivity.this, "Failed to set display name", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                });

                                        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                                .setDisplayName(name)
                                                .build();

                                        firebaseUser.updateProfile(profileUpdates)
                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (!task.isSuccessful()) {
                                                            Toast.makeText(PasswordActivity.this, "Failed to set display name", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                });
                                    } else {
                                        Toast.makeText(PasswordActivity.this, "Registration failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    }
            });


                Tree.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        input.add(passwordKey.get("treeImages").get(position));
                        ImageView image = new ImageView(PasswordActivity.this);
                        image.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 150));
                        Glide.with(PasswordActivity.this).load(treeImages.get(position)).into(image);
                        inputView.addView(image);
                    }
                });
                Color.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        input.add(passwordKey.get("colorImages").get(position));
                        ImageView image = new ImageView(PasswordActivity.this);
                        image.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 150));
                        Glide.with(PasswordActivity.this).load(colorImages.get(position)).into(image);
                        inputView.addView(image);
                    }
                });


                dailyObjects.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        input.add(passwordKey.get("dailyObjectsImages").get(position));
                        ImageView image = new ImageView(PasswordActivity.this);
                        image.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 150));
                        Glide.with(PasswordActivity.this).load(dailyObjectsImages.get(position)).into(image);
                        inputView.addView(image);

                    }
                });
                Animals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        input.add(passwordKey.get("animalImages").get(position));
                        ImageView image = new ImageView(PasswordActivity.this);
                        image.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 150));
                        Glide.with(PasswordActivity.this).load(animalImages.get(position)).into(image);
                        inputView.addView(image);

                    }
                });
                Places.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        input.add(passwordKey.get("placesImages").get(position));
                        ImageView image = new ImageView(PasswordActivity.this);
                        image.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 150));
                        Glide.with(PasswordActivity.this).load(placesImages.get(position)).into(image);
                        inputView.addView(image);

                    }
                });
                Vehicle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        input.add(passwordKey.get("vehicleImages").get(position));
                        ImageView image = new ImageView(PasswordActivity.this);
                        image.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 150));
                        Glide.with(PasswordActivity.this).load(vehicleImages.get(position)).into(image);
                        inputView.addView(image);
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("PasswordActivity", "Error getting documents: ", e);
            }
        });

         ImageView backButton = findViewById(R.id.backButton);
         backButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(PasswordActivity.this, LoginActivity.class));
             }
         });
     }

    private void updatePasswordInFirestore(final String email, final String password) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            DocumentReference userRef = firestore.collection("users").document(user.getUid());
            userRef.update("pass", password)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            //Toast.makeText(LoginActivity.this, "Password updated in Firestore", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            //Toast.makeText(LoginActivity.this, "Failed to update password in Firestore", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }
}
