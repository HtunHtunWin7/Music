package com.example.lenovo.music;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);

        recyclerView=findViewById(R.id.rec);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        SoungAdapter adapter=new SoungAdapter(getSoung());
        recyclerView.setAdapter(adapter);
       adapter.onClick(new SoungAdapter.buySoung() {
           @Override
           public void customBuySoung(String title, String artist, int price) {
               showCustomMusic(title,artist,price);
           }

           @Override
           public void onBuySoung(Soung soung) {

           }
       });
    }

    ArrayList<Soung> getSoung(){
        ArrayList<Soung> soungs;
        soungs = new ArrayList<Soung>();
        Soung soung=new Soung("Blue Night","Myo Gyi",300);
        soungs.add(soung);
        Soung soung1 = new Soung("Blue Night", "Myo Gyi", 3000);
        soungs.add(soung1);
        Soung soung2 = new Soung("Happy birthday", "G-3", 3000);
        soungs.add(soung2);
        Soung soung3 = new Soung("Best Friends", "Hlwan Paing", 3000);
        soungs.add(soung3);
        Soung soung4 = new Soung("Hard Window", "Black Hole", 3000);
        soungs.add(soung4);
        Soung soung5 = new Soung("See U Again", "Wiz-Khalifer", 3000);
        soungs.add(soung5);
        Soung soung6 = new Soung("Dura", "Daddy Yankee", 3000);
        soungs.add(soung6);
        Soung soung7= new Soung("Honey", "R Zarni", 3000);
        soungs.add(soung7);
        Soung soung8 = new Soung("Missing Music", "Jewel", 3000);
        soungs.add(soung8);
        Soung soung9 = new Soung("Dead lover", "G-Fat", 3000);
        soungs.add(soung9);
        Soung soung10 = new Soung("Miss", "Lay Phyu", 3000);
        soungs.add(soung10);

        return soungs;
    }
    private void showCustomMusic(final String tit, final String art, final int pri)
    {
        Dialog dialog=new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.custom);

         TextView title,artist,price;
        title=dialog.findViewById(R.id.title);
        artist=dialog.findViewById(R.id.artist);
        price=dialog.findViewById(R.id.price);
        Button button=dialog.findViewById(R.id.button);
        title.setText(tit);
        artist.setText(art);
        price.setText(String.valueOf(pri));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Buy the "+tit+" "+art+" by "+pri+"ks", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();

    }
}
