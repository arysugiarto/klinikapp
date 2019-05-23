package id.hirata.kliniku.activity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import id.hirata.kliniku.R;
import id.hirata.kliniku.fragment.BookingSelesaiFragment;

public class DetailBookingActivity extends AppCompatActivity  {

    Toolbar toolbar;
    private TextView nama, alamat, jenis, antrian ;
    private ImageView imagev;
    private String sname, salamat, sjenis, santrian ;
    private Button buttonHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_booking);
        toolbar = findViewById(R.id.toolbar_booking_detail);
        toolbar.setTitle("Tiket Booking");
        setSupportActionBar(toolbar);

        buttonHistory = findViewById(R.id.history_booking);


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_booking_detail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();

        sjenis = i.getStringExtra("jenis");
        sname = i.getStringExtra("nama");
        salamat = i.getStringExtra("alamat");
        santrian = i.getStringExtra("antrian");


        jenis = (TextView) findViewById(R.id.tv_jenis_klinik_detail);
        nama = (TextView) findViewById(R.id.tv_nama_klinik_detail);
        alamat = (TextView) findViewById(R.id.tv_alamat_klinik_detail);
        antrian = (TextView) findViewById(R.id.tv_nomor_antrian_detail);

        jenis.setText(sjenis);
        nama.setText(sname);
        alamat.setText(salamat);
        antrian.setText(santrian);

        buttonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailBookingActivity.this, BookingActivity.class);
                startActivity(intent);
            }
        });
    }



}

