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

public class ExerciseList extends ArrayList<ExerciseType> implements Serializable {
    private static final String DATA_FILE_NAME = "exerciselist";
    private Context context;

    public ExerciseList() {
        super();
    }

    public ExerciseList(Context context) {
        super();
        this.context = context;
        prepareDataFile();
    }

    private void prepareDataFile() {
        File data = new File(context.getFilesDir(), DATA_FILE_NAME);
        if (data.exists()) {
            loadDataFile();
        } else {
            String str = readDataFromFile(context.getResources().openRawResource(R.raw.exerciselist));
            Gson gson = new Gson();
            ExerciseList exerciselist = gson.fromJson(str, ExerciseList.class);
            addAll(exerciselist);
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

        addAll(gson.fromJson(str, ExerciseList.class));
    }
    public void createEx(String type, String name) {
        ExerciseType ex = new ExerciseType(type, name);
        this.add(ex);
        saveDataFile();
    }
    public ExerciseType getEx(String name){
        for(int i = 0; i<= this.toArray().length; i++){
            if(this.get(i).toString().equals(name)){
                return this.get(i);
            }
        }
        return new ExerciseType("Horizontal Pull","CableRow");
    }
}
