package id.hirata.kliniku.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import id.hirata.kliniku.R;
import id.hirata.kliniku.activity.DetailBookingActivity;
import id.hirata.kliniku.activity.SearchActivity;
import id.hirata.kliniku.adapter.BookingAdapter;
import id.hirata.kliniku.adapter.KlinikAdapter;
import id.hirata.kliniku.model.Klinik;

/**
 * A simple {@link Fragment} subclass.
*/
public class BookingFragment extends Fragment {

    private RecyclerView rvBooking;
    private ImageView pindah;
    private BookingAdapter adapter;
    private List<Klinik> klinikList;

    public BookingFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_booking, container, false);


        rvBooking = view.findViewById(R.id.rv_klinik_booking);


        klinikList = new ArrayList<>();
        adapter = new BookingAdapter(this, klinikList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        rvBooking.setLayoutManager(mLayoutManager);
        rvBooking.setAdapter(adapter);
        prepareKlinikDummy();

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
