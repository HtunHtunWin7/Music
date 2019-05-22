package com.example.lenovo.music;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SoungAdapter extends RecyclerView.Adapter<SoungAdapter.SoungViewHolder> {
    ArrayList<Soung> soungs;

   /*public void setBuySoung(SoungAdapter.buySoung buySoung) {
        this.buySoung = buySoung;
    }
    public void setcustomBuySoung(SoungAdapter.buySoung customBuySoung){this.buySoung=customBuySoung;}*/

    buySoung buySoung;



    public SoungAdapter(ArrayList<Soung> soungs) {
        this.soungs = soungs;
    }

    @Override
    public SoungViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main,parent,false);
        return new SoungViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SoungViewHolder holder, final int position) {
        holder.price.setText(String.valueOf(soungs.get(position).getPrice()));
        holder.txtTitle.setText(String.valueOf(soungs.get(position).getTitle()));
        holder.txtArtist.setText(String.valueOf(soungs.get(position).getArtist()));
        holder.buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              buySoung.customBuySoung(soungs.get(position).getTitle(),soungs.get(position).getArtist(),soungs.get(position).getPrice());
            }
        });

    }

    @Override
    public int getItemCount() {
        return soungs.size();
    }

    public void onClick(SoungAdapter.buySoung buySoung1){
        this.buySoung=buySoung1;
    }


    public class SoungViewHolder extends RecyclerView.ViewHolder {
     public TextView txtTitle,txtArtist,price;
     public Button buy;
        public SoungViewHolder(View itemView) {
            super(itemView);
            txtTitle=itemView.findViewById(R.id.title);
            txtArtist=itemView.findViewById(R.id.artist);
            price=itemView.findViewById(R.id.price);
            buy=itemView.findViewById(R.id.buy);
        }
    }

    interface buySoung {
        void customBuySoung(String title,String artist,int price);
        void onBuySoung(Soung soung);
    }

    public SoungAdapter(ArrayList<Soung> soungs, SoungAdapter.buySoung buySoung) {
        this.soungs = soungs;
        this.buySoung = buySoung;
    }

    public ArrayList<Soung> getSoungs() {
        return soungs;
    }

    public void setSoungs(ArrayList<Soung> soungs) {
        this.soungs = soungs;
    }

    public SoungAdapter.buySoung getBuySoung() {
        return buySoung;
    }
}
