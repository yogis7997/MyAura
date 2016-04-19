package com.seraphicinfosolutions.myaura.Customer.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.seraphicinfosolutions.myaura.R;

import org.w3c.dom.Text;

/**
 * Created by seraphicinfosolutions on 4/18/16.
 */
public class HolderCustomerNavigation extends RecyclerView.ViewHolder {
    public TextView tv_navigation;
    public HolderCustomerNavigation(View itemView) {
        super(itemView);
        tv_navigation = (TextView)itemView.findViewById(R.id.tv_nav);
    }
}
