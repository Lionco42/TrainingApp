package com.example.trainingapp.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Day extends java.util.ArrayList<Exercise> implements Serializable {

    public Day(){
    }
    public String toString(int number){
        int num= number+1;
        return "Day"+ num;
    }
}
