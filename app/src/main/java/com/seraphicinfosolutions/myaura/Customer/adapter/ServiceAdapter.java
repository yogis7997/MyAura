package com.seraphicinfosolutions.myaura.Customer.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.IntegerRes;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ServiceAdapter extends ExpandableRecyclerAdapter<ServiceParentViewHolder, ServiceChildViewHolder> {
    private LayoutInflater mInflater;
    private Context context;
    int arr[];
    private int count;
    //    public ArrayList<HashMap<Integer, Integer>> arrayList;
    public ArrayList<Integer> arrayList;

    public ServiceAdapter(Context context, List<ParentListItem> parentItemList) {
        super(parentItemList);
        mInflater = LayoutInflater.from(context);
        this.context = context;
        arrayList = new ArrayList<>();
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
    public void onBindChildViewHolder(final ServiceChildViewHolder serviceChildViewHolder, final int position, Object o) {
        serviceChildViewHolder.tv_showless.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServiceFragment.update(position - 1);
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



        serviceChildViewHolder.ll_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (arrayList.size() > 0) {
                    for (Integer i : arrayList) {
                        if (i == position) {
                            arrayList.remove(i);
                        } else {
                            arrayList.add(position);
                        }
                    }
                } else {
                    arrayList.add(position);
                }

                serviceChildViewHolder.tv_selected.setText(context.getResources().getString(R.string.select) + "(" + count + "/3)");
                serviceChildViewHolder.tv_selected.setTextColor(Color.RED);
                serviceChildViewHolder.img_selected.setImageResource(R.drawable.chk);
                notifyDataSetChanged();
                ServiceFragment.showButton();
            }
        });


    }
}
