package com.example.dndcombatguide;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.*;

public class SpellParser {
    private ArrayList<Spell> spellList = new ArrayList<Spell>();
    JSONObject classSpells;
    public void main(String args[]){
        try {
            String filename = "spellcasting.json";
            String jsonSpellcasting = readJSON(filename);
            String filename2 = "classes.json";
            String jsonClasses = readJSON(filename2);

            JSONObject spellcasting = new JSONObject(jsonSpellcasting);
            classSpells = spellcasting.getJSONObject("Spellcasting").getJSONObject("Spell Descriptions");

            JSONObject classes = new JSONObject(jsonClasses);
            DndClass bard = parseClass(classes, "Bard");
            DndClass sorcerer = parseClass(classes, "Sorcerer");
            DndClass wizard = parseClass(classes, "Wizard");
            DndClass paladin = parseClass(classes, "Paladin");
            DndClass ranger = parseClass(classes, "Ranger");
            DndClass warlock = parseClass(classes, "Warlock");
            bard.print(1);
            sorcerer.print(5);
            wizard.print(1);
            paladin.print(6);
            ranger.print(3);
            warlock.print(12);
        }catch(Exception e){}
        //parseSpells(spells);
    }

    public DndClass parseClass(JSONObject classes, String name){
        switch(name){
            case "Bard": return parseFullCaster(classes, name);
            case "Wizard": return parseFullCaster(classes, name);
            case "Sorcerer": return parseFullCaster(classes, name);
            case "Cleric": return parseFullCaster(classes, name);
            case "Ranger": return parseHalfCaster(classes, name);
            case "Paladin": return parseHalfCaster(classes, name);
            case "Warlock": return parseWarlock(classes, name);
        }
        return null;
    }

    public DndClass parseFullCaster(JSONObject classes, String name){
        DndClass thisClass = new DndClass(name);
        try {
            JSONObject theclass = classes.getJSONObject(name).getJSONObject("Class Features").getJSONObject("The " + name).getJSONObject("table");
            JSONArray features = theclass.getJSONArray("Features");
            JSONArray cantripsKnown = theclass.getJSONArray("Cantrips Known");
            JSONArray spellsKnown;
            if (name.equals("Bard") || name.equals("Sorcerer"))
                spellsKnown = theclass.getJSONArray("Spells Known");
            else
                spellsKnown = null;
            JSONArray s1 = theclass.getJSONArray("1st");
            JSONArray s2 = theclass.getJSONArray("2nd");
            JSONArray s3 = theclass.getJSONArray("3rd");
            JSONArray s4 = theclass.getJSONArray("4th");
            JSONArray s5 = theclass.getJSONArray("5th");
            JSONArray s6 = theclass.getJSONArray("6th");
            JSONArray s7 = theclass.getJSONArray("7th");
            JSONArray s8 = theclass.getJSONArray("8th");
            JSONArray s9 = theclass.getJSONArray("9th");

            String[] cantrips = new String[20] , spells = new String[20], featureList = new String[20];
            String[][] spellSlots = new String[20][9];
            for(int i = 0; i < 20; i++){
                    spellSlots[i][0] = s1.getString(i);
                    spellSlots[i][1] = s2.getString(i);
                    spellSlots[i][2] = s3.getString(i);
                    spellSlots[i][3] = s4.getString(i);
                    spellSlots[i][4] = s5.getString(i);
                    spellSlots[i][5] = s6.getString(i);
                    spellSlots[i][6] = s7.getString(i);
                    spellSlots[i][7] = s8.getString(i);
                    spellSlots[i][8] = s9.getString(i);
                    cantrips[i] = cantripsKnown.getString(i);
                    if (spellsKnown != null)
                        spells[i] = spellsKnown.getString(i);
                    else
                        spells[i] = "All";
                    featureList[i] = features.getString(i);

            }
            thisClass.setCantripsKnown(cantrips);
            thisClass.setFeatures(featureList);

            thisClass.setSpellsKnown(spells);
            thisClass.setSpellSlots(spellSlots);
        } catch(Exception e){}
        return thisClass;
    }

