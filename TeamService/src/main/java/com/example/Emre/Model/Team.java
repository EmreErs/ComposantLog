package com.example.Emre.Model;


import io.swagger.annotations.ApiModelProperty;

public class Team {
    @ApiModelProperty(notes = "Id of Team",name="id",required=true,value="id")

    private int Id;
    @ApiModelProperty(notes = "Name of Team",name="name",required=true,value="name")
    private String Name;
    @ApiModelProperty(notes = "City of Team",name="city",required=true,value="city ")
    private String City;

    public Team(int id, String name, String city) {
        Id = id;
        Name = name;
        City = city;
    }


    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getCity() {
        return City;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCity(String city) {
        City = city;
    }

    @Override
    public String toString() {
        return "Teams{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", City='" + City + '\'' +
                '}';
    }
}
