package com.example.dndcombatguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MakeCharacterClass extends AppCompatActivity {
    String name = null, playerClass;
    RadioGroup rg;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_character_class);

        Bundle extras = getIntent().getExtras();
        playerClass = null;
        name = null;
        if(extras != null){
            name = extras.getString("name");
        }

        title = findViewById(R.id.textViewTitle);
        if(name != null && !name.equals("")){
            String text = "What is " + name + "'s class?";
            title.setText(text);
        }

        rg = findViewById(R.id.RadioButtonsClass);

        Button toMakeName = findViewById(R.id.buttonToMakeName);
        Button toMakeStats = findViewById(R.id.buttonToMakeStats);

        toMakeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MakeCharacterClass.this, MakeCharacterName.class);
                intent.putExtra("name", name);
                if(rg.getCheckedRadioButtonId()!=-1){
                    int id= rg.getCheckedRadioButtonId();
                    View radioButton = rg.findViewById(id);
                    int radioId = rg.indexOfChild(radioButton);
                    RadioButton btn = (RadioButton) rg.getChildAt(radioId);
                    String playerClass = (String) btn.getText();
                    intent.putExtra("class", playerClass);
                }
                startActivity(intent);
            }
        });

        toMakeStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MakeCharacterClass.this, MakeCharacterClass.class); // Change to MakeCharacterStats when created

                if(rg.getCheckedRadioButtonId()!=-1){ // if a choice is made go to next activity
                    intent.putExtra("name", name);
                    int id= rg.getCheckedRadioButtonId();
                    View radioButton = rg.findViewById(id);
                    int radioId = rg.indexOfChild(radioButton);
                    RadioButton btn = (RadioButton) rg.getChildAt(radioId);
                    String playerClass = (String) btn.getText();
                    intent.putExtra("class", playerClass);
                    startActivity(intent);
                }

            }
        });

    }

    @Override
    protected void onResume(){
        super.onResume();

        Bundle extras = getIntent().getExtras();
        name = null;
        if(extras != null){
            name = extras.getString("name");
            playerClass = extras.getString("class");
            if (playerClass != null) {
                switch (playerClass) {
                    case "Bard":
                        rg.check(R.id.radioClassBard);
                        break;
                    case "Barbarian":
                        rg.check(R.id.radioClassBarbarian);
                        break;
                    case "Druid":
                        rg.check(R.id.radioClassDruid);
                        break;
                    case "Fighter":
                        rg.check(R.id.radioClassFighter);
                        break;
                    case "Monk":
                        rg.check(R.id.radioClassMonk);
                        break;
                    case "Ranger":
                        rg.check(R.id.radioClassRanger);
                        break;
                    case "Sorcerer":
                        rg.check(R.id.radioClassSorcerer);
                        break;
                    case "Warlock":
                        rg.check(R.id.radioClassWarlock);
                        break;
                    case "Wizard":
                        rg.check(R.id.radioClassWizard);
                        break;
                }
            }
            if(name != null && name != ""){
                String text = "What is " + name + "'s class?";
                title.setText(text);
            }
        }
    }
}
