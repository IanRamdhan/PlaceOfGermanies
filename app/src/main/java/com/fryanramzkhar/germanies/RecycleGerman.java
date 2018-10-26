package com.fryanramzkhar.germanies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleGerman extends AppCompatActivity {

    @BindView(R.id.my_recycle_german)
    RecyclerView myRecycleGerman;

    String[] namaTempat,detailTempat;
    int[] gambarTempat;

    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_german);
        ButterKnife.bind(this);

        namaTempat = getResources().getStringArray(R.array.tempat_rekreasi);
        detailTempat = getResources().getStringArray(R.array.detail_tempat);
        gambarTempat = new int[]{R.drawable.brandenburggate,R.drawable.holstentor,R.drawable.oktoberfest,R.drawable.derkonigsstuhl,R.drawable.neuschwanstein,R.drawable.heidelbergoldcity,R.drawable.lindau,R.drawable.reihn};

        adapter = new Adapter(RecycleGerman.this, gambarTempat, namaTempat, detailTempat);
        myRecycleGerman.setHasFixedSize(true);
        myRecycleGerman.setLayoutManager(new LinearLayoutManager(RecycleGerman.this));
        myRecycleGerman.setAdapter(adapter);

    }
}
