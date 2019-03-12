package com.example.dndcombatguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MakeCharacterEquipment extends AppCompatActivity {
    String[] stats= new String[6];
    String[] equipment= new String[4];
    int[] playerSkills = new int[18];
    String name = null, playerClass, level;

    String[] armorNames;
    String[] weaponNames;

    TextView title;
    Spinner armors, wep1, wep2, wep3;
    ArrayAdapter<String> weaponAdapter;
    ArrayAdapter<String> armorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_character_equipment);
        EquipmentParser ep = new EquipmentParser(this);
        title = findViewById(R.id.textViewEquipmentTitle);
        Bundle extras = getIntent().getExtras();
        name = null;
        if(extras != null) {
            name = extras.getString("name");
            playerClass = extras.getString("class");
            stats = extras.getStringArray("stats");
            level = extras.getString("level");
            playerSkills = extras.getIntArray("skills");

            if(name != null && name != ""){
                String text = "What Armor and Weapons does " + name + " have?";
                title.setText(text);
            }
        }

        armorNames = ep.getArmorNames();
        weaponNames = ep.getWeaponNames();

        armors = findViewById(R.id.spinnerArmor);
        wep1 = findViewById(R.id.spinnerWeapon1);
        wep2 = findViewById(R.id.spinnerWeapon2);
        wep3 = findViewById(R.id.spinnerWeapon3);
        armorAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, armorNames);
        weaponAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, weaponNames);
        armors.setAdapter(armorAdapter);
        wep1.setAdapter(weaponAdapter);
        wep2.setAdapter(weaponAdapter);
        wep3.setAdapter(weaponAdapter);

        Button toSkills = findViewById(R.id.buttonToMakeSkills);
        Button toNext = findViewById(R.id.buttonToMakeNext);

        toSkills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MakeCharacterEquipment.this, MakeCharacterSkills.class);
                getEquipment();
                if(name != null && !name.equals("")) {
                    intent.putExtra("name", name);
                    intent.putExtra("class", playerClass);
                    intent.putExtra("level", level);
                    intent.putExtra("stats", stats);
                    intent.putExtra("skills", playerSkills);
                    intent.putExtra("equipment", equipment);
                    startActivity(intent);
                }
            }
        });

        toNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(); // change when classes made
                if(isSpellcaster())
                    ;//intent = new Intent(MakeCharacterEquipment.this, MakeCharacterSpells.class);
                else
                    ;//intent = new Intent(MakeCharacterEquipment.this, CharacterSheet.class);
                getEquipment();
                if(name != null && !name.equals("")) {
                    intent.putExtra("name", name);
                    intent.putExtra("class", playerClass);
                    intent.putExtra("level", level);
                    intent.putExtra("stats", stats);
                    intent.putExtra("skills", playerSkills);
                    intent.putExtra("equipment", equipment);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean isSpellcaster(){
        if(playerClass.equals("Fighter") || playerClass.equals("Rogue") || playerClass.equals("Barbarian"))
            return false;
        else
            return true;
    }

    public void getEquipment(){
        equipment[0] = armors.getSelectedItem().toString();
        if(wep1.getSelectedItem().toString().equals("------"))
            equipment[1] = "";
        else
            equipment[1] = wep1.getSelectedItem().toString();
        if(wep2.getSelectedItem().toString().equals("------"))
            equipment[2] = "";
        else
            equipment[2] = wep2.getSelectedItem().toString();
        if(wep3.getSelectedItem().toString().equals("------"))
            equipment[3] = "";
        else
            equipment[3] = wep3.getSelectedItem().toString();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Bundle extras = getIntent().getExtras();
        name = null;
        if(extras != null) {
            name = extras.getString("name");
            playerClass = extras.getString("class");
            stats = extras.getStringArray("stats");
            level = extras.getString("level");
            playerSkills = extras.getIntArray("skills");
            equipment = extras.getStringArray("equipment");
            if(name != null && name != ""){
                String text = "What Armor and Weapons does " + name + " have?";
                title.setText(text);
            }
            armors.setSelection(armorAdapter.getPosition(equipment[0]));
            wep1.setSelection(weaponAdapter.getPosition(equipment[1]));
            wep2.setSelection(weaponAdapter.getPosition(equipment[2]));
            wep3.setSelection(weaponAdapter.getPosition(equipment[3]));
        }
    }
}
