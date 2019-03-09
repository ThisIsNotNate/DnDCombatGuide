package com.example.dndcombatguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MakeCharacterStats extends AppCompatActivity {
    TextView strScore, dexScore, conScore, intScore, wisScore, chaScore;

    String[] stats = new String[6];
    String name = null, playerClass, level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_character_stats);

        TextView title = findViewById(R.id.textViewStatsTitle);

        Bundle extras = getIntent().getExtras();
        playerClass = null;
        name = null;
        if(extras != null){
            name = extras.getString("name");
            playerClass = extras.getString("class");
            level = extras.getString("level");
        }

        if(name != null && !name.equals("")){
            String text = "What are " + name + "'s stats?";
            title.setText(text);
        }

        Button toLevel = findViewById(R.id.buttonToMakeLevel);
        Button toEquipment = findViewById(R.id.buttonToMakeEquipment);

        Button strP = findViewById(R.id.buttonStrPlus);
        Button strM = findViewById(R.id.buttonStrMinus);

        Button dexP = findViewById(R.id.buttonDexPlus);
        Button dexM = findViewById(R.id.buttonDexMinus);

        Button conP = findViewById(R.id.buttonConPlus);
        Button conM = findViewById(R.id.buttonConMinus);

        Button intP = findViewById(R.id.buttonIntPlus);
        Button intM = findViewById(R.id.buttonIntMinus);

        Button wisP = findViewById(R.id.buttonWisPlus);
        Button wisM = findViewById(R.id.buttonWisMinus);

        Button chaP = findViewById(R.id.buttonChaPlus);
        Button chaM = findViewById(R.id.buttonChaMinus);

        strScore = findViewById(R.id.textViewStrScore);
        dexScore = findViewById(R.id.textViewDexScore);
        conScore = findViewById(R.id.textViewConScore);
        intScore = findViewById(R.id.textViewIntScore);
        wisScore = findViewById(R.id.textViewWisScore);
        chaScore = findViewById(R.id.textViewChaScore);

        toLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MakeCharacterStats.this, MakeCharacterLevel.class);
                getStats();
                intent.putExtra("name", name);
                intent.putExtra("class", playerClass);
                intent.putExtra("level", level);
                intent.putExtra("stats", stats);

                startActivity(intent);
            }
        });

        toEquipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MakeCharacterStats.this, MakeCharacterEquipment.class);
                getStats();
                intent.putExtra("name", name);
                intent.putExtra("class", playerClass);
                intent.putExtra("level", level);
                intent.putExtra("stats", stats);

                startActivity(intent);
            }
        });


        strP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(strScore.getText().toString().equals(""))
                    strScore.setText("10");
                else {
                    int score = Integer.parseInt(strScore.getText().toString());
                    if (score < 20)
                        strScore.setText(Integer.toString(Integer.parseInt(strScore.getText().toString()) + 1));
                }
            }
        });
        strM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(strScore.getText().toString().equals(""))
                    strScore.setText("10");
                else {
                    int score = Integer.parseInt(strScore.getText().toString());
                    if (0 < score)
                        strScore.setText(Integer.toString(Integer.parseInt(strScore.getText().toString()) - 1));
                }
            }
        });

        dexP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dexScore.getText().toString().equals(""))
                    dexScore.setText("10");
                else {
                    int score = Integer.parseInt(dexScore.getText().toString());
                    if (score < 20)
                        dexScore.setText(Integer.toString(Integer.parseInt(dexScore.getText().toString()) + 1));
                }
            }
        });
        dexM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dexScore.getText().toString().equals(""))
                    dexScore.setText("10");
                else {
                    int score = Integer.parseInt(dexScore.getText().toString());
                    if (0 < score)
                        dexScore.setText(Integer.toString(Integer.parseInt(dexScore.getText().toString()) - 1));
                }
            }
        });

        conP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(conScore.getText().toString().equals(""))
                    conScore.setText("10");
                else {
                    int score = Integer.parseInt(conScore.getText().toString());
                    if (score < 20)
                        conScore.setText(Integer.toString(Integer.parseInt(conScore.getText().toString()) + 1));
                }
            }
        });
        conM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(conScore.getText().toString().equals(""))
                    conScore.setText("10");
                else {
                    int score = Integer.parseInt(conScore.getText().toString());
                    if (0 < score)
                        conScore.setText(Integer.toString(Integer.parseInt(conScore.getText().toString()) - 1));
                }
            }
        });

        intP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(intScore.getText().toString().equals(""))
                    intScore.setText("10");
                else {
                    int score = Integer.parseInt(intScore.getText().toString());
                    if (score < 20)
                        intScore.setText(Integer.toString(Integer.parseInt(intScore.getText().toString()) + 1));
                }
            }
        });
        intM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(intScore.getText().toString().equals(""))
                    intScore.setText("10");
                else {
                    int score = Integer.parseInt(intScore.getText().toString());
                    if (0 < score)
                        intScore.setText(Integer.toString(Integer.parseInt(intScore.getText().toString()) - 1));
                }
            }
        });

        wisP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(wisScore.getText().toString().equals(""))
                    wisScore.setText("10");
                else {
                    int score = Integer.parseInt(wisScore.getText().toString());
                    if (score < 20)
                        wisScore.setText(Integer.toString(Integer.parseInt(wisScore.getText().toString()) + 1));
                }
            }
        });
        wisM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(wisScore.getText().toString().equals(""))
                    wisScore.setText("10");
                else {
                    int score = Integer.parseInt(wisScore.getText().toString());
                    if (0 < score)
                        wisScore.setText(Integer.toString(Integer.parseInt(wisScore.getText().toString()) - 1));
                }
            }
        });

        chaP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chaScore.getText().toString().equals(""))
                    chaScore.setText("10");
                else {
                    int score = Integer.parseInt(chaScore.getText().toString());
                    if (score < 20)
                        chaScore.setText(Integer.toString(Integer.parseInt(chaScore.getText().toString()) + 1));
                }
            }
        });
        chaM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chaScore.getText().toString().equals(""))
                    chaScore.setText("10");
                else {
                    int score = Integer.parseInt(chaScore.getText().toString());
                    if (0 < score)
                        chaScore.setText(Integer.toString(Integer.parseInt(chaScore.getText().toString()) - 1));
                }
            }
        });
        //initStats();
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
            if(stats != null){
                strScore.setText(stats[0]);
                dexScore.setText(stats[1]);
                conScore.setText(stats[2]);
                intScore.setText(stats[3]);
                wisScore.setText(stats[4]);
                chaScore.setText(stats[5]);
            }
        }
    }

    public void getStats(){
        stats[0] = strScore.getText().toString();
        stats[1] = dexScore.getText().toString();
        stats[2] = conScore.getText().toString();
        stats[3] = intScore.getText().toString();
        stats[4] = wisScore.getText().toString();
        stats[5] = chaScore.getText().toString();
    }

//    public void initStats(){
//        strScore.setText("10");
//        dexScore.setText("10");
//        conScore.setText("10");
//        intScore.setText("10");
//        wisScore.setText("10");
//        chaScore.setText("10");
//    }
}
