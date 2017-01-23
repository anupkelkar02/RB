package com.example.mypc.reshimbandh.Fragments;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.mypc.reshimbandh.Activity.LoginActivity;
import com.example.mypc.reshimbandh.Others.CustomDialog;
import com.example.mypc.reshimbandh.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class StepThreeRegFragment extends Fragment {


    public StepThreeRegFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_step_three_reg, container, false);
        Button btn_stepthree_next = (Button)view.findViewById(R.id.btn_register);
        btn_stepthree_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
                getActivity().finish();
            }
        });
        Spinner spinner_marital = (Spinner) view.findViewById(R.id.marital_status_spinner_3);
        List<String> marital_status = new ArrayList<String>();
        marital_status.add("Married");
        marital_status.add("Unmarried");
        ArrayAdapter<String> MarritalAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, marital_status);
        MarritalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_marital.setAdapter(MarritalAdapter);


        Spinner spinner_religion = (Spinner) view.findViewById(R.id.religion_3_spinner);
        List<String> religion = new ArrayList<String>();
        religion.add("Hindhu");
        religion.add("Muslim");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, religion);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_religion.setAdapter(dataAdapter);


        Spinner spinner_cast = (Spinner) view.findViewById(R.id.cast_3_spinner);
        List<String> cast = new ArrayList<String>();
        cast.add("Kalar");
        cast.add("Teli");
        ArrayAdapter<String> castAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, cast);
        castAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_cast.setAdapter(castAdapter);


        Spinner spinner_qualification_1 = (Spinner) view.findViewById(R.id.qualification_3_spinner);
        List<String> qualification = new ArrayList<String>();
        qualification.add("BE");
        qualification.add("BA");
        ArrayAdapter<String> qualiAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, qualification);
        qualiAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_qualification_1.setAdapter(qualiAdapter);

        Button btn_register = (Button)view.findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft =getActivity().getSupportFragmentManager().beginTransaction();
                // Create and show the dialog.
                CustomDialog newFragment = new CustomDialog ();
                newFragment.show(ft, "dialog");
            }
        });



        return view;
    }



}
