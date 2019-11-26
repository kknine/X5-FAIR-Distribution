package com.sostainuto.app2.model;

public class Project {
    private long id;
    private String name;
    private long userId;
    private int level;
    private int score;
    private int maxScore;

    public Project(long id, String name, long userId, int level, int score, int maxScore) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.level = level;
        this.score = score;
        this.maxScore = maxScore;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public long getUserId() {
        return userId;
    }
}
