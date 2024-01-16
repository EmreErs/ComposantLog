package com.example.StatsService.Model;

import io.swagger.annotations.ApiModelProperty;

public class TeamStats {
    @ApiModelProperty(notes = "Id of Team",name="id",required=true,value="id")
    private int teamId;
    @ApiModelProperty(notes = "Point of Team",name="points",required=true,value="points")
    private int points;
    @ApiModelProperty(notes = "Goal Scored by Team",name="goalsScored",required=true,value="goalsScored")
    private int goalsScored;
    @ApiModelProperty(notes = "Goal Conceded by Team",name="goalsConceded",required=true,value="goalsConceded")
    private int goalsConceded;

    public TeamStats(int teamId, int points, int goalsScored, int goalsConceded) {
        this.teamId = teamId;
        this.points = points;
        this.goalsScored = goalsScored;
        this.goalsConceded = goalsConceded;
    }

    @Override
    public String toString() {
        return "Statistique{" +
                "teamId=" + teamId +
                ", points=" + points +
                ", goalsScored=" + goalsScored +
                ", goalsConceded=" + goalsConceded +
                '}';
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }
}
