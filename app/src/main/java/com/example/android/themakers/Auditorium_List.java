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

public class Auditorium_List extends AppCompatActivity {

    ListView lv;

    String[] name={"Amphitheatre", "Oduduwa Hall","Cooperative Hall"
            ,"Awovarsity Hall", "Pit Theatre"
            ,"Conference Centre"};
    int[] images={R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new
            ,R.drawable.bg3_new,R.drawable.bg3_new};
    String[] location={"Opposite the Student Union Building", "Opposite the Student Union Building"
            ,"Opposite the Post Office", "Beside the Post Office"
            ,"Department of Dramatic Art","Along Staff Quarters"};
    String[] description={""
            ,"", ""
            ,"", "", ""};
    String[] capacity={"Capacity: 5000","Capacity: 3000","Capacity: 200","Capacity: 500","Capacity: 300","Capacity: 5000"};
    double[] latitude={7.519125,7.519125,7.514032,7.513384,7.521667,7.524188};
    double[] longitude={4.522074,4.522074,4.523599,4.524272,4.521099,4.531170};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auditorium__list);


        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Auditorium");

        lv= (ListView)findViewById(R.id.auditorium_list);

        //Adapter
        General_list_Adapter adapter=new General_list_Adapter(this,name,capacity,location,description,latitude,longitude,images);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Auditorium_List.this,General_location_display.class);
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


        //noinspection SimplifiableIfStatement
//        if(id==R.id.action_game){
//            AlertDialog.Builder builder=new AlertDialog.Builder(Auditorium_List.this);
//            builder.setCancelable(false).setMessage("Do you want to proceed to the game?")
//                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Toast.makeText(Auditorium_List.this, "Game is Opened", Toast.LENGTH_SHORT).show();
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
            AlertDialog.Builder builder=new AlertDialog.Builder(Auditorium_List.this).setCancelable(true);
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
                    Toast.makeText(Auditorium_List.this, searchWord, Toast.LENGTH_SHORT).show();
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

public class Auditorium_List extends AppCompatActivity {

    ListView lv;

    String[] name={"Amphitheatre", "Oduduwa Hall","Cooperative Hall"
            ,"Awovarsity Hall", "Pit Theatre"
            ,"Conference Centre"};
    int[] images={R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new
            ,R.drawable.bg3_new,R.drawable.bg3_new};
    String[] location={"Opposite the Student Union Building", "Opposite the Student Union Building"
            ,"Opposite the Post Office", "Beside the Post Office"
            ,"Department of Dramatic Art","Along Staff Quarters"};
    String[] description={""
            ,"", ""
            ,"", "", ""};
    String[] capacity={"Capacity: 5000","Capacity: 3000","Capacity: 200","Capacity: 500","Capacity: 300","Capacity: 5000"};
    double[] latitude={7.519125,7.519125,7.514032,7.513384,7.521667,7.524188};
    double[] longitude={4.522074,4.522074,4.523599,4.524272,4.521099,4.531170};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auditorium__list);


        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Auditorium");

        lv= (ListView)findViewById(R.id.auditorium_list);

        //Adapter
        General_list_Adapter adapter=new General_list_Adapter(this,name,capacity,location,description,latitude,longitude,images);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Auditorium_List.this,General_location_display.class);
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


        //noinspection SimplifiableIfStatement
//        if(id==R.id.action_game){
//            AlertDialog.Builder builder=new AlertDialog.Builder(Auditorium_List.this);
//            builder.setCancelable(false).setMessage("Do you want to proceed to the game?")
//                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Toast.makeText(Auditorium_List.this, "Game is Opened", Toast.LENGTH_SHORT).show();
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
            AlertDialog.Builder builder=new AlertDialog.Builder(Auditorium_List.this).setCancelable(true);
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
                    Toast.makeText(Auditorium_List.this, searchWord, Toast.LENGTH_SHORT).show();
                }
            });

            alertDialog.show();
        }
        return super.onOptionsItemSelected(item);
    }

}
>>>>>>> 93558684926287160cc8c7f84ba6444ff5f25e26
