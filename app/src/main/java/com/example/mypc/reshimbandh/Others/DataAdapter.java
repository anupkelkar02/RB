package com.example.mypc.reshimbandh.Others;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mypc.reshimbandh.Modal.Dataobject;
import com.example.mypc.reshimbandh.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by my pc on 19-11-2016.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>
{
    private ArrayList<Dataobject> data;
    private Context context;

    public DataAdapter(Context context,ArrayList<Dataobject> android) {
        this.data = android;
        this.context = context;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int position) {
        viewHolder.tv_android.setText(data.get(position).getFullname());
        Picasso.with(context).load(data.get(position).getProfile_image_url()).resize(240, 120).into(viewHolder.img_android);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_android;
        private ImageView img_android;
        public ViewHolder(View view) {
            super(view);

            tv_android = (TextView)view.findViewById(R.id.list_fullname);
            img_android = (ImageView) view.findViewById(R.id.profile_image);
        }
    }
}
