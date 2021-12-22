package com.example.trainingapp;

import java.util.ArrayList;

public class Day {
    ArrayList<Exercise> exercises= new ArrayList<>();
    int number;

    public Day(int num){
        this.number=num;
    }
    public void addExercise(Exercise exercise){
        this.exercises.add(exercise);
    }
    public void removeExercise(Exercise exercise){
        this.exercises.remove(exercise);
    }
    public String toString(){
        return "Day"+ number;
    }
}
