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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ProjectsAdapter mAdapter;
    RecyclerView mRecycler;
    Server mServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayShowTitleEnabled(false);
            ab.setDisplayHomeAsUpEnabled(true);
        }
        mServer = Server.getInstance(getApplicationContext());
        final ArrayList<Project> projects = mServer.getProjects();
        mAdapter = new ProjectsAdapter(projects, new OnItemClickListener() {
            @Override
            public void onItemClick(Project project) {
                Intent i = new Intent(MainActivity.this, DashboardActivity.class);
                i.putExtra(DashboardActivity.EXTRA_PROJECT_ID, project.getId());
                startActivity(i);
            }
        });
        mRecycler = (RecyclerView)findViewById(R.id.main_recycler);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecycler.setAdapter(mAdapter);




    }

    public interface OnItemClickListener {
        public void onItemClick(Project project);
    }
}
