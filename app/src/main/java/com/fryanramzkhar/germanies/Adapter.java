package com.fryanramzkhar.germanies;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    int[] gambarTempat;
    String[] namaTempat,detailTempat;

    public Adapter(Context context, int[] gambarTempat, String[] namaTempat, String[] detailTempat) {
        this.context = context;
        this.gambarTempat = gambarTempat;
        this.namaTempat = namaTempat;
        this.detailTempat = detailTempat;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_tempat, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, final int i) {
        viewHolder.txtNama.setText(namaTempat[i]);
        Glide.with(context).load(gambarTempat[i]).into(viewHolder.imgTempat);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(context, DetailTempat.class);
                pindah.putExtra("nt",namaTempat[i]);
                pindah.putExtra("dt",detailTempat[i]);
                pindah.putExtra("gt",gambarTempat[i]);
                context.startActivity(pindah);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gambarTempat.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgTempat;
        TextView txtNama;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTempat = itemView.findViewById(R.id.imgList);
            txtNama = itemView.findViewById(R.id.txtListTitle);
        }
    }
}
