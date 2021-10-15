package com.example.mystagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

    public static final String TAG = "SignupActivity";
    private EditText tvSetUsername;
    private EditText tvSetPassword;
    private EditText tvSetEmail;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        tvSetUsername = findViewById(R.id.tvSetUsername);
        tvSetPassword = findViewById(R.id.tvSetPassword);
        tvSetEmail = findViewById(R.id.tvSetEmail);
        btnSignup = findViewById(R.id.btnSignup);
        ParseUser user = new ParseUser();


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick sign up button");
                String username = tvSetUsername.getText().toString();
                String password = tvSetPassword.getText().toString();
                String email = tvSetEmail.getText().toString();
                signUpUser(username, password, email);

            }
        });
    }

    private void signUpUser(String username, String password, String email) {
        // Create the ParseUser
        ParseUser user = new ParseUser();
        // Set core properties
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        // Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(SignupActivity.this, "Sign up successful!", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e(TAG, "Issues with sign up", e);
                    Toast.makeText(SignupActivity.this, "Issue with sign up.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        goMainActivity();
    }

    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}