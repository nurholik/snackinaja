package com.amikom.two.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.amikom.two.R;
import com.amikom.two.model.SemuaResep;

import java.util.List;

public class SemuaResepAdapter extends RecyclerView.Adapter<SemuaResepAdapter.ViewHolder> {
    private Context context;
    private List<SemuaResep> semuaresep;
    private AdapterView.OnItemClickListener listener;

    public SemuaResepAdapter(Context context, List<SemuaResep> semuaresep,
                             AdapterView.OnItemClickListener listener) {
        this.context = context;
        this.semuaresep = semuaresep;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_semuaresep, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        final SemuaResep semuaresep = this.semuaresep.get(i);
        viewHolder.tvJudul.setText(semuaresep.getJudul());
        viewHolder.tvHarga.setText(semuaresep.getHarga());
        viewHolder.tvResep.setText(semuaresep.getResep());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(null, viewHolder.itemView, i, i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return semuaresep.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvJudul;
        public TextView tvHarga;
        public TextView tvResep;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJudul = itemView.findViewById(R.id.semuaresep_tambah_judul);
            tvHarga = itemView.findViewById(R.id.semuaresep_tambah_harga);
            tvResep = itemView.findViewById(R.id.semuaresep_tambah_resep);
        }
    }
}
