package com.example.loginsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.common.SignInButton;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {
    private static final String EMAIL = "email";
    private static final String USER_POSTS = "user_posts";
    private static final String AUTH_TYPE = "rerequest";

    private CallbackManager mCallbackManager;
    private TextView txt_logo,txt_note,txt_forgot_password,txt_register,txt_or;
    private EditText editText_password;
    AutoCompleteTextView autoCompleteTextView_phno;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt_logo=findViewById(R.id.txt_logo);
        txt_note=findViewById(R.id.txt_note);
        txt_forgot_password=findViewById(R.id.txt_forgot_password);
        txt_register=findViewById(R.id.txt_register);
        txt_or=findViewById(R.id.txt_or);
        autoCompleteTextView_phno=findViewById(R.id.txt_ph);
        editText_password=findViewById(R.id.txt_password);
        mCallbackManager = CallbackManager.Factory.create();

        SignInButton g_sign_in_button=findViewById(R.id.g_sign_in_button);
        LoginButton f_login_button = findViewById(R.id.f_login_button);

        g_sign_in_button.setSize(SignInButton.SIZE_STANDARD);
        TextView textView= (TextView) g_sign_in_button.getChildAt(0);
        textView.setText("Sign in with Google");

        // Set the initial permissions to request from the user while logging in
        f_login_button.setReadPermissions(Arrays.asList(EMAIL, USER_POSTS));

        f_login_button.setAuthType(AUTH_TYPE);

        // Register a callback to respond to the user
        f_login_button.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                setResult(RESULT_OK);
                finish();
            }

            @Override
            public void onCancel() {
                setResult(RESULT_CANCELED);
                finish();
            }

            @Override
            public void onError(FacebookException e) {
                // Handle exception
            }
        });
    }

}
