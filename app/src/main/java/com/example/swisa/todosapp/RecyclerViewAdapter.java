package com.example.swisa.todosapp;

//import android.support.v7.widget.SearchViewCompatIcs;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by swisa on 28/11/2015.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    List<Task> data = Collections.emptyList();
    public RecyclerViewAdapter(Context context, List<Task> data){
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.task_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Task current = data.get(position);
        holder.title.setText(current.title);
    }

    @Override
    public int getItemCount() {return data.size();}

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        Button button;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.listText);
            button = (Button)itemView.findViewById(R.id.listButton);
        }

    }
}
