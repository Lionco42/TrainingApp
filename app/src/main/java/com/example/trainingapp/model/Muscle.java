package com.example.trainingapp.model;

public class Muscle {
    int count;
    String name;
    public Muscle(String name){
        this.count=0;
        this.name = name;
    }

    public void editCount(int num){
        this.count=+num;
    }
    public int getCount(){
        return this.count;
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
