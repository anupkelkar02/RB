package com.example.mypc.reshimbandh.Activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mypc.reshimbandh.Fragments.LoginFragment;
import com.example.mypc.reshimbandh.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       // getSupportActionBar().hide();
        LoginFragment loginFragment = new LoginFragment();
        android.support.v4.app.FragmentTransaction loginfragmentTransaction = getSupportFragmentManager().beginTransaction();
        loginfragmentTransaction.replace(R.id.user_login_forgot,loginFragment);
        loginfragmentTransaction.commit();
    }
}
