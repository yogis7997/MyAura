package com.seraphicinfosolutions.myaura.vendor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.seraphicinfosolutions.myaura.Customer.adapter.ImagesAdapter;
import com.seraphicinfosolutions.myaura.R;

/**
 * Created by seraphicinfosolutions on 4/15/16.
 */
public class AddEmployee extends AppCompatActivity {
    private RecyclerView rv_work, rv_employee;
    private Toolbar toolbar;
    private int[] arr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        setToolBar();
        initUi();
    }

    private void initUi() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv_work = (RecyclerView) findViewById(R.id.rv_work);
       
        rv_work.setLayoutManager(layoutManager);
        rv_work.setAdapter(new ImagesAdapter(this,arr));
    }

    private void setToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
