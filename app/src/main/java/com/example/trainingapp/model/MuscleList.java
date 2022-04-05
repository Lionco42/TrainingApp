package com.example.trainingapp.model;

import android.content.Context;
import android.util.Log;

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

public class MuscleList extends java.util.ArrayList<Muscle> implements Serializable {
    private static final String DATA_FILE_NAME = "muscle";
    private Context context;
    public MuscleList(Context context){
        super();
        this.context = context;
        prepareDataFile();
    }
    private static MuscleList instance;
    public static MuscleList getInstance(Context context){
        if (instance == null) instance = new MuscleList(context);
        return instance;
    }

    private void test(){
        add(new Muscle("yoav"));
        add(new Muscle("yoav1"));
        saveDataFile();
    }
    public void prepareDataFile() {
        File data = new File(context.getFilesDir(), DATA_FILE_NAME);
        if (data.exists()) {
            loadDataFile();
        } else {
            String str = readDataFromFile(context.getResources().openRawResource(R.raw.muscle));
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Muscle>>(){}.getType();
            ArrayList<Muscle> musclesArrayList = gson.fromJson(str, listType);
            addAll(musclesArrayList);
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
        Type listType = new TypeToken<MuscleList>(){}.getType();
        addAll(gson.fromJson(str, listType));
    }
    public void addSets(String[] muscles, int count) {
        for (String muscle : muscles) {
            switch (muscle) {
                case "Pecs":
                    this.get(0).editCount(count);
                    break;
                case "Back":
                    this.get(1).editCount(count);
                    break;
                case "AntDelts":
                    this.get(2).editCount(count);
                    break;
                case "MedDelts":
                    this.get(3).editCount(count);
                    break;
                case "RearDelts":
                    this.get(4).editCount(count);
                    break;
                case "Biceps":
                    this.get(5).editCount(count);
                    break;
                case "Triceps":
                    this.get(6).editCount(count);
                    break;
                case "Quads":
                    this.get(7).editCount(count);
                    break;
                case "Hamstrings":
                    this.get(8).editCount(count);
                    break;
                case "Calves":
                    this.get(9).editCount(count);
                    break;
            }
        }
        saveDataFile();
    }
}
