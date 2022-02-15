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
        this.add(new Muscle("Pecs"));
        this.add(new Muscle("Back"));
        this.add(new Muscle("AntDelts"));
        this.add(new Muscle("MedDelts"));
        this.add(new Muscle("RearDelts"));
        this.add(new Muscle("Biceps"));
        this.add(new Muscle("Triceps"));
        this.add(new Muscle("Quads"));
        this.add(new Muscle("Hamstrings"));
        this.add(new Muscle("Calves"));
    }
    public void addSets(String[] muscles, int count) {
        for (String muscle : muscles) {
            if (muscle.equals("Pecs")) {
                this.get(0).editCount(count);
            } else if (muscle.equals("Back")) {
                this.get(1).editCount(count);
            } else if (muscle.equals("AntDelts")) {
                this.get(2).editCount(count);
            } else if (muscle.equals("MedDelts")) {
                this.get(3).editCount(count);
            } else if (muscle.equals("RearDelts")) {
                this.get(4).editCount(count);
            } else if (muscle.equals("Biceps")) {
                this.get(5).editCount(count);
            } else if (muscle.equals("Triceps")) {
                this.get(6).editCount(count);
            } else if (muscle.equals("Quads")) {
                this.get(7).editCount(count);
            } else if (muscle.equals("Hamstrings")) {
                this.get(8).editCount(count);
            } else if (muscle.equals("Calves")) {
                this.get(9).editCount(count);
            }


        }
    }
}
