package com.example.trainingapp.model;

import java.util.ArrayList;

public class MuscleList extends ArrayList<Muscle> {
    public static MuscleList instance = new MuscleList();
    public static MuscleList getInstance(){
        if (instance == null) instance = new MuscleList();
        return instance;
    }
   //pecs=0
   //back=1
   //antDelts=2
   //midDelts=3
   //rearDelts=4
   //biceps=5
   //triceps=6
   //quads=7
   //hamstrings=8
   //calves=9


    private MuscleList(){
        Muscle pecs = new Muscle("Pecs");
        Muscle back = new Muscle("Back");
        Muscle antDelts = new Muscle("AntDelts");
        Muscle midDelts = new Muscle("MedDelts");
        Muscle rearDelts = new Muscle("RearDelts");
        Muscle biceps = new Muscle("Biceps");
        Muscle triceps = new Muscle("Triceps");
        Muscle quads = new Muscle("Quads");
        Muscle hamstrings = new Muscle("Hamstrings");
        Muscle calves = new Muscle("Calves");
        add(pecs);
        add(back);
        add(antDelts);
        add(rearDelts);
        add(biceps);
        add(triceps);
        add(quads);
        add(midDelts);
        add(hamstrings);
        add(calves);
    }
    public void addSets(String[] muscles, int count){
        for (String muscle : muscles) {

        }
}}
