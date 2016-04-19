package com.seraphicinfosolutions.myaura.Customer.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.seraphicinfosolutions.myaura.R;

/**
 * Created by seraphicinfosolutions on 4/13/16.
 */
public class RequestedChildViewHolder  extends ChildViewHolder {


    public TextView tv_showless,tv_confirm;
    public RecyclerView rv_images;
    public Button btn_request;

    public RequestedChildViewHolder(View itemView) {
        super(itemView);
        tv_showless = (TextView) itemView.findViewById(R.id.tv_showless);
        rv_images = (RecyclerView) itemView.findViewById(R.id.rv_images);
        btn_request = (Button)itemView.findViewById(R.id.btn_request);
        tv_confirm = (TextView)itemView.findViewById(R.id.tv_confirm);

    }
}
