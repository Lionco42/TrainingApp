package com.example.trainingapp;

import java.util.ArrayList;

public class Week {
    ArrayList<Day> dayList = new ArrayList<>();
    public static Week days;
    public static int count;
    public static Week sharedInstance(){
        if(days==null)
            days=new Week();
        return days;
    }
    public Week(){

        }
    public void addDay(Day day){
        this.dayList.add(day);
        count++;
    }
    public void removeDay(Day day){
        this.dayList.remove(day);
    }
    public ArrayList<Day> getDayList(){
        return dayList;
    }
    public int getCount(){
        return count;
    }
}
