package com.seraphicinfosolutions.myaura.Customer.holder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.seraphicinfosolutions.myaura.R;

import org.w3c.dom.Text;


public class ServiceChildViewHolder extends ChildViewHolder {


    public TextView tv_showless;

    public ServiceChildViewHolder(View itemView) {
        super(itemView);
        tv_showless = (TextView) itemView.findViewById(R.id.tv_showless);


    }
}
