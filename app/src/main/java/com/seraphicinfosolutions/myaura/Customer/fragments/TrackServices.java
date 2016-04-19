package com.seraphicinfosolutions.myaura.Customer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.seraphicinfosolutions.myaura.R;

/**
 * Created by seraphicinfosolutions on 4/15/16.
 */
public class TrackServices extends Fragment implements OnMapReadyCallback {


    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.track_service, container, false);
        return view;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}
