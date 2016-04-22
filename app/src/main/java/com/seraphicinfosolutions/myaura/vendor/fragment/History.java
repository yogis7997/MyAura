package com.seraphicinfosolutions.myaura.vendor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.seraphicinfosolutions.myaura.R;


public class History extends Fragment {

    private Bundle savedInStanceState;
    private RecyclerView rv_history;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.history,container,false);
        this.savedInStanceState = savedInstanceState;
        initUI();
        return view;
    }

    public void initUI(){
        rv_history = (RecyclerView)view.findViewById(R.id.rv_history);
        rv_history.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
