package com.example.dndcombatguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MakeCharacterLevel extends AppCompatActivity {
    String name = null, playerClass, level;
    String[] stats = new String[6];
    String[] equipment= new String[4];
    int[] playerSkills = new int[18];
    TextView playerLevel,title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_character_level);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            name = extras.getString("name");
            playerClass = extras.getString("class");
        }

        title = findViewById(R.id.textViewLevelTitle);
        if(name != null && !name.equals("")){
            String text = "What level is " + name + "?";
            title.setText(text);
        }

        Button toMakeClass = findViewById(R.id.buttonToMakeClass);
        Button toMakeStats = findViewById(R.id.buttonToMakeStats);

        Button levelP = findViewById(R.id.buttonLevelPlus);
        Button levelM = findViewById(R.id.buttonLevelMinus);
        playerLevel = findViewById(R.id.textViewLevel);

        toMakeClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MakeCharacterLevel.this, MakeCharacterClass.class);
                intent.putExtra("name", name);
                intent.putExtra("class", playerClass);
                intent.putExtra("stats", stats);
                intent.putExtra("level", playerLevel.getText().toString());
                intent.putExtra("skills", playerSkills);
                intent.putExtra("equipment", equipment);
                startActivity(intent);
            }
        });

        toMakeStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MakeCharacterLevel.this, MakeCharacterStats.class);
                intent.putExtra("name", name);
                intent.putExtra("class", playerClass);
                intent.putExtra("stats", stats);
                intent.putExtra("level", playerLevel.getText().toString());
                intent.putExtra("skills", playerSkills);
                intent.putExtra("equipment", equipment);
                startActivity(intent);
            }
        });

        levelP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(playerLevel.getText().toString().equals(""))
                    playerLevel.setText("1");
                else {
                    int score = Integer.parseInt(playerLevel.getText().toString());
                    if (score < 20)
                        playerLevel.setText(Integer.toString(Integer.parseInt(playerLevel.getText().toString()) + 1));
                }
            }
        });
        levelM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(playerLevel.getText().toString().equals(""))
                    playerLevel.setText("1");
                else {
                    int score = Integer.parseInt(playerLevel.getText().toString());
                    if (1 < score)
                        playerLevel.setText(Integer.toString(Integer.parseInt(playerLevel.getText().toString()) - 1));
                }
            }
        });
    }

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
            if(level != null && !level.equals("")){
                playerLevel.setText(level);
            }
            else
                playerLevel.setText("1");
            if(name != null && name != ""){
                String text = "What level is " + name + "?";
                title.setText(text);
            }
        }
    }
}
