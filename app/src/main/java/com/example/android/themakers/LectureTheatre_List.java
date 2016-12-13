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

public class LectureTheatre_List extends AppCompatActivity {

    ListView lv;

    String[] name={"1000 SLT", "BOOC"
            ,"AUD 1","AUD 2"
            ,"PGCLT", "FirstBank Lecture Theatre"
            ,"CHELT", "ODLT 1","ODLT 2","HSLT C"};
    int[] images={R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new
            ,R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new};
    String[] location={"Beside Moremi Hall", "Department of Microbiology Building"
            ,"Beside the Department of Religious Studies", "Beside the Department of Religious Studies"
            ,"Beside the Museum, behind PG College", "Opposite Faculty of Social Sciences"
            ,"Department of Chemical Engineering", "Amphitheatre Ground Floor"
            ,"Amphitheatre Ground Floor", "College of Health Sciences"};
    String[] description={"", ""
            ,"", ""
            ,"", ""
            ,"", ""
            ,"", ""};
    String[] capacity={"Capacity: 1000","Capacity: 500","Capacity: 350","Capacity: 350",
            "Capacity: 500","Capacity: 500","Capacity: 500","Capacity: 500","Capacity: 500","Capacity: 500"};
    double[] latitude={7.518117,7.519750,20,20,20,20,20,20,20,20};
    double[] longitude={4.528312,4.520833,20,20,20,20,20,20,20,20};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_theatre_list);


        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Lecture Theatres");

        lv= (ListView)findViewById(R.id.lecture_list);

        //Adapter
        General_list_Adapter adapter=new General_list_Adapter(this,name,capacity,location,description,latitude,longitude,images);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(LectureTheatre_List.this,General_location_display.class);
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
            AlertDialog.Builder builder=new AlertDialog.Builder(LectureTheatre_List.this).setCancelable(true);
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
                    Toast.makeText(LectureTheatre_List.this, searchWord, Toast.LENGTH_SHORT).show();
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

public class LectureTheatre_List extends AppCompatActivity {

    ListView lv;

    String[] name={"1000 SLT", "BOOC"
            ,"AUD 1","AUD 2"
            ,"PGCLT", "FirstBank Lecture Theatre"
            ,"CHELT", "ODLT 1","ODLT 2","HSLT C"};
    int[] images={R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new
            ,R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new};
    String[] location={"Beside Moremi Hall", "Department of Microbiology Building"
            ,"Beside the Department of Religious Studies", "Beside the Department of Religious Studies"
            ,"Beside the Museum, behind PG College", "Opposite Faculty of Social Sciences"
            ,"Department of Chemical Engineering", "Amphitheatre Ground Floor"
            ,"Amphitheatre Ground Floor", "College of Health Sciences"};
    String[] description={"", ""
            ,"", ""
            ,"", ""
            ,"", ""
            ,"", ""};
    String[] capacity={"Capacity: 1000","Capacity: 500","Capacity: 350","Capacity: 350",
            "Capacity: 500","Capacity: 500","Capacity: 500","Capacity: 500","Capacity: 500","Capacity: 500"};
    double[] latitude={7.518117,7.519750,20,20,20,20,20,20,20,20};
    double[] longitude={4.528312,4.520833,20,20,20,20,20,20,20,20};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_theatre_list);


        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Lecture Theatres");

        lv= (ListView)findViewById(R.id.lecture_list);

        //Adapter
        General_list_Adapter adapter=new General_list_Adapter(this,name,capacity,location,description,latitude,longitude,images);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(LectureTheatre_List.this,General_location_display.class);
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
            AlertDialog.Builder builder=new AlertDialog.Builder(LectureTheatre_List.this).setCancelable(true);
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
                    Toast.makeText(LectureTheatre_List.this, searchWord, Toast.LENGTH_SHORT).show();
                }
            });

            alertDialog.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
>>>>>>> 93558684926287160cc8c7f84ba6444ff5f25e26
