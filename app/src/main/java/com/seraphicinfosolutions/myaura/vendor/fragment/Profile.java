package com.seraphicinfosolutions.myaura.vendor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.seraphicinfosolutions.myaura.Customer.adapter.ImagesAdapter;
import com.seraphicinfosolutions.myaura.R;


/**
 * Created by seraphicinfosolutions on 4/18/16.
 */
public class Profile extends Fragment implements View.OnClickListener {


    private View view;
    private Spinner spinner_category;
    private Toolbar toolbar;
    private String arr[] = {"Service Category", "Builder", "Cleaner", "Handyman"};
    private RecyclerView rv_work, rv_employee;
    private int[] arr1;
    private ImageView img_add;
    private Button btn_next;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(container.getContext()).inflate(R.layout.profile, container, false);
        initUi();
        return view;
    }

    private void initUi() {
        spinner_category = (Spinner) view.findViewById(R.id.sp_category);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rv_employee = (RecyclerView) view.findViewById(R.id.rv_employee);
        rv_work = (RecyclerView) view.findViewById(R.id.rv_work);
        img_add = (ImageView) view.findViewById(R.id.img_addemployee);
        btn_next = (Button) view.findViewById(R.id.btn_next);
        btn_next.setOnClickListener(this);
        img_add.setOnClickListener(this);
        rv_employee.setLayoutManager(layoutManager);
        rv_work.setLayoutManager(layoutManager1);
        rv_employee.setAdapter(new ImagesAdapter(getActivity(), arr1));
        rv_work.setAdapter(new ImagesAdapter(getActivity(), arr1));
        spinner_category.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.item_spinner, arr));
    }

    @Override
    public void onClick(View v) {

    }
}
