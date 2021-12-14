package com.example.trainingapp;

public class Exercise {
    ExerciseType exerciseType;
    String reps;
    int sets;

    public Exercise(int sets, ExerciseType exerciseName, String reps){
        this.exerciseType=exerciseName;
        this.reps=reps;
        this.sets=sets;
    }
}
