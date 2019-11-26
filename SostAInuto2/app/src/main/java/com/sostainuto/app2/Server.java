package com.sostainuto.app2;

import android.content.Context;

import com.sostainuto.app2.model.Project;
import com.sostainuto.app2.model.Task;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Server {

    private static Server mInstance;
    private static Context mContext;
    private long hardCodedUserId = 1;
    private Server(Context context) {
        mContext = context;
    }

    public static synchronized Server getInstance(Context context) {
        // If instance is not available, create it. If available, reuse and return the object.
        // ALWAYS supply ApplicationContext to prevent memory leak
        if (mInstance == null) {
            mInstance = new Server(context);
        }
        return mInstance;
    }

    public Project getProject(long id) {
        return getHardCodedProjects().get((int)id-1);
    }

    public ArrayList<Project> getProjects() {
        return getHardCodedProjects();

    }

    public String getUpdates(long projectId) {
        return getHardCodedUpdate();
    }

    public ArrayList<Task> getTasks(long projectId) {
        return getHardCodedTasks();
    }
    public long getCurrentUserId() {
        return hardCodedUserId;
    }

    public ArrayList<Project> getHardCodedProjects() {
        Project project1 = new Project(1, "Organise AI Hackathon for Common Good", hardCodedUserId, 2, 30, 100);
        Project project2 = new Project(2, "Open day at Mathematics Department", hardCodedUserId, 1, 80, 100);
        Project project3 = new Project(3, "Build a shed", hardCodedUserId, 3, 100, 100);
        ArrayList<Project> list = new ArrayList<>();
        list.add(project1);
        list.add(project2);
        list.add(project3);
        return list;
    }

    public String getHardCodedUpdate() {
        return "We have identified a person that might help you with your issue:\nCannot find non-plastic straws \nfor the Task: \nNo plastic utensils. \nClick here to contact them!";
    }

    public ArrayList<Task> getHardCodedTasks() {
        String[] food = mContext.getResources().getStringArray(R.array.food);
        String[] building = mContext.getResources().getStringArray(R.array.building);
        String[] employ = mContext.getResources().getStringArray(R.array.employee);
        String[] transport = mContext.getResources().getStringArray(R.array.travel);
        ArrayList<Task> tasks = new ArrayList<>();
        int cnt = 0;
        for(String fo : food) {
            tasks.add(new Task(cnt, fo, "Food/Catering",((Math.floor(Math.exp(cnt)) % 2)==1)));
            cnt++;
        }
        for(String fo : building) {
            tasks.add(new Task(cnt, fo, "Green Building",(Math.floor(Math.exp(cnt)+1) % 2)==1));
            cnt++;
        }
        for(String fo : employ) {
            tasks.add(new Task(cnt, fo, "Employee Inclusivity",(Math.floor(Math.exp(cnt)) % 2)==1));
            cnt++;
        }
        for(String fo : transport) {
            tasks.add(new Task(cnt, fo, "Travel",(Math.floor(Math.exp(cnt)) % 2)==1));
            cnt++;
        }
        return tasks;
    }

}

