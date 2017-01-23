package com.example.mypc.reshimbandh.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mypc.reshimbandh.Modal.Dataobject;
import com.example.mypc.reshimbandh.Others.MyRecyclerViewAdapter;
import com.example.mypc.reshimbandh.R;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class InterestSentFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private JSONObject jObj;
    private String url;
    ArrayList<Dataobject> list = new ArrayList<Dataobject>();



    public InterestSentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_interest_sent, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_new_matches);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(getContext(),getDataSet());
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }
    private ArrayList<Dataobject> getDataSet() {
        ArrayList results = new ArrayList<Dataobject>();

        for (int index = 0; index < 20; index++) {
            Dataobject obj = new Dataobject("Dipeka Kharote","test",R.drawable.profile_image,R.drawable.ic_list_massage,R.drawable.ic_list_star,R.drawable.yes_btn);
            results.add(index, obj);
        }
        return results;
    }

}
