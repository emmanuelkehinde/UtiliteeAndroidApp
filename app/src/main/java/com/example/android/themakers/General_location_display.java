<<<<<<< HEAD
package com.example.android.themakers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

public class General_location_display extends AppCompatActivity {

    String name;
    String location;

    private ShareActionProvider mShareActionProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general_location_model);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        final Intent intent=getIntent();
        name=intent.getStringExtra("name");
        location=intent.getStringExtra("location");
        String description=intent.getStringExtra("description");
        int image=intent.getIntExtra("image", 0);
        final double latitude=intent.getDoubleExtra("latitude", 0);
        final double longitude=intent.getDoubleExtra("longitude",0);

//        int image=Integer.parseInt(string_image);

        TextView name_text= (TextView) findViewById(R.id.name_text);
        TextView location_text= (TextView) findViewById(R.id.location_text);
        TextView description_text= (TextView) findViewById(R.id.description_text);
        ImageView location_image= (ImageView) findViewById(R.id.location_image);


        if (name_text != null) {
            name_text.setText(name);
        }
        assert location_text != null;
        location_text.setText(location);
        assert description_text != null;
        description_text.setText(description);
        assert location_image != null;
        location_image.setImageResource(image);

        Button button= (Button) findViewById(R.id.buttonViewMap);
        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConnectivityManager conectivtyManager = (ConnectivityManager) getApplicationContext().getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);
                if (conectivtyManager.getActiveNetworkInfo() != null
                        && conectivtyManager.getActiveNetworkInfo().isAvailable()
                        && conectivtyManager.getActiveNetworkInfo().isConnected()) {

                    Intent mapIntent=new Intent(General_location_display.this,MapsActivity.class);
                    mapIntent.putExtra("latitude",latitude);
                    mapIntent.putExtra("longitude",longitude);
                    mapIntent.putExtra("name",name);
                    startActivity(mapIntent);
                } else {
                    Toast.makeText(General_location_display.this, "Please, check your internet connection", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.description, menu);

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
//            AlertDialog.Builder builder=new AlertDialog.Builder(General_location_display.this);
//            builder.setCancelable(false).setMessage("Do you want to proceed to the game?")
//                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Toast.makeText(General_location_display.this, "Game is Opened", Toast.LENGTH_SHORT).show();
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
            AlertDialog.Builder builder=new AlertDialog.Builder(General_location_display.this).setCancelable(true);
            LayoutInflater inflater=getLayoutInflater();
            final View dialogView=inflater.inflate(R.layout.search_layout,null);
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
                    Toast.makeText(General_location_display.this, searchWord, Toast.LENGTH_SHORT).show();
                }
            });

            alertDialog.show();
        }

        if(id==R.id.action_share){
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Hey! I've just found the location of "+name+" ("+location+")"+" using the Student Companion App.";
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share location via"));
        }
        return super.onOptionsItemSelected(item);
    }
}
=======
package com.example.android.themakers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

public class General_location_display extends AppCompatActivity {

    String name;
    String location;

    private ShareActionProvider mShareActionProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general_location_model);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        final Intent intent=getIntent();
        name=intent.getStringExtra("name");
        location=intent.getStringExtra("location");
        String description=intent.getStringExtra("description");
        int image=intent.getIntExtra("image", 0);
        final double latitude=intent.getDoubleExtra("latitude", 0);
        final double longitude=intent.getDoubleExtra("longitude",0);

//        int image=Integer.parseInt(string_image);

        TextView name_text= (TextView) findViewById(R.id.name_text);
        TextView location_text= (TextView) findViewById(R.id.location_text);
        TextView description_text= (TextView) findViewById(R.id.description_text);
        ImageView location_image= (ImageView) findViewById(R.id.location_image);


        if (name_text != null) {
            name_text.setText(name);
        }
        assert location_text != null;
        location_text.setText(location);
        assert description_text != null;
        description_text.setText(description);
        assert location_image != null;
        location_image.setImageResource(image);

        Button button= (Button) findViewById(R.id.buttonViewMap);
        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConnectivityManager conectivtyManager = (ConnectivityManager) getApplicationContext().getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);
                if (conectivtyManager.getActiveNetworkInfo() != null
                        && conectivtyManager.getActiveNetworkInfo().isAvailable()
                        && conectivtyManager.getActiveNetworkInfo().isConnected()) {

                    Intent mapIntent=new Intent(General_location_display.this,MapsActivity.class);
                    mapIntent.putExtra("latitude",latitude);
                    mapIntent.putExtra("longitude",longitude);
                    mapIntent.putExtra("name",name);
                    startActivity(mapIntent);
                } else {
                    Toast.makeText(General_location_display.this, "Please, check your internet connection", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.description, menu);

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
//            AlertDialog.Builder builder=new AlertDialog.Builder(General_location_display.this);
//            builder.setCancelable(false).setMessage("Do you want to proceed to the game?")
//                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Toast.makeText(General_location_display.this, "Game is Opened", Toast.LENGTH_SHORT).show();
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
            AlertDialog.Builder builder=new AlertDialog.Builder(General_location_display.this).setCancelable(true);
            LayoutInflater inflater=getLayoutInflater();
            final View dialogView=inflater.inflate(R.layout.search_layout,null);
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
                    Toast.makeText(General_location_display.this, searchWord, Toast.LENGTH_SHORT).show();
                }
            });

            alertDialog.show();
        }

        if(id==R.id.action_share){
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Hey! I've just found the location of "+name+" ("+location+")"+" using the Student Companion App.";
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share location via"));
        }
        return super.onOptionsItemSelected(item);
    }
}
>>>>>>> 93558684926287160cc8c7f84ba6444ff5f25e26
