package com.example.mypc.reshimbandh.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mypc.reshimbandh.Activity.DashBoardActivity;
import com.example.mypc.reshimbandh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActivateRegistrationFragment extends Fragment {


    public ActivateRegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_activate_registration, container, false);
        Button btn_home = (Button) view.findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dashboard = new Intent(getActivity(), DashBoardActivity.class);
                startActivity(dashboard);
                getActivity().finish();
            }
        });
        return view;
    }

}
