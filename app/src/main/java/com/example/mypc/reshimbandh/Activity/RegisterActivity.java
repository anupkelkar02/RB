package com.example.mypc.reshimbandh.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mypc.reshimbandh.Fragments.LoginFragment;
import com.example.mypc.reshimbandh.Fragments.StepOneRegFragment;
import com.example.mypc.reshimbandh.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        StepOneRegFragment stepOneRegFragment = new StepOneRegFragment();
        android.support.v4.app.FragmentTransaction steponefragmentTransaction = getSupportFragmentManager().beginTransaction();
        steponefragmentTransaction.replace(R.id.steps,stepOneRegFragment);
        steponefragmentTransaction.commit();
    }
}
