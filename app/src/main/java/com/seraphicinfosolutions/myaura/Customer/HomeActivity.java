package com.seraphicinfosolutions.myaura.Customer;


import android.app.SearchManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.seraphicinfosolutions.myaura.Customer.adapter.CustomerNavigationAdapter;
import com.seraphicinfosolutions.myaura.Customer.fragments.About;
import com.seraphicinfosolutions.myaura.Customer.fragments.FindAService;
import com.seraphicinfosolutions.myaura.Customer.fragments.PromoCode;
import com.seraphicinfosolutions.myaura.Customer.fragments.RequestedQuote;
import com.seraphicinfosolutions.myaura.Customer.fragments.TrackServices;
import com.seraphicinfosolutions.myaura.R;
import com.seraphicinfosolutions.myaura.Utils.Constants;
import com.seraphicinfosolutions.myaura.Utils.Utility;
import com.seraphicinfosolutions.myaura.listeners.RecyclerViewListener;
import com.seraphicinfosolutions.myaura.vendor.MyBusiness;
import com.seraphicinfosolutions.myaura.vendor.fragment.Requests;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, RecyclerViewListener, View.OnClickListener {

    private static final String TAG = "HomeActivity";
    public RecyclerView rv_navigation;
    private Toolbar toolbar;
    private CustomerNavigationAdapter customerNavigationAdapter;
    private Button rl_switch_to_business;
    private int cons = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setToolBar();
        initUI();
        if (Constants.USERTYPE == 0) {
            getSupportActionBar().setTitle(R.string.find_services);
            FindAService findAService = new FindAService();
            changeFragment(findAService);
        } else {
            getSupportActionBar().setTitle(R.string.requests);
            Requests requests = new Requests();
            changeFragment(requests);
        }

    }

    private void initUI() {
        rl_switch_to_business = (Button) findViewById(R.id.switch_to_business);
        rl_switch_to_business.setOnClickListener(this);
    }

    private void setToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.find_services);
        initNavigation();
    }

    private void initNavigation() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        rv_navigation = (RecyclerView) findViewById(R.id.rv_navigation);
        rv_navigation.setLayoutManager(new LinearLayoutManager(this));
        setNavigationAdapter(Constants.USERTYPE);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getHeaderView(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cons == 0) {
                    Intent intent = new Intent(HomeActivity.this, CustomerMainProfile.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(HomeActivity.this, MyBusiness.class);
                    startActivity(intent);
                }

            }
        });
    }

    private void setNavigationAdapter(int i) {
        customerNavigationAdapter = new CustomerNavigationAdapter(this, this, i);
        rv_navigation.setAdapter(customerNavigationAdapter);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {

            final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
            SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

//            search.setSearchableInfo(manager.getSearchableInfo(getComponentName()));
//
//            search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//
//                @Override
//                public boolean onQueryTextSubmit(String query) {
//                    return false;
//                }
//
//                @Override
//                public boolean onQueryTextChange(String query) {
//
////                    loadHistory(query);
//
//                    return true;
//
//                }
//
//            });

        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_findservices) {
            getSupportActionBar().setTitle(R.string.find_services);
            FindAService findAService = new FindAService();
            changeFragment(findAService);
        } else if (id == R.id.nav_requested) {
            getSupportActionBar().setTitle(R.string.requested_quotoes);
            RequestedQuote requestedQuote = new RequestedQuote();
            changeFragment(requestedQuote);
        } else if (id == R.id.nav_trackservice) {
            getSupportActionBar().setTitle(R.string.track_service);
            TrackServices trackServices = new TrackServices();
            changeFragment(trackServices);
        } else if (id == R.id.nav_promocode) {
            getSupportActionBar().setTitle(R.string.promo_code);
            PromoCode promoCode = new PromoCode();
            changeFragment(promoCode);
        } else if (id == R.id.nav_about) {
            getSupportActionBar().setTitle(R.string.about);
            About about = new About();
            changeFragment(about);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void changeFragment(Fragment fragment) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager(); // For AppCompat use getSupportFragmentManager


        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }


    @Override
    public void onClick(View view, int position, String activityName) {

        Log.e(TAG, " name== " + activityName + " name== " + HomeActivity.class.getSimpleName());
        if (activityName.equals(HomeActivity.class.getSimpleName())) {
            if (position == 0) {
                getSupportActionBar().setTitle(R.string.find_services);
                FindAService findAService = new FindAService();
                changeFragment(findAService);
            } else if (position == 1) {
                getSupportActionBar().setTitle(R.string.requested_quotoes);
                RequestedQuote requestedQuote = new RequestedQuote();
                changeFragment(requestedQuote);
            } else if (position == 2) {
                getSupportActionBar().setTitle(R.string.track_service);
                TrackServices trackServices = new TrackServices();
                changeFragment(trackServices);
            } else if (position == 3) {
                getSupportActionBar().setTitle(R.string.promo_code);
                PromoCode promoCode = new PromoCode();
                changeFragment(promoCode);
            } else if (position == 4) {
                new Utility(HomeActivity.this).Share();
            } else if (position == 5) {
                getSupportActionBar().setTitle(R.string.about);
                About about = new About();
                changeFragment(about);
            }


        } else {
            if (position == 0) {
                getSupportActionBar().setTitle(R.string.requests);
                RequestedQuote requestedQuote = new RequestedQuote();
                changeFragment(requestedQuote);
            } else if (position == 1) {
                getSupportActionBar().setTitle(R.string.history);
                RequestedQuote requestedQuote = new RequestedQuote();
                changeFragment(requestedQuote);
            } else if (position == 2) {
                new Utility(HomeActivity.this).Share();
            } else if (position == 3) {
                getSupportActionBar().setTitle(R.string.about);
                About about = new About();
                changeFragment(about);
            }
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onClick(View v) {
        if (cons == 0) {
            setNavigationAdapter(1);
            rl_switch_to_business.setText(R.string.switch_customer);
            getSupportActionBar().setTitle(R.string.requests);
            RequestedQuote requestedQuote = new RequestedQuote();
            changeFragment(requestedQuote);
            cons = 1;
        } else {
            setNavigationAdapter(0);
            rl_switch_to_business.setText(R.string.switch_customer);
            getSupportActionBar().setTitle(R.string.find_services);
            FindAService findAService = new FindAService();
            changeFragment(findAService);
            cons = 0;
        }
    }
}
