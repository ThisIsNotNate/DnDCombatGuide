package com.example.dndcombatguide;


public class Weapon {
    private String name, damage, properties;
    public enum WeaponType{SIMPLE_MELEE, SIMPLE_RANGED, MARTIAL_MELEE, MARTIAL_RANGED};
    private WeaponType type;

    public Weapon(String name, String damage, String properties, WeaponType wt){
        this.name = name;
        this.damage = damage;
        this.properties = properties;
        this.type = wt;
    }

    public String toString(){
        String wepType = "";
        switch(type){
            case SIMPLE_MELEE: wepType = "Simple Melee";
                break;
            case SIMPLE_RANGED: wepType = "Simple Ranged";
                break;
            case MARTIAL_MELEE: wepType = "Martial Melee";
                break;
            case MARTIAL_RANGED: wepType = "Martial Ranged";
                break;
        }
        return "Type: " + wepType + "\tName: " + name + "\tDamage Die: " + damage + "\tProperties: " + properties;
    }

    public String getName() {
        return name;
    }

    public String getDamage() {
        return damage;
    }

    public String getProperties() {
        return properties;
    }
}

