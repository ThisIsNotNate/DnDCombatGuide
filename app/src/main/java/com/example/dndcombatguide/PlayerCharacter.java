package com.example.dndcombatguide;

public class PlayerCharacter {
    String name;
    private int level;
    private int str;
    private int dex;
    private int con;
    private int intel;
    private int wis;
    private int cha;
    private int prof_bonus;
    private int ac;
    private int initiative;
    private int speed;
    private int maxHP;
    private int currentHP;
    //Class class;
    //Race race;
    public PlayerCharacter(){
        level = 1;
        str = dex = con = intel = wis = cha = 10;
        prof_bonus = 2;
        ac = 10;
        initiative = 0;
        speed = 30;
        maxHP = 10;
        currentHP = 10;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }

    public void setWis(int wis) {
        this.wis = wis;
    }

    public void setCha(int cha) {
        this.cha = cha;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getStr() {
        return str;
    }

    public int getDex() {
        return dex;
    }

    public int getCon() {
        return con;
    }

    public int getIntel() {
        return intel;
    }

    public int getWis() {
        return wis;
    }

    public int getCha() {
        return cha;
    }

    public int getProf_bonus() {
        return prof_bonus;
    }

    public int getAc() {
        return ac;
    }

    public int getInitiative() {
        return initiative;
    }

    public int getSpeed() {
        return speed;
    }
}
