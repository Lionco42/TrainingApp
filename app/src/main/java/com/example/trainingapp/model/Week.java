package com.example.trainingapp.model;

import android.content.Context;

import com.example.trainingapp.R;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Week extends ArrayList<Day> implements Serializable {
    private static final String DATA_FILE_NAME = "week";
    public static Week instance;
    private Context context;
    public static int count=0;
    public static Week getInstance(){
        if (instance == null) instance = new Week();
        return instance;
    }
    private Week(){}
    public void setContext(Context context){
        this.context = context;
    }
    public void addDay(Day day){
        this.add(day);
        this.count++;
        saveDataFile();
    }


    private void prepareDataFile() {
        File data = new File(context.getFilesDir(), DATA_FILE_NAME);
        if (data.exists()) {
            loadDataFile();
        } else {
            String str = readDataFromFile(context.getResources().openRawResource(R.raw.week));
            Gson gson = new Gson();
            Week daysArrayList = gson.fromJson(str, Week.class);
            addAll(daysArrayList);
            saveDataFile();
        }
    }

    private String readDataFromFile(InputStream in) {
        String str = "";
        try {
            byte[] buffer=new byte[in.available()];
            in.read(buffer);
            str=new String(buffer, StandardCharsets.UTF_8);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    private void saveDataFile() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        FileOutputStream out = null;

        try {
            out = context.openFileOutput(DATA_FILE_NAME, Context.MODE_PRIVATE);
            out.write(json.getBytes(), 0, json.length());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadDataFile() {
        Gson gson = new Gson();
        InputStream in = null;
        String str = "";

        try {
            in = context.openFileInput(DATA_FILE_NAME);
            byte[] buffer=new byte[in.available()];
            in.read(buffer);
            str=new String(buffer, StandardCharsets.UTF_8);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Day> days = gson.fromJson(str, Week.class);
        addAll(days);
    }
    public void removeDay(Day day){
        this.remove(day);
        saveDataFile();
    }
    public int getCount(){
        return this.count;
    }
}
