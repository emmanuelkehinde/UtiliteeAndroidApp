package com.example.android.themakers;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class FireMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_fire);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Emergency");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_fire);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_fire);
        navigationView.setNavigationItemSelectedListener(this);
    }

    Intent call;
    public void callNow(View view){
        int id = view.getId();
        if (id==R.id.call1){
            call=new Intent(Intent.ACTION_CALL);
            call.setData(Uri.parse("tel:08062214241"));
        }
        if (id==R.id.call2){
            call=new Intent(Intent.ACTION_CALL);
            call.setData(Uri.parse("tel:08068572684"));
        }

        startActivity(call);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_fire);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.fire_nav_locate) {
            Intent intent=new Intent(FireMainActivity.this,LocationMainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else if (id == R.id.fire_nav_sales) {
//            Intent intent=new Intent(LocationMainActivity.this,SalesActivity.class);
//            startActivity(intent);
        } else if (id == R.id.fire_nav_emergency) {

        }
        else if (id == R.id.fire_nav_about) {
            AlertDialog.Builder builder=new AlertDialog.Builder(FireMainActivity.this);
            builder.setCancelable(true).setMessage("Info about the app\n\nDeveloped by The Makers Group, PMCRG'16");
            AlertDialog alertDialog=builder.create();
            alertDialog.setTitle("App Name");
            alertDialog.show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_fire);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
