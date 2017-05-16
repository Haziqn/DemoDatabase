package com.example.a15017523.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15017523 on 16/5/2017.
 */

public class CustomListViewAdapter extends ArrayAdapter {

    private ArrayList<Task> tasks;
    private Context context;
    int id;
    private TextView textViewID, textViewDesc, textViewDateTime;

    public CustomListViewAdapter(Context context, int resource, ArrayList<Task> objects) {
        super(context, resource, objects);
        // Store the notes that is passed to this adapter
        id = resource;
        tasks = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    public View getView(int i, View convertView, ViewGroup parent) {

        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        textViewID = (TextView) rowView.findViewById(R.id.tvID);
        textViewDesc = (TextView) rowView.findViewById(R.id.tvDesc);
        textViewDateTime = (TextView) rowView.findViewById(R.id.tvDate);

        Task task = tasks.get(i);
        String id = String.valueOf(task.getId());

        textViewID.setText(id);
        textViewDesc.setText(task.getDescription().toString());
        textViewDateTime.setText(task.getDate().toString());

        return rowView;
    }
}
