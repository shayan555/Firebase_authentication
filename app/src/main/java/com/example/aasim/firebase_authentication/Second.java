package com.example.aasim.firebase_authentication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Second extends AppCompatActivity {
    EditText e3,e4;
    Button btn2;

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        e3= (EditText) findViewById(R.id.editText3);
        e4= (EditText) findViewById(R.id.editTex4);
        btn2= (Button) findViewById(R.id.button3);
        //lib add ki firebase authetication
        mAuth=FirebaseAuth.getInstance();

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String email=e3.getText().toString();
                String pass=e4.getText().toString();

                mAuth.createUserWithEmailAndPassword(email,pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult)
                    {
                    if (authResult.getUser()!=null)
                    {
                        Toast.makeText(Second.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                        e3.setText("");
                        e4.setText("");
                    }
                    else
                    {
                        Toast.makeText(Second.this, "Try Again", Toast.LENGTH_SHORT).show();
                    }

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Second.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
