package com.example.android.themakers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Miscellaneous_List extends AppCompatActivity {

    ListView lv;

    String[] name={"White House", "Yellow House"
            ,"New Market", "New Buka"
            ,"Computer Building", "Moot Court"};
    int[] images={R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new
            ,R.drawable.bg3_new,R.drawable.bg3_new};
    String[] location={"Opposte Yellow House", "Opposite EcoBank"
            ,"Beside New Buka", "Beside ETF Hall"
            ,"Opposite the Museum", "Beside First Bank Lecture Theatre"};
    String[] description={"", ""
            ,"", ""
            ,"", ""};
    String[] capacity={"","","","","",""};
    double[] latitude={7.518117,7.519750,20,20,7.517693,7.521881};
    double[] longitude={4.528312,4.520833,20,20,4.528282,4.523323};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miscellaneous__list);


        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Miscellaneous");

        lv= (ListView)findViewById(R.id.miscellaneous_list);

        //Adapter
        General_list_Adapter adapter=new General_list_Adapter(this,name,capacity,location,description,latitude,longitude,images);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Miscellaneous_List.this,General_location_display.class);
                intent.putExtra("name",name[position]);
                intent.putExtra("location",location[position]);
                intent.putExtra("description",description[position]);
                intent.putExtra("image",images[position]);
                intent.putExtra("latitude",latitude[position]);
                intent.putExtra("longitude",longitude[position]);
                startActivity(intent);
            }
        });
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





        if (id==R.id.action_search){
            AlertDialog.Builder builder=new AlertDialog.Builder(Miscellaneous_List.this).setCancelable(true);
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
                    Toast.makeText(Miscellaneous_List.this, searchWord, Toast.LENGTH_SHORT).show();
                }
            });

            alertDialog.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
