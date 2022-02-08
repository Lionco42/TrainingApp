package com.example.trainingapp.model;

public class MuscleCount {

    int pecs=0;
    int back=0;
    int antDelts=0;
    int midDelts=0;
    int rearDelts=0;
    int biceps=0;
    int triceps=0;
    int quads=0;
    int hamstrings=0;
    int calves=0;

    public MuscleCount(){
    }
    public void addSets(String[] muscles, int j){
        for (String muscle : muscles) {
            if (muscle.equals("Pecs"))
                pecs += j;
            if (muscle.equals("Back"))
                back += j;
            if (muscle.equals("AntDelts"))
                antDelts += j;
            if (muscle.equals("MedDelts"))
                midDelts += j;
            if (muscle.equals("RearDelts"))
                rearDelts += j;
            if (muscle.equals("Biceps"))
                biceps += j;
            if (muscle.equals("Triceps"))
                triceps += j;
            if (muscle.equals("Quads"))
                quads += j;
            if (muscle.equals("Hamstrings"))
                hamstrings += j;
            if (muscle.equals("Calves"))
                calves += j;
        }

}}
