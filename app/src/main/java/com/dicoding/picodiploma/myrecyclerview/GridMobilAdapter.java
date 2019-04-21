package com.dicoding.picodiploma.myrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridMobilAdapter extends RecyclerView.Adapter<GridMobilAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<Mobil> listMobil;

    public ArrayList<Mobil> getListMobil() {
        return listMobil;
    }

    public void setListMobil(ArrayList<Mobil> listMobil) {
        this.listMobil = listMobil;
    }

    public GridMobilAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GridMobilAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_mobil, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridMobilAdapter.GridViewHolder holder, int position) {
        Glide.with(context)
                .load(getListMobil().get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListMobil().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
