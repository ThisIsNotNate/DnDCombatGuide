package com.example.dndcombatguide;

public class Spell {
    private String name, levelSchool, range, components, duration, description;

    public Spell(String name, String levelSchool, String range, String components, String duration, String description){
        this.name = name;
        this.levelSchool = levelSchool;
        this.range = range;
        this.components = components;
        this.duration = duration;
        this.description = description;
    }

    public String toString(){
        return name + "\t" + levelSchool + "\t" + range + "\t" + components + "\t" + duration + "\nDescription: " +name + "\n";
    }

    public String getName() {
        return name;
    }

    public String getLevelSchool() {
        return levelSchool;
    }

    public String getRange() {
        return range;
    }

    public String getComponents() {
        return components;
    }

    public String getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }
}
