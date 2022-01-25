package com.example.trainingapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.trainingapp.Exercise;
import com.example.trainingapp.ExerciseList;
import com.example.trainingapp.ExerciseType;
import com.example.trainingapp.R;
import com.google.gson.Gson;

import java.util.ArrayList;

public class DayActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    Button btnReturn, btnAddToDay, btnConfirmAdd;
    EditText etAddName, etAddReps, etAddSets;
    TextView tv;
    ArrayList<Exercise> dayx = new ArrayList<>();
    ExerciseList exs;
    ArrayAdapter<Exercise> dayAdapter;
    ListView day;
    Dialog d;
    Spinner spinner;
    ExerciseType selectedEx;
    ArrayAdapter<ExerciseType> spinnerAdapter;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);
        btnReturn=findViewById(R.id.btnReturnFromDayToMain);
        btnReturn.setOnClickListener(this);
        btnAddToDay=findViewById(R.id.btnAddToDay);
        btnAddToDay.setOnClickListener(this);
        tv=findViewById(R.id.dayTitleTv);
        day=findViewById(R.id.day);

        sp=getSharedPreferences("details1",0);
        Gson gson = new Gson();
        String json = sp.getString("exerciseTypeList","");
        exs=gson.fromJson(json,ExerciseList.class);

        dayAdapter = new ArrayAdapter<Exercise>(this, android.R.layout.activity_list_item, android.R.id.text1, dayx) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                Exercise ex1 = (Exercise) day.getAdapter().getItem(position);
                TextView text = view.findViewById(android.R.id.text1);
                if(!dayx.isEmpty())
                    text.setText(ex1.getName()+" Reps: "+ex1.getReps()+" Sets: "+ex1.getSets());
                return view;
            }
        };
        day.setAdapter(dayAdapter);
        day.setOnItemClickListener(this);

        spinnerAdapter = new ArrayAdapter<ExerciseType>(this, android.R.layout.simple_spinner_dropdown_item, exs.getExTypeList());
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    @Override
    public void onClick(View view){
        if(view==btnReturn){
            finish();
        }
        if(view==btnAddToDay){
            d=new Dialog(this);
            d.setContentView(R.layout.exerciseadd_dialog);
            d.setTitle("Create Exercise");
            d.setCancelable(true);
            etAddName=(EditText)d.findViewById(R.id.etExName);
            etAddReps=(EditText)d.findViewById(R.id.etAddReps);
            etAddSets=(EditText)d.findViewById(R.id.etAddSets);
            btnConfirmAdd=(Button)d.findViewById(R.id.btnConfirmAdd);
            btnConfirmAdd.setOnClickListener(this);

            spinner = (Spinner)d.findViewById(R.id.spin);
            spinner.setAdapter(spinnerAdapter);
            spinner.setOnItemSelectedListener(this);

            d.show();
        }
        if(view==btnConfirmAdd){
            Exercise ex = new Exercise(Integer.valueOf(etAddSets.getText().toString()),selectedEx, etAddReps.getText().toString());
            dayx.add(ex);
            dayAdapter.notifyDataSetChanged();
            d.dismiss();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        selectedEx = exs.getExTypeList().get(i);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        selectedEx = exs.getExTypeList().get(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}