package com.example.dndcombatguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class MakeCharacterSkills extends AppCompatActivity {
    TextView title;
    ArrayList<CheckBox> skills = new ArrayList<>();
    String[] stats = new String[6];
    String[] equipment= new String[4];
    int[] playerSkills = new int[18];
    String name = null, playerClass, level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_character_skills);

        addSkills();

        Bundle extras = getIntent().getExtras();
        playerClass = null;
        name = null;
        if(extras != null){
            name = extras.getString("name");
            playerClass = extras.getString("class");
            level = extras.getString("level");
        }
        title = findViewById(R.id.textViewSkillsTitle);
        if(name != null && !name.equals("")){
            String text = "What are " + name + "'s strengths?";
            title.setText(text);
        }

        Button toStats = findViewById(R.id.buttonToMakeStats);
        Button toEquipment = findViewById(R.id.buttonToMakeEquipment);

        toStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MakeCharacterSkills.this, MakeCharacterStats.class);
                getSkills();
                intent.putExtra("name", name);
                intent.putExtra("class", playerClass);
                intent.putExtra("level", level);
                intent.putExtra("stats", stats);
                intent.putExtra("skills", playerSkills);
                intent.putExtra("equipment", equipment);

                startActivity(intent);
            }
        });

        toEquipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MakeCharacterSkills.this, MakeCharacterEquipment.class);
                getSkills();
                intent.putExtra("name", name);
                intent.putExtra("class", playerClass);
                intent.putExtra("level", level);
                intent.putExtra("stats", stats);
                intent.putExtra("skills", playerSkills);
                intent.putExtra("equipment", equipment);

                startActivity(intent);
            }
        });
    }

    public void getSkills(){
        for(int i = 0; i < skills.size();i++){
            if(skills.get(i).isChecked())
                playerSkills[i] = 1;
            else
                playerSkills[i] = 0;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        Bundle extras = getIntent().getExtras();
        name = null;
        if(extras != null) {
            name = extras.getString("name");
            playerClass = extras.getString("class");
            level = extras.getString("level");
            stats = extras.getStringArray("stats");
            playerSkills = extras.getIntArray("skills");
            equipment = extras.getStringArray("equipment");
            for(int i = 0; i < playerSkills.length; i++){
                if(playerSkills[i] == 1){
                    skills.get(i).setChecked(true);
                }
                else
                    skills.get(i).setChecked(false);
            }
        }
    }

    public void addSkills(){
        skills.add((CheckBox) findViewById(R.id.checkBoxAth));
        skills.add((CheckBox) findViewById(R.id.checkBoxAcr));
        skills.add((CheckBox) findViewById(R.id.checkBoxSoh));
        skills.add((CheckBox) findViewById(R.id.checkBoxSte));
        skills.add((CheckBox) findViewById(R.id.checkBoxArc));
        skills.add((CheckBox) findViewById(R.id.checkBoxHis));
        skills.add((CheckBox) findViewById(R.id.checkBoxInv));
        skills.add((CheckBox) findViewById(R.id.checkBoxNat));
        skills.add((CheckBox) findViewById(R.id.checkBoxRel));
        skills.add((CheckBox) findViewById(R.id.checkBoxAni));
        skills.add((CheckBox) findViewById(R.id.checkBoxIns));
        skills.add((CheckBox) findViewById(R.id.checkBoxMed));
        skills.add((CheckBox) findViewById(R.id.checkBoxPer));
        skills.add((CheckBox) findViewById(R.id.checkBoxSur));
        skills.add((CheckBox) findViewById(R.id.checkBoxDec));
        skills.add((CheckBox) findViewById(R.id.checkBoxInt));
        skills.add((CheckBox) findViewById(R.id.checkBoxPerf));
        skills.add((CheckBox) findViewById(R.id.checkBoxPers));
    }
}
