package com.example.swisa.todosapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskListActivity extends AppCompatActivity {
    // Button addTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView listView;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        Intent intent = getIntent();
        String taskDescription = intent.getStringExtra(CreateTaskActivity.TASK_DESCRIPTION);


        // LIST VIEW
        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);
        // Defined Array values to show in ListView
        ArrayList<String> tasks = new ArrayList<String>();
        for(int i = 1; i < 21; i++){
            tasks.add("Task " + i);
        }

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, tasks);
        // Assign adapter to ListView
        listView.setAdapter(adapter);

//        TextView textView = new TextView(this);
//        textView.setTextSize(40);
//        textView.setText(taskDescription);
    }

    public void addTask(View view){
        Intent intent = new Intent(this, CreateTaskActivity.class); // this is a reference to the TaskListActivity above
        startActivity(intent);
    }
}
