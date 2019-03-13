package com.example.licio.moringaeats.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.licio.moringaeats.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateAccount extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private ProgressDialog mAuthProgressDialog;

    @BindView(R.id.txtName)
    EditText mTxtName;
    @BindView(R.id.txtEmail)
    EditText mTxtEmail;
    @BindView(R.id.txtPassword)
    EditText mTxtPassword;
    @BindView(R.id.btnSignUp)
    Button mBtnSignUp;
    @BindView(R.id.txtLoginText)
    TextView mTxtLoginText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        ButterKnife.bind(this);

        createAuthProgressDialog();

        mAuth = FirebaseAuth.getInstance();
        createAuthStateListener();


        mTxtLoginText.setOnClickListener(this);
        mBtnSignUp.setOnClickListener(this);
    }

    private void createAuthProgressDialog() {
        mAuthProgressDialog = new ProgressDialog(this);
        mAuthProgressDialog.setTitle("Loading...");
        mAuthProgressDialog.setMessage("Authenticating with Firebase...");
        mAuthProgressDialog.setCancelable(false);
    }

    private void createAuthStateListener() {
        mAuthListener = new FirebaseAuth.AuthStateListener() {


            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(CreateAccount.this, Welcome.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }

            }

        };

    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    public void onClick(View view) {
        if (view == mTxtLoginText) {
            Intent intent = new Intent(CreateAccount.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        if (view == mBtnSignUp) {
            createNewUser();
        }
    }

    private void createNewUser() {
        final String name = mTxtName.getText().toString().trim();
        final String email = mTxtEmail.getText().toString().trim();
        String password = mTxtPassword.getText().toString().trim();

        mAuthProgressDialog.show();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        mAuthProgressDialog.dismiss();
//                        if (task.isSuccessful()) {
//                            Log.d(TAG, "Authentication successful");
//                            createFirebaseUserProfile(task.getResult().getUser());
//                        } else {
//                            Toast.makeText(CreateAccountActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                        }
                    }
                });

    }
}
