package com.seraphicinfosolutions.myaura.Customer.adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.seraphicinfosolutions.myaura.R;

public class ImagesAdapter extends RecyclerView.Adapter<HolderImages> {
    private Dialog dialog;
    private Context context;

    public ImagesAdapter(Context context, int[] arr) {
        this.context = context;
    }

    @Override
    public HolderImages onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_images, parent, false);
        HolderImages holderImages = new HolderImages(view);
        return holderImages;
    }

    @Override
    public void onBindViewHolder(HolderImages holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("");
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public void showDialog(String msg) {
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_addimage);

        ImageView img_cross = (ImageView) dialog.findViewById(R.id.img_cross);

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
