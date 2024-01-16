package com.example.StatsService.Model;

import io.swagger.annotations.ApiModelProperty;

public class PlayerStat {
    @ApiModelProperty(notes = "Id of Player",name="id",required=true,value="id")
    private int playerId;
    @ApiModelProperty(notes = "Goal of player",name="goalsScored",required=true,value="goalsScored")
    private int goalsScored;
    @ApiModelProperty(notes = "Assists of player",name="assists",required=true,value="assists")
    private int assists;
    @ApiModelProperty(notes = "yellow cards of player",name="yellowCards",required=true,value="yellowCards")
    private int yellowCards;
    @ApiModelProperty(notes = "red cards of player",name="redCards",required=true,value="redCards")
    private int redCards;

    public PlayerStat(int playerId, int goalsScored, int assists, int yellowCards, int redCards) {
        this.playerId = playerId;
        this.goalsScored = goalsScored;
        this.assists = assists;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
    }

    @Override
    public String toString() {
        return "PlayerStat{" +
                "playerId=" + playerId +
                ", goalsScored=" + goalsScored +
                ", assists=" + assists +
                ", yellowCards=" + yellowCards +
                ", redCards=" + redCards +
                '}';
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }
}
