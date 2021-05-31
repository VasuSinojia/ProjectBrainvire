package com.example.projectbrainvire;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public class MainActivity extends AppCompatActivity {

    ListView lv;

//    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String getName = getIntent().getStringExtra("a");
        String getEmail = getIntent().getStringExtra("b");

        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Successfully Logged in as " + getName , Snackbar.LENGTH_LONG);
        snackbar.show();

        lv = findViewById(R.id.lv);

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Name : "+getName);
        arrayList.add("Email : "+getEmail);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(adapter);
    }
}


//
//    public FirebaseFirestore getDb() {
//        db.collection("group").document().get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                if(documentSnapshot.exists()){
//                    userData.add(documentSnapshot.getString("name"));
//                    userData.add(documentSnapshot.getString("email"));
//                }
//            }
//        });
//        return db;
//    }


