package com.example.shubhampandey.abcd;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button buttonsignup;
    private EditText edittextpassword;
    private EditText edittextmail;
    private TextView textsignin;


    private ProgressDialog progressdialog;

    private FirebaseAuth firebaseauth;
    private FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseauth = FirebaseAuth.getInstance();
        mauth = FirebaseAuth.getInstance();

        progressdialog = new ProgressDialog(this);

        buttonsignup = (Button) findViewById(R.id.buttonsignup);
        edittextpassword = (EditText) findViewById(R.id.edittextpassword);
        edittextmail = (EditText) findViewById(R.id.edittextmail);
        textsignin = (TextView) findViewById(R.id.textsignin);

        buttonsignup.setOnClickListener(this);
        textsignin.setOnClickListener(this);


    }


    private void registeruser() {
        String email = edittextmail.getText().toString().trim();
        String password = edittextpassword.getText().toString().trim();


        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "please enter email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty((password))) {
            Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressdialog.setMessage("registering user...");
        progressdialog.show();

        firebaseauth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(MainActivity.this, activity2.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        } else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                Toast.makeText(MainActivity.this, "Already Registered", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });


    }

    private void loginuser() {
        String email = edittextmail.getText().toString().trim();
        String password = edittextpassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "please enter email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty((password))) {
            Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressdialog.setMessage("registering user...");
        progressdialog.show();

        mauth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Intent intent = new Intent(MainActivity.this, activity2.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }



    @Override
    public void onClick(View v) {

        if (v == buttonsignup) {
            registeruser();
        }

        if (v == textsignin) {
            loginuser();

        }
    }
}
