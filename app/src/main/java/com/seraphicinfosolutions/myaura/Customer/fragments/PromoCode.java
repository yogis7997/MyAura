package com.seraphicinfosolutions.myaura.Customer.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seraphicinfosolutions.myaura.R;

/**
 * Created by seraphicinfosolutions on 4/15/16.
 */
public class PromoCode extends Fragment {

    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.MyActivityTheme);
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        view = inflater.inflate(R.layout.promocode,container,false);
        return view;
    }
}
