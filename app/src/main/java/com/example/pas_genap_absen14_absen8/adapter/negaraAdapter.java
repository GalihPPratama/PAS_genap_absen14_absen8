package com.example.pas_genap_absen14_absen8.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pas_genap_absen14_absen8.R;
import com.example.pas_genap_absen14_absen8.model.negara;

import java.util.List;

public class negaraAdapter extends RecyclerView.Adapter<negaraAdapter.ViewHolder> {
    private List<negara> Countries;
    private Context context;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country,parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    negara negara = Countries.get(position);
    holder.tvname.setText(negara.getName());
    Glide.with(context)
            .load(negara.getName())
            .into(holder.imgflag);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvname;
        ImageView imgflag;

        public ViewHolder(View itemview) {
            super(itemview);
            tvname = itemview.findViewById(R.id.tvname);
            imgflag = itemview.findViewById(R.id.imgflag);
        }
    }
}
