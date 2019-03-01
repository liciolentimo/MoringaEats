package com.example.licio.moringaeats;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Welcome extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.welcome) TextView mWelcome;
    @BindView(R.id.desc) TextView mDescription;
    @BindView(R.id.btnLearn) Button mBtnLearn;
    @BindView(R.id.btnView) Button mBtnView;
    @BindView(R.id.edtName) EditText mEdtName;
    @BindView(R.id.btnEnter) Button mBtnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ButterKnife.bind(this);

        Typeface caviarFont = Typeface.createFromAsset(getAssets(), "fonts/CaviarDreams.ttf");
        mWelcome.setTypeface(caviarFont);
        mDescription.setTypeface(caviarFont);

        mBtnLearn.setOnClickListener(this);
        mBtnView.setOnClickListener(this);
        mBtnEnter.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Welcome.this,Home.class);
        startActivity(intent);

            Intent intent2 = new Intent(Welcome.this,ViewRecipes.class);
            startActivity(intent2);

        Intent intent3 = new Intent(Welcome.this,Home.class);
        startActivity(intent3);
        }
    }



