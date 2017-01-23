package com.example.mypc.reshimbandh.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.mypc.reshimbandh.Others.ExpandableListAdapter;
import com.example.mypc.reshimbandh.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditProfileFragment extends Fragment {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    public EditProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_edit_profile, container, false);
        expListView = (ExpandableListView) view.findViewById(R.id.lvExp);
        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(getContext(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        return view;
    }
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("PERSONAL INFORMATION");
        listDataHeader.add("FAMILY INFORMATION");
        listDataHeader.add("OTHER INFORMATION");

        // Adding child data
        List<String> subTitle = new ArrayList<String>();
        subTitle.add("Name");
        subTitle.add("Middle Name");
        subTitle.add("Last Name");

        List<String> subInfo = new ArrayList<String>();
        subInfo.add("The Shawshank Redemption");
        subInfo.add("The Godfather");
        subInfo.add("The Godfather: Part II");
        listDataChild.put(listDataHeader.get(0), subTitle); // Header, Child data
        listDataChild.put(listDataHeader.get(1), subTitle); // Header, Child data
        listDataChild.put(listDataHeader.get(2), subTitle); // Header, Child data
    }

}
