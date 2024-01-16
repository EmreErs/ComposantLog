package com.example.EmrePlayer.Model;

import io.swagger.annotations.ApiModelProperty;

public class Player {
    @ApiModelProperty(notes = "Id of Player",name="id",required=true,value="id")
    private int Id;
    @ApiModelProperty(notes = "Name of Player",name="name",required=true,value="name")
    private String name;
    @ApiModelProperty(notes = "Number of Player",name="number",required=true,value="number")
    private int number;
    @ApiModelProperty(notes = "Poste of Player",name="poste",required=true,value="poste")
    private String poste;
    @ApiModelProperty(notes = "Team of Player",name="teamId",required=true,value="teamId")
    private int teamId;



    @ApiModelProperty(notes = "Team name of Player",name="teamName",required=true,value="teamName")
    private String teamName;

    public Player() {

    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }


    public Player(int id, String name, int number, String poste, int teamId) {
        Id = id;
        this.name = name;
        this.number = number;
        this.poste = poste;
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "Player{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", poste='" + poste + '\'' +
                ", teamId=" + teamId +
                '}';
    }
}
