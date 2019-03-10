package com.example.dndcombatguide;

import android.content.Context;
import android.util.Log;

import org.json.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class EquipmentParser {


    private ArrayList<Armor> armorList = new ArrayList<Armor>();
    private ArrayList<Weapon> weaponList = new ArrayList<Weapon>();


    public EquipmentParser(Context context){
        String json = readJSON(context);
        //System.out.println(json);
        try {
            JSONObject obj = new JSONObject(json);
            JSONObject armor = obj.getJSONObject("Equipment").getJSONObject("Armor").getJSONObject("Armor List");
            parseArmor(armor);
            JSONObject weapons = obj.getJSONObject("Equipment").getJSONObject("Weapons").getJSONObject("Weapons List");
            parseWeapons(weapons);
        }catch(Exception e){}
    }

    public void parseWeapons(JSONObject weapons){
        try {
            parseWeaponTable(weapons.getJSONObject("Simple Melee Weapons").getJSONObject("table"), Weapon.WeaponType.SIMPLE_MELEE);
            parseWeaponTable(weapons.getJSONObject("Simple Ranged Weapons").getJSONObject("table"), Weapon.WeaponType.SIMPLE_RANGED);
            parseWeaponTable(weapons.getJSONObject("Martial Melee Weapons").getJSONObject("table"), Weapon.WeaponType.MARTIAL_MELEE);
            parseWeaponTable(weapons.getJSONObject("Martial Ranged Weapons").getJSONObject("table"), Weapon.WeaponType.MARTIAL_RANGED);
        }catch(Exception e){}

        for(Weapon a: weaponList){
            Log.i("Weapon",a.toString());
        }
    }

    public void parseWeaponTable(JSONObject table, Weapon.WeaponType type){
        try {
            JSONArray names = table.getJSONArray("Name");
            JSONArray damage = table.getJSONArray("Damage");
            JSONArray properties = table.getJSONArray("Properties");

            for (int i = 0; i < names.length(); i++) {
                weaponList.add(new Weapon(names.getString(i), damage.getString(i), properties.getString(i), type));
            }
        }catch(Exception e){}
    }

    public void parseArmor(JSONObject armor){

        try {
            JSONObject lightTable = armor.getJSONObject("Light Armor").getJSONObject("table");
            JSONObject mediumTable = armor.getJSONObject("Medium Armor").getJSONObject("table");
            JSONObject heavyTable = armor.getJSONObject("Heavy Armor").getJSONObject("table");

            parseArmorTable(lightTable, Armor.ArmorType.LIGHT);
            parseArmorTable(mediumTable, Armor.ArmorType.MEDIUM);
            parseArmorTable(heavyTable, Armor.ArmorType.HEAVY);
        }catch(Exception e){}
        for(Armor a: armorList){
            Log.i("Armor",a.toString());
        }
    }

    public void parseArmorTable(JSONObject table, Armor.ArmorType type){
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> acs = new ArrayList<String>();
        ArrayList<Integer> strReqs = new ArrayList<Integer>();
        ArrayList<Boolean> stealthy = new ArrayList<Boolean>();

        try {
            JSONArray armorNames = table.getJSONArray("Armor");
            JSONArray armorAC = table.getJSONArray("Armor Class (AC)");
            JSONArray armorStealthy = table.getJSONArray("Stealth");
            for (int i = 0; i < armorNames.length(); i++) {
                acs.add(armorAC.getString(i));
                names.add(armorNames.getString(i));
                String isStealthy = armorStealthy.getString(i);
                if (isStealthy.equals("-"))
                    stealthy.add(true);
                else
                    stealthy.add(false);
                strReqs.add(0);
                armorList.add(new Armor(names.get(i), acs.get(i), strReqs.get(i), stealthy.get(i), type));
            }
        }catch(Exception e){}
        names.clear(); acs.clear(); strReqs.clear(); stealthy.clear();
    }

    public String readJSON(Context context){
        String json = null;
        try {
            InputStream is = context.getAssets().open("equipment.json");

            int size = is.available();
            byte[] buffer = new byte[size];

            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
