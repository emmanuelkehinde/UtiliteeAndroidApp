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

public class Dept_List extends AppCompatActivity {


    ListView lv;

    String[] name={"Computer Science and Engineering", "Electronics and Electrical Engineering"
            ,"Chemical Engineering", "Mechanical Engineering"
            ,"Civil Engineering", "Agricultural Engineering"
            ,"Material Science Engineering", "Food Science and Technology"};
    int[] images={R.drawable.computer,R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new
                    ,R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new,R.drawable.bg3_new};
    String[] location={"Faculty of Technology Building", "White House Building"
            ,"Behind the Faculty of Technology Building", "Spider Building"
            ,"Spider Building", "Beside the Department of Agricultural Economics"
            ,"Spider Building", "Beside the Department of Chemical Engineering"};
    String[] description={"Offer courses in Computer Engineering, Computer Science with Mathematics" +
            ", Computer Science with Economics", "Offer courses in Electronics as well as Electrical Engineering"
            ,"", ""
            ,"", ""
            ,"", ""};
    String[] capacity={"","","","","","","",""};
    double[] latitude={7.518117,7.519750,7.519561,7.522938,7.522938,7.522857,7.522938,7.519930};
    double[] longitude={4.528312,4.520833,4.527631,4.529086,4.529086,4.528273,4.529086,4.527705};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dept_list);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Departments");

        lv= (ListView)findViewById(R.id.dept_list);

        //Adapter
        General_list_Adapter adapter=new General_list_Adapter(this,name,capacity,location,description,latitude,longitude,images);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Dept_List.this,General_location_display.class);
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
//            AlertDialog.Builder builder=new AlertDialog.Builder(Dept_List.this);
//            builder.setCancelable(false).setMessage("Do you want to proceed to the game?")
//                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Toast.makeText(Dept_List.this, "Game is Opened", Toast.LENGTH_SHORT).show();
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
            AlertDialog.Builder builder=new AlertDialog.Builder(Dept_List.this).setCancelable(true);
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
                    Toast.makeText(Dept_List.this, searchWord, Toast.LENGTH_SHORT).show();
                }
            });

            alertDialog.show();
        }
        return super.onOptionsItemSelected(item);
    }

}
