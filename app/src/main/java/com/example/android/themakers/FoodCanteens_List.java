<<<<<<< HEAD
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

public class FoodCanteens_List extends AppCompatActivity {

    ListView lv;

    String[] name={"Forks \'n\' Fingers", "Fivers"
            ,"KaysChippy", "Mr. Banwill"
            ,"Spices", "Indulge"
            ,"Guess", "Finger Licks","Risky Joint"};
    int[] images={R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new
            ,R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new};
    String[] location={"Student Union Building", "Student Union Building"
            ,"Beside ODLT 1", "New Buka"
            ,"New Buka", "New Buka"
            ,"New Buka", "New Buka","Opposite Moremi Hall"};
    String[] description={"", ""
            ,"", ""
            ,"", ""
            ,"", "",""};
    String[] capacity={"","","","","","","","",""};
    double[] latitude={7.517956,7.517987,7.519010,7.517010,7.517010,7.517010,7.517010,7.517010,7.520386};
    double[] longitude={4.521459,4.521254,4.521821,4.513730,4.513730,4.513730,4.513730,4.513730,4.517715};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_canteens__list);


        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Food Canteens");

        lv= (ListView)findViewById(R.id.food_list);

        //Adapter
        General_list_Adapter adapter=new General_list_Adapter(this,name,capacity,location,description,latitude,longitude,images);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(FoodCanteens_List.this,General_location_display.class);
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
            AlertDialog.Builder builder=new AlertDialog.Builder(FoodCanteens_List.this).setCancelable(true);
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
                    Toast.makeText(FoodCanteens_List.this, searchWord, Toast.LENGTH_SHORT).show();
                }
            });

            alertDialog.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
=======
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

public class FoodCanteens_List extends AppCompatActivity {

    ListView lv;

    String[] name={"Forks \'n\' Fingers", "Fivers"
            ,"KaysChippy", "Mr. Banwill"
            ,"Spices", "Indulge"
            ,"Guess", "Finger Licks","Risky Joint"};
    int[] images={R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new
            ,R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new};
    String[] location={"Student Union Building", "Student Union Building"
            ,"Beside ODLT 1", "New Buka"
            ,"New Buka", "New Buka"
            ,"New Buka", "New Buka","Opposite Moremi Hall"};
    String[] description={"", ""
            ,"", ""
            ,"", ""
            ,"", "",""};
    String[] capacity={"","","","","","","","",""};
    double[] latitude={7.517956,7.517987,7.519010,7.517010,7.517010,7.517010,7.517010,7.517010,7.520386};
    double[] longitude={4.521459,4.521254,4.521821,4.513730,4.513730,4.513730,4.513730,4.513730,4.517715};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_canteens__list);


        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Food Canteens");

        lv= (ListView)findViewById(R.id.food_list);

        //Adapter
        General_list_Adapter adapter=new General_list_Adapter(this,name,capacity,location,description,latitude,longitude,images);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(FoodCanteens_List.this,General_location_display.class);
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
            AlertDialog.Builder builder=new AlertDialog.Builder(FoodCanteens_List.this).setCancelable(true);
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
                    Toast.makeText(FoodCanteens_List.this, searchWord, Toast.LENGTH_SHORT).show();
                }
            });

            alertDialog.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
>>>>>>> 93558684926287160cc8c7f84ba6444ff5f25e26
