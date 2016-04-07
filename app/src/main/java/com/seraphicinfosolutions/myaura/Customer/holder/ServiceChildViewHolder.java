package com.seraphicinfosolutions.myaura.Customer.holder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.seraphicinfosolutions.myaura.R;


public class ServiceChildViewHolder extends ChildViewHolder {
    public TextView mCrimeDateText;
    public CheckBox mCrimeSolvedCheckBox;
    public ServiceChildViewHolder(View itemView) {
        super(itemView);
        mCrimeDateText = (TextView) itemView.findViewById(R.id.child_list_item_crime_date_text_view);
        mCrimeSolvedCheckBox = (CheckBox) itemView.findViewById(R.id.child_list_item_crime_solved_check_box);
    }
}
