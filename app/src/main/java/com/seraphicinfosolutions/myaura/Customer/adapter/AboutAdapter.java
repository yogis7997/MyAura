package com.seraphicinfosolutions.myaura.Customer.adapter;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seraphicinfosolutions.myaura.Customer.holder.HolderAbout;
import com.seraphicinfosolutions.myaura.R;

/**
 * Created by seraphicinfosolutions on 4/15/16.
 */
public class AboutAdapter extends RecyclerView.Adapter<HolderAbout> {

    public Activity activity;
    public String arr[];

    public AboutAdapter(Activity activity) {
        this.activity = activity;
        arr = activity.getResources().getStringArray(R.array.about);
    }

    @Override
    public HolderAbout onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_about, parent, false);
        HolderAbout holderAbout = new HolderAbout(view);
        return holderAbout;
    }

    @Override
    public void onBindViewHolder(HolderAbout holder, int position) {
        holder.tv_about.setText(arr[position]);
    }

    @Override
    public int getItemCount() {
        return arr.length;
    }
}
