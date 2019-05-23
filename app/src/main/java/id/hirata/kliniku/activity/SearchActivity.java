package id.hirata.kliniku.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.ArrayList;
import java.util.List;

import id.hirata.kliniku.R;
import id.hirata.kliniku.adapter.KlinikAdapter;
import id.hirata.kliniku.adapter.KlinikBukaAdapter;
import id.hirata.kliniku.adapter.KlinikPopulerAdapter;
import id.hirata.kliniku.adapter.KlinikRekomendasiAdapter;
import id.hirata.kliniku.model.Klinik;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView rvKlinikBuka, rvKlinikPopuler, rvKlinikRekomendasi;
    private KlinikBukaAdapter klinikBukaAdapter;
    private KlinikPopulerAdapter klinikPopulerAdapter;
    private KlinikRekomendasiAdapter klinikRekomendasiAdapter;
    private List<Klinik> klinikList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        rvKlinikBuka = findViewById(R.id.rv_klinik_buka);
        rvKlinikPopuler = findViewById(R.id.rv_klinik_populer);
        rvKlinikRekomendasi = findViewById(R.id.rv_klinik_rekomendasi);

        klinikList = new ArrayList<>();
        klinikBukaAdapter = new KlinikBukaAdapter(this, klinikList);
        klinikPopulerAdapter = new KlinikPopulerAdapter(this, klinikList);
        klinikRekomendasiAdapter = new KlinikRekomendasiAdapter(this, klinikList);

        RecyclerView.LayoutManager mLayoutManagerBuka = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvKlinikBuka.setLayoutManager(mLayoutManagerBuka);
        rvKlinikBuka.setAdapter(klinikBukaAdapter);


        RecyclerView.LayoutManager mLayoutManagerPopuler = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvKlinikPopuler.setLayoutManager(mLayoutManagerPopuler);
        rvKlinikPopuler.setAdapter(klinikPopulerAdapter);

        RecyclerView.LayoutManager mLayoutManagerRekomendasi = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvKlinikRekomendasi.setLayoutManager(mLayoutManagerRekomendasi);
        rvKlinikRekomendasi.setAdapter(klinikRekomendasiAdapter);

        prepareKlinikDummy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_activity_menu, menu);
        return true;
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

        klinikBukaAdapter.notifyDataSetChanged();
        klinikPopulerAdapter.notifyDataSetChanged();
        klinikRekomendasiAdapter.notifyDataSetChanged();
    }
}
