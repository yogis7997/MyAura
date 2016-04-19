package com.seraphicinfosolutions.myaura.vendor.fragment;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.seraphicinfosolutions.myaura.R;

/**
 * Created by seraphicinfosolutions on 4/18/16.
 */
public class Description extends Fragment {

    private Spinner spinner_city, spinner_state;
    private String city[], state[];

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_desc,container,false);
        spinner_city = (Spinner) view.findViewById(R.id.spinner_city);
        spinner_state = (Spinner) view.findViewById(R.id.spinner_state);
        city = getResources().getStringArray(R.array.city);
        spinner_city.getBackground().setColorFilter(getResources().getColor(R.color.text_color), PorterDuff.Mode.SRC_ATOP);
        spinner_state.getBackground().setColorFilter(getResources().getColor(R.color.text_color), PorterDuff.Mode.SRC_ATOP);
        spinner_city.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.item_spinner, city));
        spinner_state.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.item_spinner, city));
        return view;
    }

}
