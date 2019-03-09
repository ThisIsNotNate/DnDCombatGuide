package com.example.dndcombatguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MakeCharacterName extends AppCompatActivity {

    TextView nameForm;
    String name, playerClass = null, level = "1";
    String[] stats = {"10", "10", "10", "10", "10", "10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_character1);

        nameForm = findViewById(R.id.editName);

        name = null;

        Button backToMain = findViewById(R.id.buttonBackToMain);
        final Button toClass = findViewById(R.id.buttonMakeClass);

        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MakeCharacterName.this, MainActivity.class));
            }
        });

        toClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MakeCharacterName.this, MakeCharacterClass.class);
                String name = nameForm.getText().toString();
                if(name != null && !name.equals("")) {
                    intent.putExtra("name", name);
                    intent.putExtra("class", playerClass);
                    intent.putExtra("level", level);
                    intent.putExtra("stats", stats);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        Bundle extras = getIntent().getExtras();

        name = null;
        if(extras != null){
            name = extras.getString("name");
            if(name != null && !name.equals("")){
                nameForm.setText(name);
                Log.i("Name Class","Name set to " + name);
            }
            playerClass = extras.getString("class");
            level = extras.getString("level");
            stats = extras.getStringArray("stats");
        }
    }
}
