package com.seraphicinfosolutions.myaura.Customer;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.seraphicinfosolutions.myaura.Customer.adapter.ImagesAdapter;
import com.seraphicinfosolutions.myaura.Customer.fragments.RequestedQuote;
import com.seraphicinfosolutions.myaura.R;
import com.seraphicinfosolutions.myaura.Utils.Utility;

import org.w3c.dom.Text;

import java.util.Calendar;

public class RequestQuoute extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private RecyclerView rv_images;
    private int[] arr;
    private Spinner sp_request;
    private String arr1[] = {"Request 1", "Request 2"};
    private Dialog dialog;
    private Button btn_sameday, btn_request;
    private TextView tv_fromtime, tv_fromdate, tv_todate, tv_totime;
    private Calendar myCalendar;
    private Utility utility;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_quote);
        initObjects();
        setToolBar();
        initUI();


    }

    private void initObjects() {
        utility = new Utility(this);
    }

    private void setToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.request_quotoe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initUI() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv_images = (RecyclerView) findViewById(R.id.rv_images);
        sp_request = (Spinner) findViewById(R.id.sp_request);
        btn_request = (Button) findViewById(R.id.btn_request);
        btn_sameday = (Button) findViewById(R.id.btn_sameday);
        tv_fromdate = (TextView) findViewById(R.id.tv_fromdate);
        tv_fromtime = (TextView) findViewById(R.id.tv_fromtime);
        tv_todate = (TextView) findViewById(R.id.tv_todate);
        tv_totime = (TextView) findViewById(R.id.tv_totime);
        tv_fromdate.setText(utility.getCurrentDate());
        tv_todate.setText(utility.getCurrentDate());
        tv_totime.setText(utility.getCurrentTime());
        tv_fromtime.setText(utility.getCurrentTime());
        setListener();
        sp_request.setAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.item_spinner, arr1));
        rv_images.setLayoutManager(layoutManager);
        rv_images.setAdapter(new ImagesAdapter(this, arr));
    }

    private void setListener() {
        btn_sameday.setOnClickListener(this);
        btn_request.setOnClickListener(this);
        tv_totime.setOnClickListener(this);
        tv_todate.setOnClickListener(this);
        tv_fromtime.setOnClickListener(this);
        tv_fromdate.setOnClickListener(this);
    }


    public void showDialog(String msg) {


        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_confirmation);
        Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
        ImageView img_cross = (ImageView) dialog.findViewById(R.id.img_cross);
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

    @Override
    public void onClick(View v) {
        if (v == btn_request) {
            showDialog("");
        } else if (v == tv_fromdate) {
            utility.DateDialog(tv_fromdate);
        } else if (v == tv_fromtime) {
            utility.timeDialog(tv_fromtime);
        } else if (v == tv_todate) {
            utility.DateDialog(tv_todate);
        } else if (v == tv_totime) {
            utility.timeDialog(tv_totime);
        }
    }


}
