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

public class CreateAccount extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.txtName)
    EditText mTxtName;
    @BindView(R.id.txtEmail)EditText mTxtEmail;
    @BindView(R.id.txtPassword)EditText mTxtPassword;
    @BindView(R.id.btnSignUp)Button mBtnSignUp;
    @BindView(R.id.txtLoginText)TextView mTxtLoginText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        ButterKnife.bind(this);

        mTxtLoginText.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mTxtLoginText){
            Intent intent = new Intent(CreateAccount.this,LoginActivity.class);
            startActivity(intent);
        }
    }
}
