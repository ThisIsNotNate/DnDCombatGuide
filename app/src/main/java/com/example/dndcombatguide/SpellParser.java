package com.example.dndcombatguide;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.*;

public class SpellParser {
    private ArrayList<Spell> spellList = new ArrayList<Spell>();
    public void main(String args[]){

    }

    public String readJSON(String filename){
        FileInputStream in = null;
        BufferedReader br = null;
        File input = new File(filename);
        String path = input.getAbsolutePath();
        String json = "";
        try{
            in = new FileInputStream(path);
            br = new BufferedReader(new InputStreamReader(in));

            String line = null;
            while((line = br.readLine()) != null){
                json += line;
            }
            br.close();
        }
        catch(Exception e){
            System.err.println(e + "\nCouldn't read input file. Exiting Program");
            System.exit(3);
        }


        return json;
    }

}
