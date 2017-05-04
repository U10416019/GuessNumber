package com.example.wenchi.guessnumber;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Eva on 2017/5/1.
 */

public class Adapter extends ArrayAdapter {
    Context c;
    String iconName[];
    int image[];
    int position;
    public Adapter(Context ctx, String[] iconName, int[] image){
        super(ctx,R.layout.model,iconName);
        this.c = ctx;
        this.iconName = iconName;
        this.image = image;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        this.position=position;
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.model,null);
        }

        //TextView name = (TextView) convertView.findViewById(R.id.textView6);
        ImageView img = (ImageView) convertView.findViewById(R.id.imageView);

        //name.setText(iconName[position]);
        img.setImageResource(image[position]);

        return convertView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        this.position=position;
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.model,null);
        }

        //TextView name = (TextView) convertView.findViewById(R.id.textView6);
        ImageView img = (ImageView) convertView.findViewById(R.id.imageView);

        //name.setText(iconName[position]);
        img.setImageResource(image[position]);

        return convertView;
    }

    public int getPosition(){
        return position;
    }

}

