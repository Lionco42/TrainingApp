package com.example.trainingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Day> week1 = new ArrayList<>();
    ArrayAdapter<Day> weekAdapter;
    ListView week;
    int daycount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        week=findViewById(R.id.week1);
        weekAdapter = new ArrayAdapter<Day>(this, android.R.layout.activity_list_item, android.R.id.text1, week1) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                Day day = (Day) week.getAdapter().getItem(position);
                TextView text = view.findViewById(android.R.id.text1);
                text.setText(day.toString());
                return view;
            }
        };
        week.setAdapter(weekAdapter);
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
            Intent intent = new Intent(this,ExerciseList.class);
            startActivity(intent);
        }
        if(id==R.id.itemStats){
            Intent intent = new Intent(this,ProgramStats.class);
            startActivity(intent);
        }
        if(id==R.id.itemAddDay){
            Day day1 = new Day(daycount);
            daycount++;
            week1.add(day1);
            weekAdapter.notifyDataSetChanged();
        }
        return true;
    }
}