package com.example.uidesign;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

//this class extends array adapter so that we can customize our list view with our own layout

public class MyListAdapter extends ArrayAdapter<Subject> {

    List<Subject> subjectList;
    ProgressBar progressBar;
    double progress;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public MyListAdapter(Context context, int resource, List<Subject> subjectList) {
        super(context, resource, subjectList);
        this.context = context;
        this.resource = resource;
        this.subjectList = subjectList;

    }

        public View getView ( final int position, @Nullable View convertView,
        @NonNull ViewGroup parent){

            //we need to get the view of the xml for our list item
            //And for this we need a layoutinflater
            LayoutInflater layoutInflater = LayoutInflater.from(context);

            //getting the view
            View view = layoutInflater.inflate(resource, null, false);

            ImageView subjectimageView = view.findViewById(R.id.subjectphoto);
            TextView  subjectName = view.findViewById(R.id.subjectname);
            TextView  progresscount = view.findViewById(R.id.progresscount);
            progressBar = view.findViewById(R.id.progressBar);

            Subject subject = subjectList.get(position);
            progress = Double.parseDouble(subject.getProgress());
            subjectimageView.setImageDrawable(context.getResources().getDrawable(subject.getImage()));
            subjectName.setText(subject.getName());
            progresscount.setText(subject.getProgress()+"%");
            progressBar.setProgress((int) progress);


            return view;
        }

    }

