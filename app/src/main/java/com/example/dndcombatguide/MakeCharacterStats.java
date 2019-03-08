package com.example.dndcombatguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MakeCharacterStats extends AppCompatActivity {
    TextView strScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_character_stats);

        Button strP = findViewById(R.id.buttonStrPlus);
        strScore = findViewById(R.id.textViewStr);
        strP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strScore.setText(Integer.parseInt(strScore.getText().toString()) + 1);
            }
        });
    }
}
