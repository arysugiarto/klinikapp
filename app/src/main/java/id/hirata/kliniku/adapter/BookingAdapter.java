package id.hirata.kliniku.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.hirata.kliniku.R;
import id.hirata.kliniku.activity.BookingActivity;
import id.hirata.kliniku.activity.DetailBookingActivity;
import id.hirata.kliniku.activity.SearchActivity;
import id.hirata.kliniku.fragment.BookingFragment;
import id.hirata.kliniku.fragment.HomeFragment;
import id.hirata.kliniku.model.Klinik;


public class BookingAdapter  extends RecyclerView.Adapter<BookingAdapter.MyViewHolder> {


    private BookingFragment mContext;
    private List<Klinik> klinikList;


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView jenis,nama,rating,antrian,alamat;
        public ImageView gambar;

        public MyViewHolder(@NonNull View view) {
            super(view);
            jenis = view.findViewById(R.id.tv_type_klinik);
            nama = view.findViewById(R.id.tv_nama_klinik_booking);
            alamat = view.findViewById(R.id.tv_alamat_klinik_booking);
            antrian = view.findViewById(R.id.tv_nomor_antrian);
            gambar = view.findViewById(R.id.iv_klinik_booking);
        }
    }
    public BookingAdapter(BookingFragment mContext, List<Klinik> klinikList) {
        this.mContext = mContext;
        this.klinikList = klinikList;
    }


    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_booking, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Klinik klinik = klinikList.get(position);

        holder.jenis.setText(klinik.getJenis());
        holder.nama.setText(klinik.getNama());
        holder.alamat.setText(klinik.getAlamat());
        holder.antrian.setText(Integer.toString(klinik.getAntrian())+ "");
        Glide.with(mContext).load(klinik.getGambar()).into(holder.gambar);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext.getActivity(), DetailBookingActivity.class);
                i.putExtra("jenis",klinik.getJenis());
                i.putExtra("nama",klinik.getNama());
                i.putExtra("alamat",klinik.getAlamat());
                i.putExtra("antrian",klinik.getAntrian());
                mContext.getActivity().startActivity(i);

            }
        });



    }

    @Override
    public int getItemCount() {
        return klinikList.size();
    }
}
