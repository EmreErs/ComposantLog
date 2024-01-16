package com.example.MatchService.Model;

import io.swagger.annotations.ApiModelProperty;

public class Match {
    @ApiModelProperty(notes = "Id of Match",name="id",required=true,value="id")

    private int Id;
    @ApiModelProperty(notes = "Id of first team",name="team1",required=true,value="team1")

    private int idTeam1;
    @ApiModelProperty(notes = "Name of first team",name="nameteam1",required=true,value="nameteam1")

    private String Team1;
    @ApiModelProperty(notes = "Name of second team",name="nameteam2",required=true,value="nameteam2")

    private String Team2;

    public String getTeam1() {
        return Team1;
    }

    public void setTeam1(String team1) {
        Team1 = team1;
    }

    public String getTeam2() {
        return Team2;
    }

    public void setTeam2(String team2) {
        Team2 = team2;
    }

    @ApiModelProperty(notes = "Id of second team",name="team2",required=true,value="team2")

    private int idTeam2;
    @ApiModelProperty(notes = "Score of first team",name="scoreTeam1",required=true,value="scoreTeam1")

    private int scoreTeam1;
    @ApiModelProperty(notes = "Score of second team",name="scoreTeam2",required=true,value="scoreTeam2")

    private int scoreTeam2;

    public Match(int id, int idTeam1, int idTeam2, int scoreTeam1, int scoreTeam2) {
        Id = id;
        this.idTeam1 = idTeam1;
        this.idTeam2 = idTeam2;
        this.scoreTeam1 = scoreTeam1;
        this.scoreTeam2 = scoreTeam2;
    }

    @Override
    public String toString() {
        return "Match{" +
                "Id=" + Id +
                ", idTeam1=" + idTeam1 +
                ", idTeam2=" + idTeam2 +
                ", scoreTeam1=" + scoreTeam1 +
                ", scoreTeam2=" + scoreTeam2 +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getIdTeam1() {
        return idTeam1;
    }

    public void setIdTeam1(int idTeam1) {
        this.idTeam1 = idTeam1;
    }

    public int getIdTeam2() {
        return idTeam2;
    }

    public void setIdTeam2(int idTeam2) {
        this.idTeam2 = idTeam2;
    }

    public int getScoreTeam1() {
        return scoreTeam1;
    }

    public void setScoreTeam1(int scoreTeam1) {
        this.scoreTeam1 = scoreTeam1;
    }

    public int getScoreTeam2() {
        return scoreTeam2;
    }

    public void setScoreTeam2(int scoreTeam2) {
        this.scoreTeam2 = scoreTeam2;
    }
}
