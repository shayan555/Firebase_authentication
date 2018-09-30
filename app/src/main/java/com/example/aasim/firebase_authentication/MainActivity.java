package com.example.aasim.firebase_authentication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
        EditText e1,e2;
    Button btn;
    TextView txt;

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1= (EditText) findViewById(R.id.editText);
        e2= (EditText) findViewById(R.id.editText2);
        btn= (Button) findViewById(R.id.button2);
        txt= (TextView) findViewById(R.id.textView);

        auth=FirebaseAuth.getInstance();

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,Second.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=e1.getText().toString();
                String pass=e2.getText().toString();
                auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                       if (task.isSuccessful())
                       {
                           Toast.makeText(MainActivity.this, "welcome", Toast.LENGTH_SHORT).show();
                           e1.setText("");
                           e2.setText("");
                       }
                       else
                       {
                           Toast.makeText(MainActivity.this, "invailid user", Toast.LENGTH_SHORT).show();
                       }
                    }
                });
            }
        });
    }
}
