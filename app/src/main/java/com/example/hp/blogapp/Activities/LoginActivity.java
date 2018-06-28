package com.example.hp.blogapp.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.hp.blogapp.Activities.common.Common;
import com.example.hp.blogapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    EditText userEmail, userPassword;

    @BindView(R.id.login_layout)
    LinearLayout loginLayout;
    @BindView(R.id.register_layout)
    LinearLayout registerLayout;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        userEmail = findViewById(R.id.user_email);
        userPassword = findViewById(R.id.user_password);
        loginLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);

                if (checkFileds(userEmail, userPassword)) {
                    Common.saveEmailToSharedPrefs(userEmail, LoginActivity.this);

                    // progressBar.setVisibility(View.INVISIBLE);

                    startActivity(new Intent(LoginActivity.this, Home.class));
                    finish();
                    Toast.makeText(LoginActivity.this, "Working Fine!", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(LoginActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });
        registerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();

            }
        });


    }


    private boolean checkFileds(EditText userEmail, EditText userPassword) {
        if (TextUtils.isEmpty(userEmail.getText().toString()) || TextUtils.isEmpty(userPassword.getText().toString())) {
            Toast.makeText(this, "Fields Empty", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            if (!TextUtils.isEmpty(userPassword.getText().toString())) {
                if (userPassword.getText().toString().length() < 6) {
                    Toast.makeText(this, "Length of password should not be less than 6", Toast.LENGTH_SHORT).show();
                    return false;
                } else {
                    return !TextUtils.isEmpty(userEmail.getText().toString());
                }
            } else {
                Toast.makeText(this, "Password filed is empty", Toast.LENGTH_SHORT).show();
                return false;
            }

        }
    }
}
