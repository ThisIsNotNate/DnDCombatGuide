package com.example.dndcombatguide;

public class Spell {
    private String name, level, school, range, components, duration, description;

    public Spell(String name, String level, String school, String range, String components, String duration, String description){
        this.name = name;
        this.level = level;
        this.school = school;
        this.range = range;
        this.components = components;
        this.duration = duration;
        this.description = description;
    }

    public String toString(){
        return name + "\t" + level + "\t" + school + "\t" + range + "\t" + components + "\t" + duration + "\nDescription: " +name + "\n";
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public String getSchool(){
        return school;
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
