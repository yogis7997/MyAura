package com.seraphicinfosolutions.myaura.vendor;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.seraphicinfosolutions.myaura.Customer.HomeActivity;
import com.seraphicinfosolutions.myaura.Customer.adapter.ImagesAdapter;
import com.seraphicinfosolutions.myaura.R;


/**
 * Created by seraphicinfosolutions on 4/15/16.
 */
public class BusinessDetailSignUp extends AppCompatActivity implements View.OnClickListener {

    private Spinner spinner_category;
    private Toolbar toolbar;
    private String arr[] = {"Service Category", "Builder", "Cleaner", "Handyman"};
    private RecyclerView rv_work, rv_employee;
    private int[] arr1;
    private ImageView img_add;
    private Button btn_next;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.businessdetail);
        setToolBar();
        initUi();
    }

    private void initUi() {
        spinner_category = (Spinner) findViewById(R.id.sp_category);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv_employee = (RecyclerView) findViewById(R.id.rv_employee);
        rv_work = (RecyclerView) findViewById(R.id.rv_work);
        img_add = (ImageView) findViewById(R.id.img_addemployee);
        btn_next = (Button)findViewById(R.id.btn_next);
        btn_next.setOnClickListener(this);
        img_add.setOnClickListener(this);
        rv_employee.setLayoutManager(layoutManager);
        rv_work.setLayoutManager(layoutManager1);
        rv_employee.setAdapter(new ImagesAdapter(this, arr1));
        rv_work.setAdapter(new ImagesAdapter(this, arr1));
        spinner_category.setAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.item_spinner, arr));
    }

    private void setToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {
        if (v == img_add) {
            Intent intent = new Intent(BusinessDetailSignUp.this, AddEmployee.class);
            startActivity(intent);
        }else if(v==btn_next){
            Intent intent = new Intent(BusinessDetailSignUp.this, HomeActivity.class);
            startActivity(intent);
        }
    }
}
