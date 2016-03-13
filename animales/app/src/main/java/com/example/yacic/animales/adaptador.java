package com.example.yacic.animales;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;

import java.util.ArrayList;

/**
 * Created by Yacic on 10/02/2016.
 */
public class adaptador extends BaseAdapter{
    Context mContext;
    ArrayList<Animal> lista;
    LayoutInflater inflador;

    public adaptador(Context context, ArrayList<Animal> lista) {
        mContext = context;
        this.lista=lista;
        inflador=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position,View convertView, ViewGroup parent){
        convertView=inflador.inflate(R.layout.listabotones,null);
        ImageButton imageButton;

        imageButton= (ImageButton) convertView.findViewById(R.id.imageButton);
        imageButton.setImageResource(lista.get(position).getImagen());

        return convertView;
    }
}
