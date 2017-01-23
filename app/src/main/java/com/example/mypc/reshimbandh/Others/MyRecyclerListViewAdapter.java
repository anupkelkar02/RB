package com.example.mypc.reshimbandh.Others;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mypc.reshimbandh.Modal.Dataobject;
import com.example.mypc.reshimbandh.R;

import java.util.ArrayList;

/**
 * Created by my pc on 20-11-2016.
 */

public class MyRecyclerListViewAdapter extends RecyclerView.Adapter<MyRecyclerListViewAdapter
        .DataObjectHolder>  {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<Dataobject> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView label;
        TextView dateTime;
        TextView textView3;
        TextView textView4;

        public DataObjectHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.profile_image);
            dateTime = (TextView) itemView.findViewById(R.id.list_fullname);
            //textView3 = (TextView) itemView.findViewById(R.id.textView3);
            //textView4 = (TextView) itemView.findViewById(R.id.textDate);
            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }
    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }
    public MyRecyclerListViewAdapter(ArrayList<Dataobject> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_layout, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        //holder.label.setText(mDataset.get(position).getFullname());
       // holder.dateTime.setText(mDataset.get(position).getDiscription());
        // holder.textView3.setText(mDataset.get(position).getmText3());
        //holder.textView4.setText(mDataset.get(position).getmText4());
    }

    public void addItem(Dataobject dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

}
