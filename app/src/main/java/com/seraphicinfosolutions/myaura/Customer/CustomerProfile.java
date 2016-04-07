package com.seraphicinfosolutions.myaura.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.seraphicinfosolutions.myaura.R;


public class CustomerProfile extends AppCompatActivity implements View.OnClickListener {

    private Button btn_next;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_profile);
        setToolBar();
        initUI();


    }

    private void initUI() {
        btn_next = (Button) findViewById(R.id.btn_next);
        setListener();
    }

    private void setListener() {
        btn_next.setOnClickListener(this);
    }

    private void setToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {
        if (v == btn_next) {
            Intent intent = new Intent(this, CutomerContactDetail.class);
            startActivity(intent);
        }
    }
}
