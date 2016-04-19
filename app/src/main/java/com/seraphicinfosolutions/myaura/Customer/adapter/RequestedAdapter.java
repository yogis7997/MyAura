package com.seraphicinfosolutions.myaura.Customer.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import com.seraphicinfosolutions.myaura.Customer.RequestQuoute;
import com.seraphicinfosolutions.myaura.Customer.fragments.RequestedQuote;
import com.seraphicinfosolutions.myaura.Customer.holder.RequestedChildViewHolder;
import com.seraphicinfosolutions.myaura.Customer.holder.RequestedParentViewHolder;
import com.seraphicinfosolutions.myaura.Customer.holder.ServiceChildViewHolder;
import com.seraphicinfosolutions.myaura.R;

import java.util.List;
/**
 * Created by seraphicinfosolutions on 4/13/16.
 */
public class RequestedAdapter extends ExpandableRecyclerAdapter<RequestedParentViewHolder, RequestedChildViewHolder> {
    private LayoutInflater mInflater;
    private Context context;
    int arr[];
    private Dialog dialog;

    public RequestedAdapter(Context context, List<ParentListItem> parentItemList) {
        super(parentItemList);
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public com.seraphicinfosolutions.myaura.Customer.holder.RequestedParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.list_item_requested_parent, viewGroup, false);
        return new com.seraphicinfosolutions.myaura.Customer.holder.RequestedParentViewHolder(view);
    }

    @Override
    public RequestedChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.list_item_requested_child, viewGroup, false);
        return new com.seraphicinfosolutions.myaura.Customer.holder.RequestedChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(com.seraphicinfosolutions.myaura.Customer.holder.RequestedParentViewHolder parentViewHolder, int position, ParentListItem parentListItem) {
parentViewHolder.tv_confirm.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        showDialog("");
    }
});
    }


    @Override
    public void onBindChildViewHolder(com.seraphicinfosolutions.myaura.Customer.holder.RequestedChildViewHolder serviceChildViewHolder, final int i, Object o) {
        serviceChildViewHolder.tv_showless.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestedQuote.update(i - 1);
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

        serviceChildViewHolder.tv_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RequestQuoute.class);
               showDialog("");
            }
        });
    }


    public void showDialog(String msg) {


        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_confirmation);
        Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
        ImageView img_cross = (ImageView)dialog.findViewById(R.id.img_cross);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        img_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        try {
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
