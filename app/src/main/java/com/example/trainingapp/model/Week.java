package com.example.trainingapp.model;

import java.util.ArrayList;

public class Week extends ArrayList<Day> {
    public static Week days;
    public static int count=0;
    public static Week sharedInstance(){
        if(days==null)
            days=new Week();
        return days;
    }
    public Week(){}

    public void addDay(Day day){
        this.add(day);
        count++;
    }
    public void removeDay(Day day){
        this.remove(day);
    }
    public int getCount(){
        return count;
    }
}
