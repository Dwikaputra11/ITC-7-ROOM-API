package com.example.itc_databaseapiproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.itc_databaseapiproject.model.DataItem;

import java.util.ArrayList;
import java.util.List;

public class LigaAdapter extends RecyclerView.Adapter<LigaAdapter.LigaViewHolder> {


    ArrayList<ListLiga> listLiga;
    ItemClickListener clickListener;
    ArrayList<DetailLiga> listDetailLiga;
    Context context;

//    List<DataItem> dataItems;
    public LigaAdapter(ArrayList<ListLiga> listliga,ArrayList<DetailLiga> listDetailLiga,ItemClickListener clickListener, Context context){
        this.clickListener = clickListener;
        this.listLiga = listliga;
        this.listDetailLiga = listDetailLiga;
        this.context = context;
//        this.dataItems = dataItems;
    }

    @NonNull
    @Override
    public LigaAdapter.LigaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.daftar_liga,parent,false);
        return new LigaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LigaAdapter.LigaViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tvNamaLiga.setText(listLiga.get(position).getNamaLiga());
        holder.tvAbbr.setText(listLiga.get(position).getAbbr());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(listDetailLiga.get(position));
            }
        });

        Glide.with(context)
                .load(listLiga.get(position).getLogoKlub())
                .into(holder.ivLogoKlub);
    }

    @Override
    public int getItemCount() {
        return listLiga.size();
    }

    public class LigaViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaLiga,tvAbbr;
        ImageView ivLogoKlub;
        public LigaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaLiga = itemView.findViewById(R.id.tv_namaLiga);
            tvAbbr = itemView.findViewById(R.id.tv_abbr);
            ivLogoKlub = itemView.findViewById(R.id.iv_logoKlub);

        }
    }

    public interface ItemClickListener {

        void onItemClick(DetailLiga detailLiga);
    }



}
