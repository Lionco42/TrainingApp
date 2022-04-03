package com.example.trainingapp.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Day extends java.util.ArrayList<Exercise> implements Serializable {
    //int number;
    //ArrayList<Exercise> exsList;
    public Day(){
    }
    /*
    public ArrayList<Exercise> getExsList(){
        return this.exsList;
    }
    public void addExercise(Exercise exercise){
        this.exsList.add(exercise);
    }
    public void removeExercise(Exercise exercise){
        this.exsList.remove(exercise);
    }
     */
    public String toString(int number){
        return "Day"+ number;
    }
}
