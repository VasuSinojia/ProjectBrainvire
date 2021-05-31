package com.example.projectbrainvire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private EditText et_name;
    private EditText et_email;
    private EditText et_password;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getName = et_name.getText().toString();
                String getEmail = et_email.getText().toString();
                String getPassword = et_password.getText().toString();
                String Expn =
                        "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if (getEmail.matches(Expn) && getEmail.length() > 0 && getPassword.length() > 0 && getName.length() > 0) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class).putExtra("a",getName).putExtra("b",getEmail));
                } else {
                    Toast.makeText(LoginActivity.this, "Please Enter Valid Details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

//    ***** I had tried database also to store the values but i was getting runtime errors so that i was not able to
//            do it completly   Here is my code for database which i had tried*****



//    FirebaseFirestore database = FirebaseFirestore.getInstance();

//    Map<String,String> map = new HashMap<>();
//                map.put("Name",getName);
//                map.put("Email",getEmail);
//                database.collection("user").document().set(map);

//    public void getData(){
//        db.collection("group").document().get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                namesList.add(documentSnapshot.getString("name"));
//                namesList.add(documentSnapshot.getString("email"));
//            }
//        });
//    }
}





