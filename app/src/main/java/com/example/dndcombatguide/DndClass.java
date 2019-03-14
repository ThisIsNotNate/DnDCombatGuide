package com.example.dndcombatguide;

import java.util.ArrayList;

public class DndClass {
    private String name;
    private String[] spellsKnown, cantripsKnown, features, profBonus = {"+2","+2","+2","+2","+3","+3","+3","+3","+4","+4","+4","+4","+5","+5","+5","+5","+6","+6","+6","+6"};
    private String[][] spellSlots;
    private ArrayList<Spell> spellList;

    public DndClass(String n){
        name = n;
        spellsKnown = new String[20];
        cantripsKnown = new String[20];


        features = new String[20];
        spellSlots = new String[20][9]; //player level, spell level
        spellList = new ArrayList<Spell>();
    }

    public void print(int level){
        System.out.println("-" + name + " "+ level + ": Cantrips Known: " + cantripsKnown[level-1] + ", Spells Known: " + spellsKnown[level-1]);
        System.out.print("Spell slots: ");
        for(int i = 0; i < 9; i++){
            System.out.print(spellSlots[level-1][i] + " ");
        }
        System.out.println("\nFeatures:");
        for(int i = 0; i < level; i++){
            System.out.println("\t" + features[i]);
        }
        System.out.println();
    }

    public void addSpell(Spell spell){
        spellList.add(spell);
    }

    public String getSpellsKnown(int level) {

        return spellsKnown[level-1];
    }

    public void setSpellsKnown(String[] spellsKnown) {
        this.spellsKnown = spellsKnown;
    }

    public int highestSpellLevel(int level){
        int maxSpellLevel = 1;
        int i = 0;
        while(!spellSlots[level][i].equals("-")){
            maxSpellLevel++;
            i++;
        }
        return maxSpellLevel;
    }

    public String getCantripsKnown(int level) {
        return cantripsKnown[level-1];
    }

    public void setCantripsKnown(String[] cantripsKnown) {
        this.cantripsKnown = cantripsKnown;
    }

    public String[] getSpellSlots(int level) {
        return spellSlots[level-1];
    }

    public void setSpellSlots(String[][] spellSlots) {
        this.spellSlots = spellSlots;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Spell> getSpellList(int level) {
        ArrayList<Spell> currentKnownSpells = new ArrayList<Spell>();
        int highestSpell = highestSpellLevel(level);
        for(Spell s: spellList){
            int spellLevel = -1;
            switch(s.getLevel()){
                case "cantrip": spellLevel = 0; break;
                case "1st-level": spellLevel = 1; break;
                case "2nd-level": spellLevel = 2; break;
                case "3rd-level": spellLevel = 3; break;
                case "4th-level": spellLevel = 4; break;
                case "5th-level": spellLevel = 5; break;
                case "6th-level": spellLevel = 6; break;
                case "7th-level": spellLevel = 7; break;
                case "8th-level": spellLevel = 8; break;
                case "9th-level": spellLevel = 9;
            }
            if(spellLevel <= highestSpell){
                currentKnownSpells.add(s);
            }
        }

        return currentKnownSpells;
    }

    public String[] getFeatures(int level) {
        String[] currentFeatures = new String[level];
        for(int i = 0; i < level; i++){
            currentFeatures[i] = features[i];
        }
        return currentFeatures;
    }

    public void setFeatures(String[] features) {
        this.features = features;
    }

    public String getProfBonus(int level) {
        return profBonus[level-1];
    }


}

