package com.example.trainingapp.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.trainingapp.model.Day;
import com.example.trainingapp.model.ExerciseList;
import com.example.trainingapp.R;
import com.example.trainingapp.model.ExerciseType;
import com.example.trainingapp.model.Muscle;
import com.example.trainingapp.model.MuscleList;
import com.example.trainingapp.model.Week;
import com.google.gson.Gson;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Week week1;
    ArrayAdapter<Day> weekAdapter;
    ListView week;
    ExerciseList exs;
    MuscleList muscleList;
    PhoneCallReciever phoneCallReciever;
    private static final int PHONE_STATE_PERMISSION_REQUEST_CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        muscleList=MuscleList.getInstance(this);
        week1=Week.getInstance(this);
        exs= ExerciseList.getInstance(this);
        phoneCallReciever = new PhoneCallReciever();
        registerReceiver(phoneCallReciever, new IntentFilter(Intent.ACTION_CALL));

        if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED)
            requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_CALL_LOG, Manifest.permission.SEND_SMS}, PHONE_STATE_PERMISSION_REQUEST_CODE);


        week=findViewById(R.id.week);
        weekAdapter = new ArrayAdapter<Day>(this, android.R.layout.activity_list_item, android.R.id.text1, week1) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                Day day1 = (Day) week1.get(position);
                TextView text = view.findViewById(android.R.id.text1);
                text.setText(day1.toString(position));
                return view;
            }
        };
        week.setAdapter(weekAdapter);
        week.setOnItemClickListener(this);

        if(exs.isEmpty()){
            exs.add(new ExerciseType("Horizontal Push","Bench Press"));
            exs.add(new ExerciseType("Horizontal Pull","Cable Row"));
            exs.add(new ExerciseType("Biceps Iso","Hammer Curl"));
            exs.add(new ExerciseType("Vertical Pull","Pullup"));
            exs.saveDataFile();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(phoneCallReciever, new IntentFilter("android.intent.action.PHONE_STATE"));
        Log.d("BRPHONEDEMO", "onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(phoneCallReciever);
        Log.d("BRPHONEDEMO", "onPause");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        Log.d("BRPHONEDEMO", "onRequestPermissionsResult");
        if (requestCode == PHONE_STATE_PERMISSION_REQUEST_CODE && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            Log.d("BRPHONEDEMO", "onRequestPermissionsResult = OK");
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        int id=item.getItemId();
        if(id==R.id.itemExList){
            Intent intent = new Intent(this, ExerciseListActivity.class);
            startActivity(intent);
        }
        if(id==R.id.itemStats){
            Intent intent = new Intent(this, ProgramStatsActivity.class);
            startActivity(intent);
        }
        if(id==R.id.itemAddDay){
            Day day1 = new Day();
            week1.addDay(day1);
            weekAdapter.notifyDataSetChanged();
        }
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this,DayActivity.class);
        intent.putExtra("dayNumber", i);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}