package com.sostainuto.app2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.sostainuto.app2.model.Project;
import com.sostainuto.app2.model.Task;

import java.util.ArrayList;

public class TasksActivity extends AppCompatActivity {

    Server mServer;
    TasksAdapter mAdapter;
    RecyclerView mRecycler;
    public static final String EXTRA_TASK_ID = "task_id";
    long projectId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.tasks_toolbar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayShowTitleEnabled(false);
            ab.setDisplayHomeAsUpEnabled(true);
        }
        long id  = getIntent().getLongExtra(DashboardActivity.EXTRA_PROJECT_ID, 0);
        projectId = id;
        mServer = Server.getInstance(getApplicationContext());
        final ArrayList<Task> tasks = mServer.getTasks(id);
        mAdapter = new TasksAdapter(tasks, new TasksActivity.OnItemClickListener() {
            @Override
            public void onItemClick(Task task) {
                Intent i = new Intent(TasksActivity.this, TaskDetailsActivity.class);
                i.putExtra(DashboardActivity.EXTRA_PROJECT_ID, projectId);
                i.putExtra(EXTRA_TASK_ID, task.getId());
                startActivity(i);
            }
        }, getApplicationContext());
        mRecycler = (RecyclerView)findViewById(R.id.tasks_recycler);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecycler.setAdapter(mAdapter);
    }
    public interface OnItemClickListener {
        void onItemClick(Task task);
    }
}
