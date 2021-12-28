package com.example.trainingapp;

import java.util.ArrayList;

public class ExerciseList {
    ArrayList<ExerciseType> exs = new ArrayList<>();

    public ExerciseList(){};
    public void createEx(String type, String name) {
        ExerciseType ex = new ExerciseType(type, name);
        exs.add(ex);
    }
    public ExerciseType getEx(String name){
        for(int i=0; i<=exs.toArray().length; i++){
            if(exs.get(i).getName().equals(name)){
                return exs.get(i);
            }
        }
        return null;
    }
}
