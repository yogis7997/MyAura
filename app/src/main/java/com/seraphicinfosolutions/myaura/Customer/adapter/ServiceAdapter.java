package com.seraphicinfosolutions.myaura.Customer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import com.seraphicinfosolutions.myaura.Customer.holder.ServiceChildViewHolder;
import com.seraphicinfosolutions.myaura.Customer.holder.ServiceParentViewHolder;
import com.seraphicinfosolutions.myaura.R;

import java.util.List;


public class ServiceAdapter extends ExpandableRecyclerAdapter<ServiceParentViewHolder, ServiceChildViewHolder> {
    private LayoutInflater mInflater;

    public ServiceAdapter(Context context, List<ParentListItem> parentItemList) {
        super(parentItemList);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ServiceParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.list_item_crime_parent, viewGroup, false);
        return new ServiceParentViewHolder(view);
    }

    @Override
    public ServiceChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.list_item_crime_child, viewGroup, false);
        return new ServiceChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(ServiceParentViewHolder parentViewHolder, int position, ParentListItem parentListItem) {

    }



    @Override
    public void onBindChildViewHolder(ServiceChildViewHolder serviceChildViewHolder, int i, Object o) {

    }
}
