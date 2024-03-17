package com.example.visualock;
import java.util.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.GridView;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;



 public class PasswordActivity extends AppCompatActivity {
     public class ImageAdapter extends BaseAdapter {
         private Context mContext;
         private int[] mImageIds;

         public ImageAdapter(Context context, int[] imageIds) {
             mContext = context;
             mImageIds = imageIds;
         }

         @Override
         public int getCount() {
             return mImageIds.length;
         }

         @Override
         public Object getItem(int position) {
             return null;
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
             imageView.setImageResource(mImageIds[position]);
             return imageView;
         }
     }

     int[] imageArray = {
             R.drawable.grey, R.drawable.phone, R.drawable.birch, R.drawable.bike, R.drawable.leaningtowerofpisa,
             R.drawable.carrot, R.drawable.colosseum, R.drawable.mouse, R.drawable.balloon, R.drawable.boat,
             R.drawable.bear, R.drawable.rabbit, R.drawable.firetruck, R.drawable.greatwallofchina, R.drawable.cedar,
             R.drawable.turtle, R.drawable.bird, R.drawable.truck, R.drawable.statueofliberty, R.drawable.pink,
             R.drawable.giraffe, R.drawable.willow, R.drawable.umbrella, R.drawable.glasses, R.drawable.table,
             R.drawable.snake, R.drawable.maple, R.drawable.elm, R.drawable.beech, R.drawable.train, R.drawable.sailboat,
             R.drawable.sportscar, R.drawable.monkey, R.drawable.white, R.drawable.shoe, R.drawable.plant,
             R.drawable.pyramidsofgiza, R.drawable.christtheredeemer, R.drawable.computer, R.drawable.mug,
             R.drawable.neuschwansteincastle, R.drawable.pickuptruck, R.drawable.green, R.drawable.orange,
             R.drawable.cycle2, R.drawable.stonehenge, R.drawable.kangroo, R.drawable.frog, R.drawable.yellow,
             R.drawable.keyboard, R.drawable.cycle, R.drawable.sun, R.drawable.acropolisofathens, R.drawable.blue,
             R.drawable.cat, R.drawable.leaf, R.drawable.bottle, R.drawable.koifish, R.drawable.fish, R.drawable.kremlin,
             R.drawable.eiffeltower, R.drawable.ash, R.drawable.book, R.drawable.zebra, R.drawable.bigben,
             R.drawable.cloud, R.drawable.ambullance, R.drawable.fir, R.drawable.metro, R.drawable.tiger,
             R.drawable.flower, R.drawable.black, R.drawable.goldengate, R.drawable.lion, R.drawable.red,
             R.drawable.petronastowers, R.drawable.tajmahal, R.drawable.operahouse, R.drawable.dog,
             R.drawable.ape, R.drawable.key, R.drawable.squirrel, R.drawable.bus, R.drawable.polar_bear,
             R.drawable.machupicchu, R.drawable.jetski, R.drawable.oak, R.drawable.purple, R.drawable.hawamahal,
             R.drawable.burjkhalifa, R.drawable.scooter, R.drawable.cargoship, R.drawable.car, R.drawable.pine,
             R.drawable.apple, R.drawable.mountrushmore, R.drawable.helicopter, R.drawable.sportsbike,
             R.drawable.plane
     };
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_input);

        GridView gridView = findViewById(R.id.main_grid);
        gridView.setAdapter(new ImageAdapter(this, imageArray));



        ImageView backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PasswordActivity.this, LoginActivity.class));
            }
        });

    }
}
