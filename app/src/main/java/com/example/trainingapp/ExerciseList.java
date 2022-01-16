package com.example.trainingapp;

import java.io.Serializable;
import java.util.ArrayList;

public class ExerciseList implements Serializable {
    ArrayList<ExerciseType> exTypeList = new ArrayList<>();
    public static ExerciseList exs;
    public static ExerciseList sharedInstance(){
        if(exs==null)
            exs=new ExerciseList();
        return exs;
    }
    public ExerciseList(){};
    public ArrayList<ExerciseType> getExTypeList(){
        return exTypeList;
    }
    public void createEx(String type, String name) {
        ExerciseType ex = new ExerciseType(type, name);
        exTypeList.add(ex);
    }
    public ExerciseType getEx(String name){
        for(int i = 0; i<= exTypeList.toArray().length; i++){
            if(exTypeList.get(i).toString().equals(name)){
                return exTypeList.get(i);
            }
        }
        return new ExerciseType("Horizontal Pull","CableRow");
    }
}
