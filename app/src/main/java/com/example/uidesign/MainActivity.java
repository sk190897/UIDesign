package com.example.uidesign;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ListView subjectlistview;
    ProgressBar progressBar;

    List<Subject> mysubjects;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_analysis:
//new screen or intent fired
                    return true;
                case R.id.navigation_tests:
//new screen or intent fired
                    return true;
                case R.id.navigation_doubts:
//new screen or intent fired
                    return true;
                case R.id.navigation_profile:
//new screen or intent fired
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//customizing toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("SelfStudy");

        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        textView = findViewById(R.id.textview);
        progressBar = findViewById(R.id.progressBar);

        mysubjects = new ArrayList<>();
        subjectlistview = findViewById(R.id.mylistview);



        BottomNavigationView navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //adding subjects to the list

        mysubjects.add(new Subject(R.drawable.mentalability, "Mental Ability", "0"));
        mysubjects.add(new Subject(R.drawable.physics, "Physics", "0"));
        mysubjects.add(new Subject(R.drawable.chemistry, "Chemistry", "0.71"));
        mysubjects.add(new Subject(R.drawable.maths, "Mathematics", "0"));


        MyListAdapter myListAdapter = new MyListAdapter(this,R.layout.customlistitem,mysubjects);

        subjectlistview.setAdapter(myListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.actionbaricons, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_item_one) {
             makeToast();
            // Do something
            return true;
        }
        if (id == R.id.action_item_two) {
             makeToast();
            // Do something
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void makeToast(){

        Toast.makeText(this," Coming Soon ",Toast.LENGTH_SHORT).show();
    }

    public void makeUpgrade(View view){
        Toast.makeText(this," You will be upgraded ",Toast.LENGTH_SHORT).show();

    }
}
