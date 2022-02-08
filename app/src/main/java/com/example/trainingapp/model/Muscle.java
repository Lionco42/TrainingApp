package com.example.trainingapp.model;

public class Muscle {
    int count;
    String name;
    public Muscle(String name){
        this.count=0;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Muscle{" +
                "count=" + count +
                ", name='" + name + '\'' +
                '}';
    }
    public String getName(){return this.name;}
}
