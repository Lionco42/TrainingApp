package com.example.trainingapp.model;

import java.io.Serializable;
import java.util.ArrayList;

public class ExerciseList extends ArrayList<ExerciseType> implements Serializable {
    public static ExerciseList exs;
    public static ExerciseList sharedInstance(){
        if(exs==null)
            exs=new ExerciseList();
        return exs;
    }
    public ExerciseList(){};
    public void createEx(String type, String name) {
        ExerciseType ex = new ExerciseType(type, name);
        this.add(ex);
    }
    public ExerciseType getEx(String name){
        for(int i = 0; i<= this.toArray().length; i++){
            if(this.get(i).toString().equals(name)){
                return this.get(i);
            }
        }
        return new ExerciseType("Horizontal Pull","CableRow");
    }
}
