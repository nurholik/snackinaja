package com.amikom.two.dao;

import com.amikom.two.model.SemuaResep;

import java.util.ArrayList;
import java.util.List;

public class SemuaResepDAO {
    private List<SemuaResep> list = new ArrayList<>();

    public SemuaResepDAO() {
        list.add(new SemuaResep("Putu ayu", "10000","2 butir telur ayam,1/2 sendok teh sp," +
                "150 gram gula,1/2 sendok teh vanilla"));
        list.add(new SemuaResep("putu ayu","10000","2 butir telur ayam,1/2 sendok teh sp,\" +\n" +
                "                \"150 gram gula,1/2 sendok teh vanilla"));
    }

    public void insert(SemuaResep semuaresep) {
        list.add(semuaresep);
    }

    public void update(int id, SemuaResep semuaresep) {
        SemuaResep old = list.get(id);
        old.setJudul(semuaresep.getJudul());
        old.setHarga(semuaresep.getHarga());
        old.setResep(semuaresep.getResep());
    }

    public void delete(int id) {
        list.remove(id);
    }

    public SemuaResep select(int id) {
        return list.get(id);
    }

    public List<SemuaResep> selectAll() {
        return list;
    }
}
