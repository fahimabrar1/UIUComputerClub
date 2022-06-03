package com.example.uiucclapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class log_In extends AppCompatActivity implements View.OnClickListener {


    private FirebaseAuth mAuth;



    Button login,signup;
    EditText emailText,passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log__in);
        mAuth = FirebaseAuth.getInstance();

        setViews();
        setOnClicklisteners();


    }

    private void setOnClicklisteners() {
        login.setOnClickListener(this);
        signup.setOnClickListener(this);
    }

    private void setViews() {
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);
        emailText = findViewById(R.id.studentEmailID);
        passwordText = findViewById(R.id.StudnetPassword);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login)
        {
            String emailToText = emailText.getText().toString();
            String passwordToText = passwordText.getText().toString();

            // Android offers the inbuilt patterns which the entered
            // data from the EditText field needs to be compared with
            // In this case the the entered data needs to compared with
            // the EMAIL_ADDRESS, which is implemented same below
            if (!emailToText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailToText).matches() && !passwordToText.isEmpty()) {

                signIn(emailToText,passwordToText);

            }
            if (emailToText.isEmpty()){
                emailText.setError("Invalid Email!");
            }

            if (passwordToText.isEmpty()){
                passwordText.setError("Invalid Password!");

            }

//            startActivity(new Intent(log_In.this,home.class));
        }else if((view.getId() == R.id.signup)) {
//            startActivity(new Intent(log_In.this,sign_up.class));
        }
    }


    public void signIn(String email, String password)
    {
        Log.d("LogIN",email);
        Log.d("LogIN",password);
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d("LogIN","Task Successfull");

                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(log_In.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }


    void updateUI(FirebaseUser user)
    {

        if(user!=null)
        {
            Intent i = new Intent(getApplicationContext(), home.class);
            startActivity(i);
        }else{
            Toast.makeText(log_In.this, "User Not Email Verified",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
    }
}