package com.example.mypc.reshimbandh.Others;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.example.mypc.reshimbandh.Activity.DashBoardActivity;
import com.example.mypc.reshimbandh.Fragments.ActivateRegistrationFragment;
import com.example.mypc.reshimbandh.Fragments.StepThreeRegFragment;
import com.example.mypc.reshimbandh.R;

/**
 * Created by my pc on 28-11-2016.
 */

public class CustomDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle("Title")
                .setMessage("User Number:106366 Password:  ")
                .setNegativeButton(R.string.pop_btn_2, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivateRegistrationFragment stepThreeRegFragment = new ActivateRegistrationFragment();
                        android.support.v4.app.FragmentTransaction steponefragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                        steponefragmentTransaction.replace(R.id.steps,stepThreeRegFragment);
                        steponefragmentTransaction.commit();
                    }
                })
                .setPositiveButton(R.string.pop_btn_1,  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent dashboard = new Intent(getActivity(), DashBoardActivity.class);
                        startActivity(dashboard);
                        getActivity().finish();

                    }
                })
                .create();
    }
}