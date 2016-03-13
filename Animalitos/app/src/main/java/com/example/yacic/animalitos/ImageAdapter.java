package com.example.yacic.animalitos;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Yacic on 19/02/2016.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Animal> lista;

    public ImageAdapter(Context c, ArrayList<Animal> lista){
        mContext=c;
        this.lista=lista;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        final ImageView imageView;

        if(convertView==null){
            imageView=new ImageView(mContext);
            imageView.setId(R.id.ivAnimal);
            imageView.setLayoutParams(new GridView.LayoutParams(280, 280));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5, 5, 5, 5);
            imageView.setImageResource(lista.get(position).getImagen());
        }else{
            imageView=(ImageView)convertView;
        }
        return imageView;
    }
}