    public DndClass parseHalfCaster(JSONObject classes, String name){
        DndClass thisClass = new DndClass(name);
        try {
            JSONObject theclass = classes.getJSONObject(name).getJSONObject("Class Features").getJSONObject("The " + name).getJSONObject("table");
            JSONArray features = theclass.getJSONArray("Features");
            JSONArray spellsKnown;
            if (!name.equals("Paladin"))
                spellsKnown = theclass.getJSONArray("Spells Known");
            else
                spellsKnown = null;

            JSONArray s1 = theclass.getJSONArray("1st");
            JSONArray s2 = theclass.getJSONArray("2nd");
            JSONArray s3 = theclass.getJSONArray("3rd");
            JSONArray s4 = theclass.getJSONArray("4th");
            JSONArray s5 = theclass.getJSONArray("5th");


            String[] cantrips = new String[20], spells = new String[20], featureList = new String[20];
            String[][] spellSlots = new String[20][9];
            for (int i = 0; i < 20; i++) {
                spellSlots[i][0] = s1.getString(i);
                spellSlots[i][1] = s2.getString(i);
                spellSlots[i][2] = s3.getString(i);
                spellSlots[i][3] = s4.getString(i);
                spellSlots[i][4] = s5.getString(i);
                spellSlots[i][5] = "-";
                spellSlots[i][6] = "-";
                spellSlots[i][7] = "-";
                spellSlots[i][8] = "-";
                if (spellsKnown != null)
                    spells[i] = spellsKnown.getString(i);
                else
                    spells[i] = "All";
                featureList[i] = features.getString(i);
                cantrips[i] = "None";
            }
            thisClass.setFeatures(featureList);
            thisClass.setCantripsKnown(cantrips);
            thisClass.setSpellsKnown(spells);
            thisClass.setSpellSlots(spellSlots);
        }catch(Exception e){}
        return thisClass;
    }

    public DndClass parseWarlock(JSONObject classes, String name){
        DndClass thisClass = new DndClass(name);
        try {
            JSONObject theclass = classes.getJSONObject(name).getJSONObject("Class Features").getJSONObject("The " + name).getJSONObject("table");
            JSONArray features = theclass.getJSONArray("Features");
            JSONArray cantripsKnown = theclass.getJSONArray("Cantrips Known");
            JSONArray spellsKnown = theclass.getJSONArray("Spells Known");

            JSONArray slotLevel = theclass.getJSONArray("Slot Level");
            JSONArray splSlots = theclass.getJSONArray("Spell Slots");

            String[] cantrips = new String[20], spells = new String[20], featureList = new String[20];
            String[][] spellSlots = new String[20][9];
            for (int i = 0; i < 20; i++) {
                String slotLvl = slotLevel.getString(i);
                int lvl = -1;
                switch (slotLvl) {
                    case "1st":
                        lvl = 1;
                        break;
                    case "2nd":
                        lvl = 2;
                        break;
                    case "3rd":
                        lvl = 3;
                        break;
                    case "4th":
                        lvl = 4;
                        break;
                    case "5th":
                        lvl = 5;
                        break;
                }
                for (int j = 0; j < 9; j++) {
                    if (j == lvl - 1)
                        spellSlots[i][j] = splSlots.getString(i);
                    else
                        spellSlots[i][j] = "-";
                }
                cantrips[i] = cantripsKnown.getString(i);
                if (spellsKnown != null)
                    spells[i] = spellsKnown.getString(i);
                else
                    spells[i] = "All";
                featureList[i] = features.getString(i);
            }
            thisClass.setCantripsKnown(cantrips);
            thisClass.setFeatures(featureList);

            thisClass.setSpellsKnown(spells);
            thisClass.setSpellSlots(spellSlots);
        }catch(Exception e){}
        return thisClass;
    }

    public void parseSpells(JSONObject spells){

    }

    public String readJSON(String filename){
        FileInputStream in = null;
        BufferedReader br = null;
        File input = new File(filename);
        String path = input.getAbsolutePath();
        String json = "";
        try{
            in = new FileInputStream(path);
            br = new BufferedReader(new InputStreamReader(in));

            String line = null;
            while((line = br.readLine()) != null){
                json += line;
            }
            br.close();
        }
        catch(Exception e){
            System.err.println(e + "\nCouldn't read input file. Exiting Program");
            System.exit(3);
        }


        return json;
    }

}

