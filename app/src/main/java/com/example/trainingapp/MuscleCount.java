package com.example.trainingapp;

public class MuscleCount {
    int Pecs=0;
    int Back=0;
    int AntDelts=0;
    int MedDelts=0;
    int RearDelts=0;
    int Biceps=0;
    int Triceps=0;
    int Quads=0;
    int Hamstrings=0;
    int Calves=0;

    public void addSets(String[] muscles, int j){
        for(int i=0; i< muscles.length; i++){
            if(muscles[i].equals("Pecs"))
                Pecs+=j;
            if(muscles[i].equals("Back"))
                Back+=j;
            if(muscles[i].equals("AntDelts"))
                AntDelts+=j;
            if(muscles[i].equals("MedDelts"))
                MedDelts+=j;
            if(muscles[i].equals("RearDelts"))
                RearDelts+=j;
            if(muscles[i].equals("Biceps"))
                Biceps+=j;
            if(muscles[i].equals("Triceps"))
                Triceps+=j;
            if(muscles[i].equals("Quads"))
                Quads+=j;
            if(muscles[i].equals("Hamstrings"))
                Hamstrings+=j;
            if(muscles[i].equals("Calves"))
                Calves+=j;
        }

}}
