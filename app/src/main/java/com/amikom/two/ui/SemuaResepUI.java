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
import android.widget.LinearLayout;
import android.widget.Toast;

import com.amikom.two.R;
import com.amikom.two.adapter.SemuaResepAdapter;
import com.amikom.two.crud.TambahResepActivity;
import com.amikom.two.model.SemuaResep;
import com.amikom.two.room.AppDatabase;
import com.amikom.two.room.SemuaResepRoom;

import java.util.ArrayList;
import java.util.List;

public class SemuaResepUI extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private RecyclerView recyclerView;
    private SemuaResepAdapter SemuaResepAdapter;
    private List<SemuaResep> list = new ArrayList<>();
    private SemuaResepRoom semuaresepRoom;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        semuaresepRoom = AppDatabase.db(getContext()).semuaresepRoom();
        list = semuaresepRoom.selectAll();
        SemuaResepAdapter = new SemuaResepAdapter(getContext(), list, this);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ui_semuaresep, container, false);
        recyclerView = view.findViewById(R.id.recycler_semuaresep);
        recyclerView.setAdapter(SemuaResepAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(llm);
        FloatingActionButton fab = view.findViewById(R.id.fab_semuaresep);
        fab.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), TambahResepActivity.class);
        startActivityForResult(intent, 30);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            list.clear();
            list.addAll(semuaresepRoom.selectAll());
            SemuaResepAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        SemuaResep semuaresep = list.get(position);
        Toast.makeText(getContext(), semuaresep.getJudul(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getContext(), TambahResepActivity.class);
        intent.putExtra("id", semuaresep.getId());
        startActivityForResult(intent, 50);
    }
}
