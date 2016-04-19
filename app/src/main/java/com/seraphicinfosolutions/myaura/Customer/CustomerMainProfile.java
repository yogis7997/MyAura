package com.seraphicinfosolutions.myaura.Customer;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.seraphicinfosolutions.myaura.R;

/**
 * Created by seraphicinfosolutions on 4/13/16.
 */
public class CustomerMainProfile extends AppCompatActivity {

    private Toolbar toolbar;
    private Spinner spinner_city, spinner_state;
    private String city[], state[];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_profile);
        setToolBar();
        spinner_city = (Spinner) findViewById(R.id.spinner_city);
        spinner_state = (Spinner) findViewById(R.id.spinner_state);
        city = getResources().getStringArray(R.array.city);
        spinner_city.getBackground().setColorFilter(getResources().getColor(R.color.text_color), PorterDuff.Mode.SRC_ATOP);
        spinner_state.getBackground().setColorFilter(getResources().getColor(R.color.text_color), PorterDuff.Mode.SRC_ATOP);
        spinner_city.setAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.item_spinner, city));
        spinner_state.setAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.item_spinner, city));
    }

    private void setToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
