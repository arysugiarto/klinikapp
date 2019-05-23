package id.hirata.kliniku.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.hirata.kliniku.R;
import id.hirata.kliniku.activity.SearchActivity;
import id.hirata.kliniku.model.Klinik;

public class KlinikRekomendasiAdapter extends RecyclerView.Adapter<KlinikRekomendasiAdapter.MyViewHolder> {

    private SearchActivity mContext;
    private List<Klinik> klinikList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView jenis, nama, alamat, harga, rating, antrian;
        public ImageView gambar;

        public MyViewHolder(View view) {
            super(view);
            jenis = view.findViewById(R.id.tv_jenis_klinik);
            nama = view.findViewById(R.id.tv_nama_klinik);
            alamat = view.findViewById(R.id.tv_alamat_klinik);
            harga = view.findViewById(R.id.tv_harga_klinik);
            rating = view.findViewById(R.id.tv_rating);
            antrian = view.findViewById(R.id.tv_antrian);
            gambar = view.findViewById(R.id.iv_klinik_home);
        }
    }


    public KlinikRekomendasiAdapter(SearchActivity mContext, List<Klinik> klinikList) {
        this.mContext = mContext;
        this.klinikList = klinikList;
    }

    @Override
    public KlinikRekomendasiAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.klinik_item, parent, false);

        return new KlinikRekomendasiAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final KlinikRekomendasiAdapter.MyViewHolder holder, int position) {
        Klinik klinik = klinikList.get(position);
        holder.jenis.setText(klinik.getJenis());
        holder.nama.setText(klinik.getNama());
        holder.alamat.setText(klinik.getAlamat());
        holder.harga.setText("Rp." + Integer.toString(klinik.getHarga()));
        holder.rating.setText("Rating "+ "(" +Double.toString(klinik.getRating()) + ")");
        holder.antrian.setText(Integer.toString(klinik.getAntrian())+ " Antrian");

        Glide.with(mContext).load(klinik.getGambar()).into(holder.gambar);
    }

    @Override
    public int getItemCount (){

            return klinikList.size();

    }

}

