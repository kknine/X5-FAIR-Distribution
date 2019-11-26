package com.sostainuto.app2.model;

public class Issue {
    private long id;
    private String name;
    private String taskId;

    public Issue(long id, String name, String taskId) {
        this.id = id;
        this.name = name;
        this.taskId = taskId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTaskId() {
        return taskId;
    }
}
