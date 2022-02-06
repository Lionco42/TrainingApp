package com.example.trainingapp.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Day implements Serializable {
    int number;
    ArrayList<Exercise> exsList;
    public Day(int num){
        this.number=num;
        this.exsList = new ArrayList<>();
    }
    public ArrayList<Exercise> getExsList(){
        return this.exsList;
    }
    public void addExercise(Exercise exercise){
        this.exsList.add(exercise);
    }
    public void removeExercise(Exercise exercise){
        this.exsList.remove(exercise);
    }
    public String toString(){
        return "Day"+ this.number;
    }
}
