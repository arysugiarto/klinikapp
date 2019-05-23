package id.hirata.kliniku.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import id.hirata.kliniku.R;
import id.hirata.kliniku.activity.SearchActivity;
import id.hirata.kliniku.adapter.KlinikAdapter;
import id.hirata.kliniku.model.Klinik;

public class HomeFragment extends Fragment {

    private RecyclerView rvKlinik;
    private KlinikAdapter adapter;
    private List<Klinik> klinikList;
    private CardView cvSearch;
    private Button btnSearch;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        rvKlinik = view.findViewById(R.id.rv_klinik_home);
        cvSearch = view.findViewById(R.id.cv_search);
        btnSearch = view.findViewById(R.id.btn_search);

        klinikList = new ArrayList<>();
        adapter = new KlinikAdapter(this, klinikList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        rvKlinik.setLayoutManager(mLayoutManager);
        rvKlinik.setAdapter(adapter);

        prepareKlinikDummy();

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cari = new Intent(HomeFragment.this.getActivity(), SearchActivity.class);
                startActivity(cari);
            }
        });
        return view;
    }


    private void prepareKlinikDummy() {
        int[] covers = new int[]{
                R.drawable.klinik_dummy,
                R.drawable.klinik,
                R.drawable.klinik1,
                R.drawable.klinik2,
                R.drawable.klinik3};

        Klinik a = new Klinik("Klinik Gigi", "Poliklinik Amanah Raya","Sekeloa Utara No.11",200000, 4.8, 20, covers[0]);
        klinikList.add(a);

        a = new Klinik("Klinik Medis", "Poliklinik Avicena","Tubagus Ismail Raya",140000, 3.0, 14, covers[1]);
        klinikList.add(a);

        a = new Klinik("Klinik Umum", "Prima Medica Hospital","Jalan Raya Sesetan",220000, 5.0, 8, covers[2]);
        klinikList.add(a);

        a = new Klinik("Klinik Medis", "GR Setra Poliklinik","Jalan Jati Utama",180000, 4.1, 12, covers[3]);
        klinikList.add(a);

        a = new Klinik("Klinik Gigi", "GR Jacobus","Jalan Jakarta",360000, 4.4, 19, covers[1]);
        klinikList.add(a);

        adapter.notifyDataSetChanged();
    }



}
