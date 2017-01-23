package com.example.mypc.reshimbandh.Others;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mypc.reshimbandh.Modal.Dataobject;
import com.example.mypc.reshimbandh.R;

import java.util.ArrayList;

/**
 * Created by my pc on 20-11-2016.
 */

public class MyRecyclerViewAdapter  extends RecyclerView.Adapter<MyRecyclerViewAdapter
        .CustomViewHolder>  {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<Dataobject> mDataset;
    private static MyClickListener myClickListener;
    private Context mContext;

    public MyRecyclerViewAdapter(Context context,ArrayList<Dataobject> dataobject){
        this.mDataset = dataobject;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int position) {
        customViewHolder.profile_name.setText(mDataset.get(position).getFullname());
        customViewHolder.profile_image.setImageResource(mDataset.get(position).get_profile_image());
        customViewHolder.image1.setImageResource(mDataset.get(position).getimage1());
        customViewHolder.image2.setImageResource(mDataset.get(position).getimage2());
        customViewHolder.image3.setImageResource(mDataset.get(position).getimage3());
    }

    @Override
    public int getItemCount() {
        return (null != mDataset ? mDataset.size() : 0);
    }
    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView image1,image2,image3,profile_image;
        TextView profile_name;
        public CustomViewHolder(View itemView) {
            super(itemView);
            this.profile_image = (ImageView) itemView.findViewById(R.id.profile_image);
            this.image1 = (ImageView) itemView.findViewById(R.id.action_image1);
            this.image2 = (ImageView) itemView.findViewById(R.id.action_image2);
            this.image3 = (ImageView) itemView.findViewById(R.id.action_image3);
            this.profile_name = (TextView) itemView.findViewById(R.id.profile_name);
        }
    }
}
