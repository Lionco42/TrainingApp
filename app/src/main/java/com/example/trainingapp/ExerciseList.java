package com.example.trainingapp;

import java.io.Serializable;
import java.util.ArrayList;

public class ExerciseList implements Serializable {
    ArrayList<ExerciseType> lst = new ArrayList<>();
    public static ExerciseList exs;
    public static ExerciseList sharedInstance(){
        if(exs==null)
            exs=new ExerciseList();
        return exs;
    }
    public ExerciseList(){};
    public ArrayList<ExerciseType> getLst(){
        return lst;
    }
    public void createEx(String type, String name) {
        ExerciseType ex = new ExerciseType(type, name);
        lst.add(ex);
    }
    public ExerciseType getEx(String name){
        for(int i=0; i<=lst.toArray().length; i++){
            if(lst.get(i).toString().equals(name)){
                return lst.get(i);
            }
        }
        return new ExerciseType("Horizontal Pull","CableRow");
    }
}
