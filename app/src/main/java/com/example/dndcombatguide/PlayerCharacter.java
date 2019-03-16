package com.example.dndcombatguide;

public class PlayerCharacter {
    String name;
    private String level;
    private String str;
    private String dex;
    private String con;
    private String intel;
    private String wis;
    private String cha;
    private String prof_bonus;
    private String ac;
    private String initiative;
    private String speed;

    //Class class;
    //Race race;
    public PlayerCharacter(){
        level = "1";
        str = dex = con = intel = wis = cha = "10";
        prof_bonus = "2";
        ac = "10";
        initiative = "10";
        speed = "30";
    }

    public void setLevel(String level){
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void setDex(String dex) {
        this.dex = dex;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public void setIntel(String intel) {
        this.intel = intel;
    }

    public void setWis(String wis) {
        this.wis = wis;
    }

    public void setCha(String cha) {
        this.cha = cha;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public String getStr() {
        return str;
    }

    public String getDex() {
        return dex;
    }

    public String getCon() {
        return con;
    }

    public String getIntel() {
        return intel;
    }

    public String getWis() {
        return wis;
    }

    public String getCha() {
        return cha;
    }

    public String getProf_bonus() {
        return prof_bonus;
    }

    public String getAc() {
        return ac;
    }

    public String getInitiative() {
        return initiative;
    }

    public String getSpeed() {
        return speed;
    }
}
