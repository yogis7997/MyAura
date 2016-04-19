package com.seraphicinfosolutions.myaura.Customer.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.seraphicinfosolutions.myaura.R;

/**
 * Created by seraphicinfosolutions on 4/15/16.
 */
public class HolderAbout extends RecyclerView.ViewHolder {

    public TextView tv_about;
    public HolderAbout(View itemView) {
        super(itemView);
        tv_about = (TextView)itemView.findViewById(R.id.tv_about);
    }
}
