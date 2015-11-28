package com.example.swisa.todosapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class CreateTaskActivity extends AppCompatActivity {

    public static String TASK_DESCRIPTION = "com.example.swisa.todosapp.TASK_DESCRIPTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
    }

    public void createTask(View view){
        Intent intent = new Intent(this, TaskListActivity.class); // this is a reference to the CreateTaskActivity above
        EditText taskDescription = (EditText) findViewById(R.id.description);
        String description = taskDescription.getText().toString();
        intent.putExtra(TASK_DESCRIPTION, description);
        startActivity(intent);
    }

}
