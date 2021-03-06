package com.seraphicinfosolutions.myaura.Customer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.seraphicinfosolutions.myaura.Customer.adapter.RequestedAdapter;
import com.seraphicinfosolutions.myaura.Customer.adapter.ServiceAdapter;
import com.seraphicinfosolutions.myaura.Customer.items.Crime;
import com.seraphicinfosolutions.myaura.Customer.items.CrimeChild;
import com.seraphicinfosolutions.myaura.Customer.items.CrimeLab;
import com.seraphicinfosolutions.myaura.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seraphicinfosolutions on 4/13/16.
 */
public class RequestedQuote extends Fragment {
    private RecyclerView recyclerView_service;
    private View view;
    private Bundle savedInStanceState;
    private static RequestedAdapter crimeExpandableAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_service, container, false);
        this.savedInStanceState = savedInstanceState;
        initUI();
        return view;
    }

    private void initUI() {
        recyclerView_service = (RecyclerView) view.findViewById(R.id.crime_recycler_view);
        recyclerView_service = (RecyclerView) view.findViewById(R.id.crime_recycler_view);
        recyclerView_service.setLayoutManager(new LinearLayoutManager(getActivity()));

        crimeExpandableAdapter = new RequestedAdapter(
                getActivity(), generateCrimes());
        crimeExpandableAdapter.onRestoreInstanceState(savedInStanceState);

        recyclerView_service.setAdapter(crimeExpandableAdapter);

    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        ((ServiceAdapter) recyclerView_service.getAdapter()).onSaveInstanceState(outState);
    }

    private List<ParentListItem> generateCrimes() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();
        List<ParentListItem> parentListItems = new ArrayList<>();
        for (Crime crime : crimes) {
            List<CrimeChild> childItemList = new ArrayList<>();
            childItemList.add(new CrimeChild(crime.getDate(), crime.isSolved()));
            crime.setChildItemList(childItemList);
            parentListItems.add(crime);
        }
        return parentListItems;
    }


    public static void update(int pos) {

        try {
            crimeExpandableAdapter.collapseParent(pos);
            crimeExpandableAdapter.notifyItemChanged(pos);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
