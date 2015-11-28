package com.example.swisa.todosapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TaskListActivity extends AppCompatActivity {
    // Button addTask;

    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    public static ArrayList<String> titles = new ArrayList<String>();

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        Intent intent = getIntent();
        String taskDescription = intent.getStringExtra(CreateTaskActivity.TASK_DESCRIPTION);

        recyclerView = (RecyclerView) findViewById(R.id.list);
        adapter = new RecyclerViewAdapter(this, getData(taskDescription));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public List<Task> getData(String taskDescription){
        List<Task> data = new ArrayList<>();
        if(taskDescription != null){
            titles.add(taskDescription);
        }
        for(int i = 0; i < titles.size(); i++){
            Task task = new Task();
            task.title = titles.get(i);
            data.add(task);
        }
        return data;
    }

    public void addTask(View view){
        Intent intent = new Intent(this, CreateTaskActivity.class); // this is a reference to the TaskListActivity above
        startActivity(intent);
    }
}
