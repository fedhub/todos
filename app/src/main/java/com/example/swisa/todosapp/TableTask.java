package com.example.swisa.todosapp;

import android.provider.BaseColumns;

/**
 * Created by swisa on 12/12/2015.
 */
public class TableTask {
    public TableTask(){

    }

    public static abstract class TableInfo implements BaseColumns{
        public static final String TITLE = "title";
        public static final String DONE = "done";
        public static final String DATABASE_NAME = "task";
        public static final String TABLE_NAME = "task_info";
    }
}
