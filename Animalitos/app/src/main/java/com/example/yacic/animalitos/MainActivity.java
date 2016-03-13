package com.example.yacic.animalitos;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridview;
    private MediaPlayer mediaPlayer;
    private ArrayList<Animal> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        getLista();
        gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this, lista));


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(mediaPlayer!=null){
                    mediaPlayer.stop();
                }

                mediaPlayer=MediaPlayer.create(getApplication(), lista.get(position).getSonido());
                mediaPlayer.start();
            }
        });

    }

    private ArrayList<Animal> getLista(){
        lista = new ArrayList<Animal>();
        lista.add(new Animal(R.drawable.moo,R.raw.vaca,R.drawable.guauf));
        lista.add(new Animal(R.drawable.guauf,R.raw.vaca,R.drawable.moo));
        return lista;
    }
}
