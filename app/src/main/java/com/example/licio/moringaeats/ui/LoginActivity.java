package com.example.licio.moringaeats.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.licio.moringaeats.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.txtEmail)EditText mTxtEmail;
    @BindView(R.id.txtPassword)EditText mTxtPassword;
    @BindView(R.id.btnLogin)Button mBtnSignUp;
    @BindView(R.id.txtSignUpText)TextView mTxtSignUpText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        mTxtSignUpText.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mTxtSignUpText){
            Intent intent = new Intent(LoginActivity.this,CreateAccount.class);
            startActivity(intent);
        }
    }
}
