package com.sostainuto.app2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sostainuto.app2.model.Project;
import com.sostainuto.app2.model.Task;

import org.w3c.dom.Text;

public class DashboardActivity extends AppCompatActivity {

    public static final String EXTRA_PROJECT_ID = "project_id";
    private Project mProject;
    Server mServer;
    TextView projectNameTV;
    TextView projectScoreTV;
    TextView projectLevelTV;
    TextView updatesTV;
    ProgressBar progressBar;
    long projectId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dashboard);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.dash_toolbar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayShowTitleEnabled(false);
            ab.setDisplayHomeAsUpEnabled(true);
        }
        mServer = Server.getInstance(getApplicationContext());

        long id = getIntent().getLongExtra(EXTRA_PROJECT_ID, 0);
        projectId = id;
        mProject = mServer.getProject(id);
        String updates = mServer.getUpdates(id);
        projectNameTV = findViewById(R.id.dash_name);
        projectLevelTV = findViewById(R.id.dash_level);
        projectScoreTV = findViewById(R.id.dash_score);
        progressBar = findViewById(R.id.dash_prog);
        updatesTV = findViewById(R.id.dash_update);

        projectNameTV.setText(mProject.getName());
        projectLevelTV.setText(String.format("Level: %d", mProject.getLevel()));
        projectScoreTV.setText(String.format("Score %d",mProject.getScore()));
        updatesTV.setText(mServer.getUpdates(id));
        progressBar.setMax(mProject.getMaxScore());;
        progressBar.setProgress(mProject.getScore());
    }

    public void openTasks(View v) {
        Intent i =  new Intent(this, TasksActivity.class);
        i.putExtra(DashboardActivity.EXTRA_PROJECT_ID, projectId);
        startActivity(i);
    }


}
