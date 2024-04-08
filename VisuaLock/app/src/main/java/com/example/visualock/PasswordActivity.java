package com.example.visualock;
import java.util.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.DocumentSnapshot;

public class PasswordActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private FirebaseFirestore firestore;



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


    ArrayList<String> colorImages;
    ArrayList<String> treeImages;
    ArrayList<String> dailyObjectsImages;
    ArrayList<String> animalImages;
    ArrayList<String> placesImages;
    ArrayList<String> vehicleImages;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_input);



        firestore = FirebaseFirestore.getInstance();
        DocumentReference image_categories =  firestore.collection("image_categories").document("qPQROdVyhejjFHqYySWo");
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

                Tree.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(PasswordActivity.this, "Tree image clicked at position: " + position, Toast.LENGTH_SHORT).show();


                    }
                });
                Color.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(PasswordActivity.this, "Color image clicked at position: " + position, Toast.LENGTH_SHORT).show();


                    }
                });
                dailyObjects.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(PasswordActivity.this, "Daily Object image clicked at position: " + position, Toast.LENGTH_SHORT).show();


                    }
                });
                Animals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(PasswordActivity.this, "Animals image clicked at position: " + position, Toast.LENGTH_SHORT).show();


                    }
                });
                Places.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(PasswordActivity.this, "Places image clicked at position: " + position, Toast.LENGTH_SHORT).show();


                    }
                });
                Vehicle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(PasswordActivity.this, "Vehicle image clicked at position: " + position, Toast.LENGTH_SHORT).show();


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

}
