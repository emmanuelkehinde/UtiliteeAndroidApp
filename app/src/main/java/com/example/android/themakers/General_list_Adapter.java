package com.example.android.themakers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by KEHINDE on 07-May-16.
 */
public class General_list_Adapter extends ArrayAdapter<String> {

    //Declarations
    int[] imgs={};
    String[] name={};
    String[] location={};
    String[] description={};
    String[] capacity={};
    double[] latitude={};
    double[] longitude={};
    Context c;
    LayoutInflater inflater;


    public General_list_Adapter(Context context, String[] name, String[] capacity, String[] location, String[] description, double[] latitude, double[] longitude, int[] imgs) {
        super(context, R.layout.general_location_list_model,name);
        this.imgs = imgs;
        this.name = name;
        this.capacity=capacity;
        this.location=location;
        this.description=description;
        this.latitude=latitude;
        this.longitude=longitude;
        this.c = context;
    }

    public class ViewHolder{
        TextView name;
        ImageView img;
        TextView location;
        TextView description;
        TextView latitude;
        TextView longitude;
        TextView capacity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            inflater= (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.general_location_list_model,null);
        }

        final ViewHolder holder=new ViewHolder();
        holder.name= (TextView) convertView.findViewById(R.id.model_name);
        holder.img= (ImageView) convertView.findViewById(R.id.model_image);
        holder.location= (TextView) convertView.findViewById(R.id.model_location);
        holder.description= (TextView) convertView.findViewById(R.id.model_description);
        holder.latitude= (TextView) convertView.findViewById(R.id.model_latitude);
        holder.longitude= (TextView) convertView.findViewById(R.id.model_longitude);
        holder.capacity= (TextView) convertView.findViewById(R.id.model_capacity);

        holder.img.setImageResource(imgs[position]);
        holder.name.setText(name[position]);
        holder.capacity.setText(capacity[position]);

        return convertView;
    }
}
