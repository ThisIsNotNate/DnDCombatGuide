package com.example.dndcombatguide;

public class Armor {

    public enum ArmorType{LIGHT,MEDIUM,HEAVY};

    private ArmorType type;
    private int strReq;
    private boolean stealthy;
    private String name, ac;

    public Armor(String name, String ac, int strReq, boolean stealthy, ArmorType type){
        this.name = name;
        this.ac = ac;
        this.strReq = strReq;
        this.stealthy = stealthy;
        this.type = type;
    }

    public String toString(){
        return "Type: " + type +"\tName: " + name + "\tAC: "
                + ac + "\tStrength Requirement: " + strReq
                + "\tStealth Disadvantage: " + stealthy;

    }

    public String getAc() {
        return ac;
    }

    public int getStrReq() {
        return strReq;
    }

    public boolean isStealthy() {
        return stealthy;
    }

    public String getName() {
        return name;
    }

    public String getType(){
        switch(type){
            case LIGHT: return " (Light Armor)";
            case MEDIUM: return  " (Medium Armor)";
            case HEAVY: return  " (Heavy Armor)";
        }
        return "";
    }
}


