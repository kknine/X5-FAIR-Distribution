package com.sostainuto.app2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sostainuto.app2.model.Project;
import com.sostainuto.app2.model.Task;

import java.util.ArrayList;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TaskViewHolder> {

    ArrayList<Task> mTasks;
    TasksActivity.OnItemClickListener mListener;
    Context mContext;
    public TasksAdapter(ArrayList<Task> tasks, TasksActivity.OnItemClickListener listener, Context context) {
        mTasks = tasks;
        mListener = listener;
        mContext = context;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        if(position >= getItemCount())
            return;
        holder.bind(mTasks.get(position));

    }

    @Override
    public int getItemCount() {
        if(mTasks == null)
            return 0;
        return mTasks.size();
    }

    class TaskViewHolder extends RecyclerView.ViewHolder {

        TextView nameTV;
        TextView categoryTV;
        View itemView;


        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            nameTV = itemView.findViewById(R.id.lit_name);
            categoryTV = itemView.findViewById(R.id.lit_category);
        }

        public void bind(final Task task) {
            nameTV.setText(task.getName());
            categoryTV.setText(task.getCategory());
            if(task.isSatisfied() != null) {
                if(task.isSatisfied() == true)
                    itemView.setBackgroundColor(mContext.getColor(R.color.green));
                else
                    itemView.setBackgroundColor(mContext.getColor(R.color.red));
            } else {
                itemView.setBackgroundColor(mContext.getColor(R.color.blue));
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemClick(task);
                }
            });
        }
    }
}
