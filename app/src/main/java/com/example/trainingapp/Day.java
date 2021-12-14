package com.example.trainingapp;

import java.util.ArrayList;

public class Day {
    ArrayList<Exercise> exercises= new ArrayList<>();
    int number;

    public Day(Exercise first){
        this.exercises.add(first);
        this.number=exercises.indexOf(first)+1;
    }
    public void addExercise(Exercise exercise){
        this.exercises.add(exercise);
    }
    public void removeExercise(Exercise exercise){
        this.exercises.remove(exercise);
    }
}
