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

    public String getName(){
        return ""+this.exerciseType.toString();
    }
    public int getSets(){
        return this.sets;

    }public String getReps(){
        return this.reps;
    }
}
