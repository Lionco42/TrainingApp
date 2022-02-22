package com.example.trainingapp.model;

import android.content.Context;
import android.util.Log;

import com.example.trainingapp.R;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MuscleList extends ArrayList<Muscle> implements Serializable {
    private static final String DATA_FILE_NAME = "movies";
    private Context context;

    public MuscleList() {
        super();
    }

    public MuscleList(Context context) {
        super();
        this.context = context;
        prepareDataFile();
    }

    private void prepareDataFile() {
        File data = new File(context.getFilesDir(), DATA_FILE_NAME);
        if (data.exists()) {
            loadDataFile();
        } else {
            String str = readDataFromFile(context.getResources().openRawResource(R.raw.muscleList));
            Gson gson = new Gson();
            MuscleList moviesArrayList = gson.fromJson(str, MuscleList.class);
            addAll(moviesArrayList);
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

        addAll(gson.fromJson(str, MuscleList.class));
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
    }
}
