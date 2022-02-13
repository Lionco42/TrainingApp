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
        add(new Muscle("Pecs"));
        add(new Muscle("Back"));
        add(new Muscle("AntDelts"));
        add(new Muscle("MedDelts"));
        add(new Muscle("RearDelts"));
        add(new Muscle("Biceps"));
        add(new Muscle("Triceps"));
        add(new Muscle("Quads"));
        add(new Muscle("Hamstrings"));
        add(new Muscle("Calves"));
    }
    public void addSets(String[] muscles, int count){
        for (String muscle : muscles) {
            if(muscle.equals("Pecs")){
                get(0).editCount(count);
            }else
            if(muscle.equals("Back")){
                get(1).editCount(count);
            }else
            if(muscle.equals("AntDelts")){
                get(2).editCount(count);
            }else
            if(muscle.equals("MedDelts")){
                get(3).editCount(count);
            }else
            if(muscle.equals("RearDelts")){
                get(4).editCount(count);
            }else
            if(muscle.equals("Biceps")){
                get(5).editCount(count);
            }else
            if(muscle.equals("Triceps")){
                get(6).editCount(count);
            }else
            if(muscle.equals("Quads")){
                get(7).editCount(count);
            }else
            if(muscle.equals("Hamstrings")){
                get(8).editCount(count);
            }else
            if(muscle.equals("Calves")){
                get(9).editCount(count);
            }


        }
}
    public MuscleList getMuscles(){
        return this;
    }
}
