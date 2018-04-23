package com.angryscarf.recyclerviewapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaime on 4/18/2018.
 */

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder>{
    private ArrayList<Serie> series;

    public static class SeriesViewHolder extends RecyclerView.ViewHolder {
        CardView card;
        TextView name;
        ImageView img;

        public SeriesViewHolder(View itemView) {
            super(itemView);
            card=itemView.findViewById(R.id.card_view);
            name=itemView.findViewById(R.id.name);
            img=itemView.findViewById(R.id.img);
        }
    }

    public SeriesAdapter(ArrayList<Serie> series) {
        this.series = series;
    }

    @Override
    public SeriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview, parent, false);
        return (new SeriesViewHolder((v)));
    }

    @Override
    public void onBindViewHolder(SeriesViewHolder holder, int position) {
        holder.name.setText(series.get(position).getName());
        holder.img.setImageResource(series.get(position).getImg());


        //custom onClickListener to send access the position of the corresponding series
        holder.card.findViewById(R.id.btn_ver).setOnClickListener((new intOnClickListener(position)));


    }
    //custom Listener
    private class intOnClickListener implements View.OnClickListener{
        int pos;
        public intOnClickListener(int pos) {
            this.pos = pos;
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), series.get(pos).getDesc(), Toast.LENGTH_LONG).show();
        }
    }



    @Override
    public int getItemCount() {
        return series.size();
    }
}
