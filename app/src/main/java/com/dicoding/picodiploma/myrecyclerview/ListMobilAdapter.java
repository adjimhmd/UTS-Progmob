package com.dicoding.picodiploma.myrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListMobilAdapter extends RecyclerView.Adapter<ListMobilAdapter.CategoryViewHolder> {
    private static final String TAG = "ListMobilAdapter";
    private ArrayList<Mobil> listMobil;
    private Context context;


    public ListMobilAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Mobil> getListMobil() {
        return listMobil;
    }

    public void setListMobil(ArrayList<Mobil> listMobil) {
        this.listMobil = listMobil;
    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_mobil, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        categoryViewHolder.tvName.setText(getListMobil().get(position).getName());
        categoryViewHolder.tvRemarks.setText(getListMobil().get(position).getRemarks());
        Glide.with(context)
                .load(getListMobil().get(position).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListMobil().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;
        RelativeLayout parentLayout;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
