package com.example.trainingapp.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Week extends ArrayList<Day> implements Serializable {
    public static Week days;
    public static int count=0;
//    public static Week getInstance(){
//
//    }
    public static Week sharedInstance(){
        if(days==null)
            days=new Week();
        return days;
    }
    private Week(){}

    public void addDay(Day day){
        this.add(day);
        this.count++;
    }
    public void removeDay(Day day){
        this.remove(day);
    }
    public int getCount(){
        return this.count;
    }
}
