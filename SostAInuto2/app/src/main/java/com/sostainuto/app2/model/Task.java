package com.sostainuto.app2.model;

public class Task {
    private long id;
    private String name;
    private String category;
    private Boolean satisfied;

    public Task(long id, String name, String category, Boolean satisfied) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.satisfied = satisfied;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Boolean isSatisfied() {
        return satisfied;
    }
}
