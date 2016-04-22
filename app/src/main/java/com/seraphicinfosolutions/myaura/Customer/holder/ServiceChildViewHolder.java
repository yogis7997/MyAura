package com.seraphicinfosolutions.myaura.Customer.holder;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.seraphicinfosolutions.myaura.R;

import org.w3c.dom.Text;


public class ServiceChildViewHolder extends ChildViewHolder {


    public TextView tv_showless;
    public RecyclerView rv_images;
    public Button btn_request;
    public LinearLayout ll_select;
    public ImageView img_selected;
    public TextView tv_selected;

    public ServiceChildViewHolder(View itemView) {
        super(itemView);
        tv_showless = (TextView) itemView.findViewById(R.id.tv_showless);
        rv_images = (RecyclerView) itemView.findViewById(R.id.rv_images);
        btn_request = (Button)itemView.findViewById(R.id.btn_request);
        ll_select = (LinearLayout)itemView.findViewById(R.id.ll_select);
        img_selected = (ImageView)itemView.findViewById(R.id.img_selected);
        tv_selected = (TextView)itemView.findViewById(R.id.tv_selected);

    }
}
