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
        for (String muscle : muscles) {
            if (muscle.equals("Pecs"))
                Pecs += j;
            if (muscle.equals("Back"))
                Back += j;
            if (muscle.equals("AntDelts"))
                AntDelts += j;
            if (muscle.equals("MedDelts"))
                MedDelts += j;
            if (muscle.equals("RearDelts"))
                RearDelts += j;
            if (muscle.equals("Biceps"))
                Biceps += j;
            if (muscle.equals("Triceps"))
                Triceps += j;
            if (muscle.equals("Quads"))
                Quads += j;
            if (muscle.equals("Hamstrings"))
                Hamstrings += j;
            if (muscle.equals("Calves"))
                Calves += j;
        }

}}
