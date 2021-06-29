package com.example.myapplication;

public class Hero {

    //int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    String name,team;

    public Hero(){

    }

    public Hero(String name,String team){
        this.name = name;
        this.team = team;
    }


    /*public Hero(int img_team, String heroname, String heroteam){
        this.image = img_team;
        this.name = heroname;
        this.team = heroteam;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }*/


}
