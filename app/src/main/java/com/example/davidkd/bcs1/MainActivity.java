package com.example.davidkd.bcs1;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.view.LayoutInflater;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.ShareActionProvider;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.davidkd.bcs1.Fragments.AboutBCSFragment;
import com.example.davidkd.bcs1.Fragments.ConsultancyFragment;
import com.example.davidkd.bcs1.Fragments.EventFragment;
import com.example.davidkd.bcs1.Fragments.MembershipFragment;
import com.example.davidkd.bcs1.Fragments.MyAccountFragment;
import com.example.davidkd.bcs1.Fragments.QualificationFragment;
import com.example.davidkd.bcs1.Fragments.TopFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public Toolbar toolbar;

    private ShareActionProvider shareActionProvider;


    private Button test;
    private PopupWindow popWindow;
    private LayoutInflater layoutInflater;
    private RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //set to topFragment by default
        Fragment mainFrag = new TopFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content_pane, mainFrag);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



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
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider)MenuItemCompat.getActionProvider(menuItem);
        setIntent("BCS App", "Enjoying our app, share with your friends ");
        return true;
    }

    private void setIntent(String subject, String text) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, subject);
        i.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id){


            case R.id.about_creators:
                Intent i = new Intent(MainActivity.this, AboutCreatorsActivity.class);
                startActivity(i);
                return true;


        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        toolbar =(Toolbar) findViewById(R.id.toolbar);

        switch (id){
            case R.id.Home:
                toolbar.setTitle("BCS");
                Fragment mainFrag = new TopFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_pane, mainFrag);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack(null);
                ft.commit();
                break;
            case R.id.About_BCS:
                toolbar.setTitle("About Us");
                Fragment aboutBCSFragment = new AboutBCSFragment();
                FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                ft1.replace(R.id.content_pane, aboutBCSFragment);
                ft1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft1.addToBackStack(null);
                ft1.commit();
                break;
            case R.id.Membership:
                toolbar.setTitle("Membership");
                Fragment membershipFragment = new MembershipFragment();
                FragmentTransaction ft2 = getFragmentManager().beginTransaction();
                ft2.replace(R.id.content_pane, membershipFragment);
                ft2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft2.addToBackStack(null);
                ft2.commit();
                break;
            case R.id.Qualifications_and_Certifications:
                toolbar.setTitle("Qualifications");
                Fragment qualificationFragment = new QualificationFragment();
                FragmentTransaction ft3 = getFragmentManager().beginTransaction();
                ft3.replace(R.id.content_pane, qualificationFragment);
                ft3.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft3.addToBackStack(null);
                ft3.commit();
                break;
            case R.id.Consultancies:
                toolbar.setTitle("Consultancies");
                Fragment consultancyFragment = new ConsultancyFragment();
                FragmentTransaction ft4 = getFragmentManager().beginTransaction();
                ft4.replace(R.id.content_pane, consultancyFragment);
                ft4.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft4.addToBackStack(null);
                ft4.commit();
                break;
            case R.id.Events:
                toolbar.setTitle("Events");
                Fragment eventFragment = new EventFragment();
                FragmentTransaction ft5 = getFragmentManager().beginTransaction();
                ft5.replace(R.id.content_pane, eventFragment);
                ft5.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft5.addToBackStack(null);
                ft5.commit();
                break;
           case R.id.account:
                toolbar.setTitle("My Account");
                Fragment accountFragment = new MyAccountFragment();
               FragmentTransaction myAccountFragmentTransaction = getFragmentManager().beginTransaction();
               myAccountFragmentTransaction.replace(R.id.content_pane, accountFragment);
               myAccountFragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
               myAccountFragmentTransaction.addToBackStack(null);
               myAccountFragmentTransaction.commit();
               break;
            case R.id.bcs_west_london_id:
                toolbar.setTitle("BCS West London ");
                Fragment bcsBranchFrag = new BCSBranchFragment();
                FragmentTransaction branchft = getFragmentManager().beginTransaction();
                branchft.replace(R.id.content_pane, bcsBranchFrag);
                branchft.addToBackStack(null);
                branchft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                branchft.commit();
            default:
                break;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
