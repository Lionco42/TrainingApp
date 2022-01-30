package com.example.trainingapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
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

import com.example.trainingapp.TrainingAppController;
import com.example.trainingapp.model.Exercise;
import com.example.trainingapp.model.ExerciseList;
import com.example.trainingapp.R;
import com.example.trainingapp.model.ExerciseType;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ExerciseListActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    Button btnReturn, btnInfo, btnCreate,btnConfirm;
    Dialog d;
    EditText etExName;
    ExerciseList lst;
    SharedPreferences sp;
    Spinner spinner;
    ArrayAdapter<String> spinnerAdapter;
    ArrayAdapter<ExerciseType> exerciseTypeArrayAdapter;
    ListView exerciseListView;
    String selectedMovement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);
        btnReturn=findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(this);
        btnInfo=findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(this);
        btnCreate=findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(this);
        exerciseListView=findViewById(R.id.exerciseListView);

        sp=getSharedPreferences("details1",0);
        Gson gson = new Gson();
        String json = sp.getString("exerciseTypeList","");
        lst=gson.fromJson(json,ExerciseList.class);
        if(lst==null)
            lst=ExerciseList.sharedInstance();

        spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ExerciseType.getMovementTypes());
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        exerciseTypeArrayAdapter = new ArrayAdapter<ExerciseType>(this, android.R.layout.activity_list_item, android.R.id.text1, lst){
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            ExerciseType exType = (ExerciseType)exerciseListView.getAdapter().getItem(position);
            TextView text = view.findViewById(android.R.id.text1);
            text.setText(exType.toString()+", "+ exType.getMovement());
            return view;
        }
    };
        exerciseListView.setAdapter(exerciseTypeArrayAdapter);
        exerciseListView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==btnReturn){
            finish();
        }
        if(view==btnInfo){
            Intent intent = new Intent(this, ExerciseInfoActivity.class);
            startActivity(intent);
        }
        if(view==btnCreate){
            d=new Dialog(this);
            d.setContentView(R.layout.exercisecreate_dialog);
            d.setTitle("Create Exercise");
            d.setCancelable(true);
            etExName=(EditText)d.findViewById(R.id.etExName);
            btnConfirm=(Button)d.findViewById(R.id.btnConfirm);
            btnConfirm.setOnClickListener(this);
            spinner = (Spinner)d.findViewById(R.id.spinner);
            spinner.setAdapter(spinnerAdapter);
            spinner.setOnItemSelectedListener(this);
            d.show();
        }
        if(view==btnConfirm){
            lst.createEx(selectedMovement, etExName.getText().toString());
            sp=getSharedPreferences("details1",0);
            SharedPreferences.Editor editor=sp.edit();
            Gson gson=new Gson();
            String json = gson.toJson(lst);
            editor.putString("exerciseTypeList", json);
            editor.commit();
            exerciseTypeArrayAdapter.notifyDataSetChanged();
            d.dismiss();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        selectedMovement=ExerciseType.getMovementTypes()[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        selectedMovement=ExerciseType.getMovementTypes()[i];
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}