package com.seraphicinfosolutions.myaura.Customer.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.seraphicinfosolutions.myaura.R;

public class HolderImages extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public View itemView;
    public HolderImages(View itemView) {
        super(itemView);
        imageView = (ImageView)itemView.findViewById(R.id.imageview);
        this.itemView = itemView;
    }
}
