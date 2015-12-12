package com.example.swisa.todosapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
    Context ctx = this;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        recyclerView = (RecyclerView) findViewById(R.id.list);

        DatabaseOperations DB = new DatabaseOperations(ctx);

        adapter = new RecyclerViewAdapter(this, getData(DB.getInformation(DB)));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public List<Task> getData(Cursor cr) {
        List<Task> data = new ArrayList<>();
        if (cr.moveToFirst()) {
            while (!cr.isAfterLast()) {
                Task task = new Task();
                task.title = cr.getString(cr.getColumnIndex("title"));
                data.add(task);
                cr.moveToNext();
            }
        }
        return data;
    }

    public void addTask(View view){
        Intent intent = new Intent(this, CreateTaskActivity.class); // this is a reference to the TaskListActivity above
        startActivity(intent);
    }

    public void deleteTask(View view){
        DatabaseOperations DB = new DatabaseOperations(ctx);
        DB.deleteTask(DB);
        finish();
        startActivity(getIntent());
    }
}
