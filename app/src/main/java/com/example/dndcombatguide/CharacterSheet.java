package com.example.dndcombatguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CharacterSheet extends AppCompatActivity {
    String[] stats= new String[6];
    String[] equipment= new String[4];
    int[] playerSkills = new int[18];
    String name = null, playerClass, level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_sheet);

        PlayerCharacter character = new PlayerCharacter();

        Bundle extras = getIntent().getExtras();
        name = null;
        if(extras != null) {
            name = extras.getString("name");
            playerClass = extras.getString("class");
            stats = extras.getStringArray("stats");
            level = extras.getString("level");
            playerSkills = extras.getIntArray("skills");
            equipment = extras.getStringArray("equipment");
            TextView tvName = findViewById(R.id.textViewName);
            tvName.setText(name + ", " + playerClass + " " + level);
            TextView str = findViewById(R.id.textViewStr);
            str.setText(Integer.toString(toModifier(stats[0])));
            TextView dex = findViewById(R.id.textViewDex);
            dex.setText(Integer.toString(toModifier(stats[1])));
            TextView con = findViewById(R.id.textViewCon);
            con.setText(Integer.toString(toModifier(stats[2])));
            TextView intel = findViewById(R.id.textViewIntel);
            intel.setText(Integer.toString(toModifier(stats[3])));
            TextView wis = findViewById(R.id.textViewWis);
            wis.setText(Integer.toString(toModifier(stats[4])));
            TextView cha = findViewById(R.id.textViewCha);
            cha.setText(Integer.toString(toModifier(stats[5])));

            TextView wep1 = findViewById(R.id.textViewWep1);
            wep1.setText(equipment[1]);
            TextView wep2 = findViewById(R.id.textViewWep2);
            wep2.setText(equipment[2]);
            TextView wep3 = findViewById(R.id.textViewWep3);
            wep3.setText(equipment[3]);

            TextView init = findViewById(R.id.textViewInit);
            init.setText("Initiative: " + toModifier(stats[1]));

            TextView prof = findViewById(R.id.textViewProf);
            prof.setText("Prof. Bonus: " + Integer.toString(getProf()));

            TextView ac = findViewById(R.id.textViewAC);
            ac.setText("AC: " + equipment[0]);

            TextView ath = findViewById(R.id.textViewAth);
            setSkill(ath, 0, 0, "Athletics");

            TextView acr = findViewById(R.id.textViewAcr);
            setSkill(acr, 1, 1 , "Acrobatics");
            TextView soh = findViewById(R.id.textViewSoh);
            setSkill(soh, 1, 2 , "Sleight of Hand");
            TextView ste = findViewById(R.id.textViewSte);
            setSkill(ste, 1, 3 , "Stealth");

            TextView arc = findViewById(R.id.textViewArc);
            setSkill(arc, 3, 4, "Arcana");
            TextView his = findViewById(R.id.textViewHis);
            setSkill(his, 3, 5, "History");
            TextView inv = findViewById(R.id.textViewInv);
            setSkill(inv, 3, 6, "Investigation");
            TextView nat = findViewById(R.id.textViewNat);
            setSkill(nat, 3, 7, "Nature");
            TextView rel = findViewById(R.id.textViewRel);
            setSkill(rel, 3, 8, "Religion");

            TextView ani = findViewById(R.id.textViewAni);
            setSkill(ani, 4, 9, "Animal Handling");
            TextView ins = findViewById(R.id.textViewIns);
            setSkill(ins, 4, 10, "Insight");
            TextView med = findViewById(R.id.textViewMed);
            setSkill(med, 4, 11, "Medicine");
            TextView per = findViewById(R.id.textViewPer);
            setSkill(per, 4, 12, "Perception");
            TextView sur = findViewById(R.id.textViewSur);
            setSkill(sur, 4, 13, "Survival");

            TextView dec = findViewById(R.id.textViewDec);
            setSkill(dec, 5, 14, "Deception");
            TextView inti = findViewById(R.id.textViewIntel);
            setSkill(inti, 5, 15, "Initimidation");
            TextView perf = findViewById(R.id.textViewPerf);
            setSkill(perf, 5, 16, "Performance");
            TextView pers = findViewById(R.id.textViewPers);
            setSkill(pers, 5, 17, "Persuasion");

        }
    }

    public void setSkill(TextView tv, int ability, int i, String skill){
        if(playerSkills[i] == 1)
            tv.setText(skill + ": " + Integer.toString(toModifier(stats[ability]) + getProf()));
        else
            tv.setText(skill + ": " + Integer.toString(toModifier(stats[ability])));
    }

    public int getProf(){
        switch(level){
            case "1":
            case "2":
            case "3":
            case "4": return 2;
            case "5":
            case "6":
            case "7":
            case "8": return 3;
            case "9":
            case "10":
            case "11":
            case "12": return 4;
            case "13":
            case "14":
            case "15":
            case "16": return 5;
            case "17":
            case "18":
            case "19":
            case "20": return 6;
        }
        return 2;
    }

    public int toModifier(String stat){
        switch(stat){
            case "1": return -5;
            case "2":
            case "3": return -4;
            case "4":
            case "5": return -3;
            case "6":
            case "7": return -2;
            case "8":
            case "9": return -1;
            case "10":
            case "11": return 0;
            case "12":
            case "13": return 1;
            case "14":
            case "15": return 2;
            case "16":
            case "17": return 3;
            case "18":
            case "19": return 4;
            case "20": return 5;
        }
        return 0;
    }
}
