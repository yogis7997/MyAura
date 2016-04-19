package com.seraphicinfosolutions.myaura.Customer.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seraphicinfosolutions.myaura.Customer.holder.HolderCustomerNavigation;
import com.seraphicinfosolutions.myaura.R;
import com.seraphicinfosolutions.myaura.Utils.Constants;
import com.seraphicinfosolutions.myaura.listeners.RecyclerViewListener;


public class CustomerNavigationAdapter extends RecyclerView.Adapter<HolderCustomerNavigation> {

    private static final String TAG = "CustomerNavigation";
    private RecyclerViewListener recyclerViewListener;
    private String arr[], arr1[];
    private Activity activity;
    private int i;

    public CustomerNavigationAdapter(Activity activity, RecyclerViewListener recyclerViewListener, int i) {
        this.recyclerViewListener = recyclerViewListener;
        this.activity = activity;
        arr = activity.getResources().getStringArray(R.array.customer_navigation);
        arr1 = activity.getResources().getStringArray(R.array.vendor_navigation);
        this.i = i;

    }

    @Override
    public HolderCustomerNavigation onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_cutomer_nav, parent, false);
        HolderCustomerNavigation holderCustomerNavigation = new HolderCustomerNavigation(view);
        return holderCustomerNavigation;
    }

    @Override
    public void onBindViewHolder(final HolderCustomerNavigation holder, final int position) {
        if (i == 0) {
            holder.tv_navigation.setText(arr[position]);
        } else {
            holder.tv_navigation.setText(arr1[position]);
        }


        if (Constants.SETPRESSED == position) {
            holder.tv_navigation.setPressed(true);
        } else {
            holder.tv_navigation.setPressed(false);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "click");
                holder.tv_navigation.setPressed(true);
                Constants.SETPRESSED = position;
                notifyDataSetChanged();


                if (i == 0) {
                    recyclerViewListener.onClick(v, position, activity.getClass().getSimpleName());
                } else {
                    recyclerViewListener.onClick(v, position, "");
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        if (i == 0) {
            return arr.length;
        } else {
            return arr1.length;
        }

    }
}
