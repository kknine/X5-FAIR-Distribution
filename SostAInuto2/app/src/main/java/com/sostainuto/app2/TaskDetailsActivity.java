package com.sostainuto.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class TaskDetailsActivity extends AppCompatActivity {

    long projectId;
    long taskId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
        projectId = getIntent().getLongExtra(DashboardActivity.EXTRA_PROJECT_ID, 0);
        taskId = getIntent().getLongExtra(TasksActivity.EXTRA_TASK_ID, 0);

        TextView name = (TextView) findViewById(R.id.det_task);
        name.setText("Energy-saving lightbulbs");



    }

    public void onChanged(View v) {
        Switch switcher = (Switch) findViewById(R.id.det_switch);
        LinearLayout layout = findViewById(R.id.det_layout);
        if(switcher.isChecked()) {
            layout.setVisibility(View.GONE);
        } else {
            layout.setVisibility(View.VISIBLE);
        }


    }

    public void getInfo(View v) {
        Intent i = new Intent(this, ApiActivity.class);
        startActivity(i);

    }
}
