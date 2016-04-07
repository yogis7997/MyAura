package com.seraphicinfosolutions.myaura.Customer;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.seraphicinfosolutions.myaura.R;


public class CutomerContactDetail extends AppCompatActivity implements View.OnClickListener {
    private Button btn_create;
    private Toolbar toolbar;
    private Spinner spinner_city, spinner_state;
    private String city[],state[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_contact_detail);
        setToolBar();
        initUI();
    }


    private void initUI() {
        btn_create = (Button) findViewById(R.id.btn_create);
        spinner_city = (Spinner)findViewById(R.id.spinner_city);
        spinner_state = (Spinner)findViewById(R.id.spinner_state);
        city = getResources().getStringArray(R.array.city);
        spinner_city.getBackground().setColorFilter(getResources().getColor(R.color.text_color), PorterDuff.Mode.SRC_ATOP);
        spinner_state.getBackground().setColorFilter(getResources().getColor(R.color.text_color), PorterDuff.Mode.SRC_ATOP);
        spinner_city.setAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.item_spinner, city));
        spinner_state.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.item_spinner,city));
        setListener();
    }

    private void setListener() {
        btn_create.setOnClickListener(this);
    }

    private void setToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {
        if (v == btn_create) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
    }
}
