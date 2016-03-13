package com.example.yacic.adaptador1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Yacic on 13/01/2016.
 */
public class adaptador extends ArrayAdapter<Zona>{

    ArrayList<Zona> lista;

    public adaptador(Context context, ArrayList<Zona> lista) {
        super(context,R.layout.listviewadat ,lista);
        this.lista=lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        //Inflar el listView (Sin datos)
        View objeto = inflater.inflate(R.layout.listviewadat,null);

        TextView nombre= (TextView) objeto.findViewById(R.id.tvNombre);
        TextView descripcion= (TextView) objeto.findViewById(R.id.tvSubNombre);
        ImageView img = (ImageView) objeto.findViewById(R.id.imageView);

        nombre.setText(lista.get(position).getNombre());
        descripcion.setText(lista.get(position).getTextoCorto());
        img.setImageResource(lista.get(position).getImagen());

        return objeto;

    }


}
