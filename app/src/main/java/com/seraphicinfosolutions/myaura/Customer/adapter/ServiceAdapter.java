package com.seraphicinfosolutions.myaura.Customer.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import com.seraphicinfosolutions.myaura.Customer.RequestQuoute;
import com.seraphicinfosolutions.myaura.Customer.fragments.ServiceFragment;
import com.seraphicinfosolutions.myaura.Customer.holder.ServiceChildViewHolder;
import com.seraphicinfosolutions.myaura.Customer.holder.ServiceParentViewHolder;
import com.seraphicinfosolutions.myaura.R;

import java.util.List;


public class ServiceAdapter extends ExpandableRecyclerAdapter<ServiceParentViewHolder, ServiceChildViewHolder> {
    private LayoutInflater mInflater;
    private Context context;
    int arr[];

    public ServiceAdapter(Context context, List<ParentListItem> parentItemList) {
        super(parentItemList);
        mInflater = LayoutInflater.from(context);
        this.context = context;
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
    public void onBindChildViewHolder(ServiceChildViewHolder serviceChildViewHolder, final int i, Object o) {
        serviceChildViewHolder.tv_showless.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServiceFragment.update(i - 1);
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);

        serviceChildViewHolder.rv_images.setLayoutManager(layoutManager);
        serviceChildViewHolder.rv_images.setAdapter(new ImagesAdapter(context, arr));
        serviceChildViewHolder.btn_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RequestQuoute.class);
                context.startActivity(intent);
            }
        });
    }
}
