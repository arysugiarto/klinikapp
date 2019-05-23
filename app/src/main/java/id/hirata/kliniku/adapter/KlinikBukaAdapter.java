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

public class KlinikBukaAdapter extends RecyclerView.Adapter<KlinikBukaAdapter.MyViewHolder> {

    private SearchActivity mContext;
    private List<Klinik> klinikList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView jenis, nama, alamat;
        public ImageView gambar;

        public MyViewHolder(View view) {
            super(view);
            jenis = view.findViewById(R.id.tv_jenis_klinik);
            nama = view.findViewById(R.id.tv_nama_klinik);
            alamat = view.findViewById(R.id.tv_alamat_klinik);
            gambar = view.findViewById(R.id.iv_klinik_home);
        }
    }


    public KlinikBukaAdapter(SearchActivity mContext, List<Klinik> klinikList) {
        this.mContext = mContext;
        this.klinikList = klinikList;
    }

    @Override
    public KlinikBukaAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.klinik_buka_horizontal_item, parent, false);

        return new KlinikBukaAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final KlinikBukaAdapter.MyViewHolder holder, int position) {
        Klinik klinik = klinikList.get(position);
        holder.jenis.setText(klinik.getJenis());
        holder.nama.setText(klinik.getNama());
        holder.alamat.setText(klinik.getAlamat());

        Glide.with(mContext).load(klinik.getGambar()).into(holder.gambar);
    }

    @Override
    public int getItemCount () {
        return klinikList.size();
    }
}
