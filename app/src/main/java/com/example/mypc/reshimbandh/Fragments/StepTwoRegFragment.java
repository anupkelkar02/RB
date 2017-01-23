package com.example.mypc.reshimbandh.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.mypc.reshimbandh.Common.CommonClass;
import com.example.mypc.reshimbandh.Database.Database;
import com.example.mypc.reshimbandh.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class StepTwoRegFragment extends Fragment {


    public StepTwoRegFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_step_two_reg, container, false);
        Button btn_steptwo_next = (Button)view.findViewById(R.id.btn_steptwo_next);
        Spinner spinner_religion = (Spinner) view.findViewById(R.id.religion_2_spinner);
        Database db = new Database(getContext());
        CommonClass commonClass = new CommonClass();
        List<String> religion = new ArrayList<String>();
        religion =db.getMaster(commonClass.RELIGION_MASTER);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, religion);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_religion.setAdapter(dataAdapter);

        Spinner spinner_cast = (Spinner) view.findViewById(R.id.cast_2_spinner);
        List<String> cast = new ArrayList<String>();
        cast.add("Kalar");
        cast.add("Teli");
        ArrayAdapter<String> castAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, cast);
        castAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_cast.setAdapter(castAdapter);


        Spinner spinner_marital = (Spinner) view.findViewById(R.id.marital_status_spinner_2);
        List<String> marital_status = new ArrayList<String>();
        marital_status.add("Married");
        marital_status.add("Unmarried");
        ArrayAdapter<String> MarritalAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, marital_status);
        MarritalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_marital.setAdapter(MarritalAdapter);

        Spinner spinner_qualification_1 = (Spinner) view.findViewById(R.id.qualification_1_spinner);
        Spinner spinner_qualification_2 = (Spinner) view.findViewById(R.id.qualification_2_spinner);
        List<String> qualification = new ArrayList<String>();
        qualification.add("BE");
        qualification.add("BA");
        ArrayAdapter<String> qualiAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, qualification);
        qualiAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_qualification_1.setAdapter(qualiAdapter);
        spinner_qualification_2.setAdapter(qualiAdapter);


        btn_steptwo_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StepThreeRegFragment stepThreeRegFragment = new StepThreeRegFragment();
                android.support.v4.app.FragmentTransaction steponefragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                steponefragmentTransaction.replace(R.id.steps,stepThreeRegFragment);
                steponefragmentTransaction.commit();
            }
        });
        return view;
    }
}
