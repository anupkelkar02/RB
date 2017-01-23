package com.example.mypc.reshimbandh.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mypc.reshimbandh.Modal.Dataobject;
import com.example.mypc.reshimbandh.Others.MyRecyclerListViewAdapter;
import com.example.mypc.reshimbandh.Others.MyRecyclerViewAdapter;
import com.example.mypc.reshimbandh.R;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyRecmFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private JSONObject jObj;
    private String url;
    private Menu activityMenu;
    ArrayList<Dataobject> list = new ArrayList<Dataobject>();

    public DailyRecmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view= inflater.inflate(R.layout.fragment_daily_recm, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_Daily_recom);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerListViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
//        MenuItem item = activityMenu.findItem(R.id.search_by_user);
//        item.setVisible(false);
        return view;
    }

    private ArrayList<Dataobject> getDataSet() {
        ArrayList results = new ArrayList<Dataobject>();

        for (int index = 0; index < 20; index++) {
            Dataobject obj = new Dataobject("Dipeka Kharote","test",R.drawable.profile_image,R.drawable.ic_list_massage,R.drawable.ic_list_star,R.drawable.send_icon);
            results.add(index, obj);
        }
        return results;
    }
    @Override
    public void onResume() {
        super.onResume();
        ((MyRecyclerListViewAdapter) mAdapter).setOnItemClickListener(new MyRecyclerListViewAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Toast.makeText(getActivity()," Clicked on Item"+ position,Toast.LENGTH_SHORT).show();
//                Intent i = new Intent(getActivity(), DetailActivity.class);
//                Dataobject item = list.get(position);
//                i.putExtra("id",item.getmNum());
//                i.putExtra("action","jahirnama");
//                startActivity(i);
            }
        });
    }

}
