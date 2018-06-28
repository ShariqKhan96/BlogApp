package com.example.hp.blogapp.Activities;

import android.content.Intent;
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

public class RegisterActivity extends AppCompatActivity {
    EditText userEmail, userPassword, confirmPass;

    @BindView(R.id.create_account)
    LinearLayout createLayout;
    @BindView(R.id.already_account)
    LinearLayout alreadyLayout;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        userEmail = findViewById(R.id.user_email);
        userPassword = findViewById(R.id.user_password);
        confirmPass = findViewById(R.id.confirm_password);

        createLayout.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);
                if (checkFileds(userEmail, userPassword, confirmPass)) {
                    Common.saveEmailToSharedPrefs(userEmail, RegisterActivity.this);

                    startActivity(new Intent(RegisterActivity.this, Home.class));
                    finish();
                    Toast.makeText(RegisterActivity.this, "Working Fine!", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(RegisterActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();

            }
        });

        alreadyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });

    }

    private boolean checkFileds(EditText userEmail, EditText userPassword, EditText confirmPass) {
        if (TextUtils.isEmpty(userEmail.getText().toString()) ||
                TextUtils.isEmpty(userPassword.getText().toString()) ||
                TextUtils.isEmpty(confirmPass.getText().toString())) {
            Toast.makeText(this, "Fields Empty", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            if (!TextUtils.isEmpty(userPassword.getText().toString()) || !TextUtils.isEmpty(confirmPass.getText().toString())) {
                if (userPassword.getText().toString().length() < 6 || confirmPass.getText().toString().length() < 6) {
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
