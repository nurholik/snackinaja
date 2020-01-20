package com.amikom.two.ui;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.amikom.two.R;
import com.amikom.two.adapter.FavoritAdapter;
import com.amikom.two.crud.TambahFavoritActivity;
import com.amikom.two.model.Favorit;
import com.amikom.two.room.AppDatabase;
import com.amikom.two.room.FavoritRoom;

import java.util.ArrayList;
import java.util.List;

public class FavoritUI extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    private RecyclerView recyclerView;
    private FavoritAdapter favoritAdapter;
    private List<Favorit> list = new ArrayList<>();
    private FavoritRoom favoritRoom;

    public FavoritUI() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        favoritRoom = AppDatabase.db(getContext()).favoritRoom();
        list = favoritRoom.selectAll();
        favoritAdapter = new FavoritAdapter(getContext(), list, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.ui_favorit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_favorit);
        recyclerView.setAdapter(favoritAdapter);
        RecyclerView.LayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);

        FloatingActionButton fab = view.findViewById(R.id.fab_favorit);
        fab.setOnClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Favorit favorit = list.get(position);
        Toast.makeText(getContext(), favorit.getJudul(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getContext(), TambahFavoritActivity.class);
        intent.putExtra("id", favorit.getId());
        startActivityForResult(intent, 71);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), TambahFavoritActivity.class);
        startActivityForResult(intent, 70);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            list.clear();
            list.addAll(favoritRoom.selectAll());
            favoritAdapter.notifyDataSetChanged();
        }
    }
}
