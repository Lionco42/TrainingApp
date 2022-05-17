package com.example.trainingapp.model;

import static com.example.trainingapp.model.Week.instance;

import android.content.Context;

import com.example.trainingapp.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ExerciseList extends java.util.ArrayList<ExerciseType> implements Serializable {
    private static final String DATA_FILE_NAME = "exercisetypelist";
    private Context context;
    public static ExerciseList instance;
    public static ExerciseList getInstance(Context context){
        if (instance == null) instance = new ExerciseList(context);
        return instance;
    }

    public ExerciseList(Context context) {
        super();
        this.context = context;
        prepareDataFile();
    }

    private void prepareDataFile() {
            String str = readDataFromFile(context.getResources().openRawResource(R.raw.exercisettypelist));
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<ExerciseType>>(){}.getType();
            ArrayList<ExerciseType> exs = gson.fromJson(str, listType);
            addAll(exs);
            saveDataFile();
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

    public void saveDataFile() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        FileOutputStream out = null;

        try {
            out = context.openFileOutput(DATA_FILE_NAME, Context.MODE_PRIVATE);
            out.write(json.getBytes(), 0, json.getBytes().length);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createEx(String type, String name) {
        ExerciseType ex = new ExerciseType(type, name);
        this.add(ex);
        saveDataFile();
    }
}
/*
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
        Type listType = new TypeToken<ArrayList<ExerciseType>>(){}.getType();
        ArrayList<ExerciseType> exs = gson.fromJson(str, listType);
        addAll(exs);
    }
    */
