package com.delta.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

public class WelcomeActivity extends AppCompatActivity {

    private TextView txtWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        txtWelcome = findViewById(R.id.txtWelcome);
        txtWelcome.setText("WELCOME!!! " + ParseUser.getCurrentUser().getUsername());

        findViewById(R.id.btnLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FancyToast.makeText(WelcomeActivity.this, ParseUser.getCurrentUser().get("username") + " is logged out successfully", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                ParseUser.logOut();
                finish();

            }
        });


    }
}
