package com.example.trainingapp;

import java.util.ArrayList;

public class Week {
    ArrayList<Day> days = new ArrayList<>();

    public Week(Day first){
        this.days.add(first);
    }
    public void addDay(Day day){
        this.days.add(day);
    }
    public void removeDay(Day day){
        this.days.remove(day);
    }
}
