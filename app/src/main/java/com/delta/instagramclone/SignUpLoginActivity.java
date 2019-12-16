package com.delta.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUpLoginActivity extends AppCompatActivity {

    private EditText edtUserNameSignUp, edtUserNameLogin, edtPasswordSignUp, edtPasswordLogin;
    private Button btnSignUp, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_login);

        edtUserNameSignUp = findViewById(R.id.edtUserNameSignUp);
        edtUserNameLogin = findViewById(R.id.edtUserNameLogin);
        edtPasswordSignUp = findViewById(R.id.edtPasswordSignUp);
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin);

        btnSignUp = findViewById(R.id.btnSignUp);
        btnLogin = findViewById(R.id.btnLogin);

        //How to sign up a user now !!!!!!!!!!!!!!!!
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ParseUser appUser = new ParseUser();
                appUser.setUsername(edtUserNameSignUp.getText().toString());
                appUser.setPassword(edtPasswordSignUp.getText().toString());

                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null){

                            FancyToast.makeText(SignUpLoginActivity.this, appUser.getUsername() + " is signed up successfully", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();

                            Intent intent = new Intent(SignUpLoginActivity.this, WelcomeActivity.class);
                            startActivity(intent);

                        }else{

                            FancyToast.makeText(SignUpLoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT, FancyToast.ERROR, true).show();

                        }
                    }
                });

            }
        });

        //How to log in a user now !!!!!!!!!!!!!!!!!!
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseUser.logInInBackground(edtUserNameLogin.getText().toString(), edtPasswordLogin.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {

                        if (user != null && e ==null){

                            FancyToast.makeText(SignUpLoginActivity.this, user.get("username") + " is logged in successfully", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();

                            Intent intent = new Intent(SignUpLoginActivity.this, WelcomeActivity.class);
                            startActivity(intent);

                        }else {

                            FancyToast.makeText(SignUpLoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT, FancyToast.ERROR, true).show();

                        }

                    }
                });

            }
        });
    }
}
