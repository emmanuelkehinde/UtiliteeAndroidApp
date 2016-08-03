package com.example.android.themakers;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LocationMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences=this.getSharedPreferences("com.example.android.themakers", Context.MODE_PRIVATE);
        first_time_check();
        setContentView(R.layout.activity_locate_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Locate it!");


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void first_time_check() {
        String check=sharedPreferences.getString("hasLaunched","");

        if(check.equals("")){
            Intent intent=new Intent(getApplicationContext(),OurIntro.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            this.startActivity(intent);
        }
    }

    Intent intent;

    public void nextPage(View view){
        switch (view.getId()){
            case R.id.dept_layout:
                intent=new Intent(this,Dept_List.class);
                break;
            case R.id.hostel_layout:
                intent=new Intent(this,Hostel_List.class);
                break;
            case R.id.lecture_layout:
                intent=new Intent(this,LectureTheatre_List.class);
                break;
            case R.id.food_layout:
                intent=new Intent(this,FoodCanteens_List.class);
                break;
            case R.id.auditorium_layout:
                intent=new Intent(this,Auditorium_List.class);
                break;
            case R.id.admin_layout:
                intent=new Intent(this,Administration_List.class);
                break;
            case R.id.religious_layout:
                intent=new Intent(this,Religious_List.class);
                break;
            case R.id.miscellaneous_layout:
                intent=new Intent(this,Miscellaneous_List.class);
                break;
        }
        startActivity(intent);
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
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
//        if(id==R.id.action_game){
//            AlertDialog.Builder builder=new AlertDialog.Builder(LocationMainActivity.this);
//            builder.setCancelable(false).setMessage("Do you want to proceed to the game?")
//                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Toast.makeText(LocationMainActivity.this, "Game is Opened", Toast.LENGTH_SHORT).show();
//                        }
//                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.cancel();
//                }
//            });
//            AlertDialog alertDialog=builder.create();
//            alertDialog.setTitle("Proceed?");
//            alertDialog.show();
//        }


        if (id==R.id.action_search){
            final AlertDialog.Builder builder=new AlertDialog.Builder(LocationMainActivity.this).setCancelable(true);
            LayoutInflater inflater=getLayoutInflater();
            final View dialogView=inflater.inflate(R.layout.search_layout, null);
            builder.setView(dialogView);

            final AlertDialog alertDialog=builder.create();
            alertDialog.setTitle("Search for places");


            Button searchButton= (Button) dialogView.findViewById(R.id.search_button);
            searchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText editText = (EditText) dialogView.findViewById(R.id.search_text);
                    String searchWord = editText.getText().toString();
                    alertDialog.dismiss();
                    Toast.makeText(LocationMainActivity.this, searchWord, Toast.LENGTH_SHORT).show();
                }
            });

            alertDialog.show();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_locate) {

        } else if (id == R.id.nav_sales) {
//            Intent intent=new Intent(LocationMainActivity.this,SalesActivity.class);
//            startActivity(intent);
        } else if (id == R.id.nav_emergency) {
            Intent intent=new Intent(LocationMainActivity.this,FireMainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            this.startActivity(intent);
        }
        else if (id == R.id.nav_about) {
            AlertDialog.Builder builder=new AlertDialog.Builder(LocationMainActivity.this);
            builder.setCancelable(true).setMessage("Info about the app\n\nDeveloped by The Makers Group, PMCRG'16");
            AlertDialog alertDialog=builder.create();
            alertDialog.setTitle("App Name");
            alertDialog.show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    //    public void saveNames(){
//        Dept_List dept_list=new Dept_List();
//        Search_data_store search_data_store=new Search_data_store();
//        for (String name:dept_list.name){
//            search_data_store.names.add(name);
//        }
//    }
//    public void saveLocation(){
//        Dept_List dept_list=new Dept_List();
//        Search_data_store search_data_store=new Search_data_store();
//        for (String location:dept_list.location){
//            search_data_store.locations.add(location);
//        }
//    }
//    public void saveDescription(){
//        Dept_List dept_list=new Dept_List();
//        Search_data_store search_data_store=new Search_data_store();
//        for (String description:dept_list.description){
//            search_data_store.descriptions.add(description);
//        }
//    }
//    public void saveLatitude(){
//        Dept_List dept_list=new Dept_List();
//        Search_data_store search_data_store=new Search_data_store();
//        for (Double latitude:dept_list.latitude){
//            search_data_store.latitudes.add(latitude);
//        }
//    }
//    public void saveLongitude(){
//        Dept_List dept_list=new Dept_List();
//        Search_data_store search_data_store=new Search_data_store();
//        for (Double longitude:dept_list.longitude){
//            search_data_store.longitudes.add(longitude);
//        }
//    }
//    public void saveImage(){
//        Dept_List dept_list=new Dept_List();
//        Search_data_store search_data_store=new Search_data_store();
//        for (int image:dept_list.images){
//            search_data_store.images.add(image);
//        }
//    }
}

