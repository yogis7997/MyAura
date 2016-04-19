package com.seraphicinfosolutions.myaura.Customer.holder;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.seraphicinfosolutions.myaura.R;

/**
 * Created by seraphicinfosolutions on 4/13/16.
 */
public class RequestedParentViewHolder extends ParentViewHolder {
    private static final float INITIAL_POSITION = 0.0f;
    private static final float ROTATED_POSITION = 180f;
    private static final boolean HONEYCOMB_AND_ABOVE = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    private RelativeLayout rl_main;
    public TextView tv_confirm;


    public RequestedParentViewHolder(View itemView) {
        super(itemView);
        rl_main = (RelativeLayout) itemView.findViewById(R.id.rl_main);
        tv_confirm = (TextView)itemView.findViewById(R.id.tv_confirm);


    }

    @SuppressLint("NewApi")
    @Override
    public void setExpanded(boolean expanded) {
        super.setExpanded(expanded);
        if (!HONEYCOMB_AND_ABOVE) {
            return;
        }

        if (expanded) {
            rl_main.setVisibility(View.VISIBLE);
        } else {
            rl_main.setVisibility(View.GONE);
        }
    }
}