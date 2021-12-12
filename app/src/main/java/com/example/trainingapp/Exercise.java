package com.example.trainingapp;

public class Exercise {
    String Name;
    String Type;
    String[] Muscles;

    public Exercise(String Type, String Name){
        this.Name=Name;
        this.Type=Type;
        if(Type.equals("Vertical Push")){
            this.Muscles=new String[]{"AntDelts","MedDelts","Triceps"};
        }
    }
}
