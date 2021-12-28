package com.example.trainingapp;

public class TrainingAppController {
    public ExerciseList lst= new ExerciseList();

    public TrainingAppController(){
        lst.createEx("Biceps Iso","BicepCurl");
        lst.createEx("Horizontal Push","BenchPress");
        lst.createEx("Horizontal Pull","CableRow");
        lst.createEx("Vertical Pull","Pullup");
    }

}
