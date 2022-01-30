package com.example.trainingapp.model;

import java.io.Serializable;
import java.util.Arrays;

public class ExerciseType implements Serializable {
    String name;
    String movement;
    String[] muscles;
    public static String[]  movementTypes= {"Vertical Push","Vertical Pull","Incline Push","Horizontal Push","Squat","Hip Hinge","Fly","Horizontal Pull","Biceps Iso","Triceps Iso","Quads Iso", "Hamstrings Iso","Anterior Delts Iso","Middle Delts Iso","Rear Delts Iso","Calves Iso"};

    public ExerciseType(String movement, String Name){
        this.name=Name;
        this.movement=movement;
        if(movement.equals("Vertical Push")){
            this.muscles=new String[]{"AntDelts","MidDelts","Triceps"};
        }
        if(movement.equals("Vertical Pull")){
            this.muscles=new String[]{"RearDelts","Back","Biceps"};
        }
        if(movement.equals("Incline Push")){
            this.muscles=new String[]{"AntDelts","MidDelts","Triceps","Pecs"};
        }
        if(movement.equals("Horizontal Push")){
            this.muscles=new String[]{"AntDelts","Pecs","Triceps"};
        }
        if(movement.equals("Squat")){
            this.muscles=new String[]{"Quads","Glutes"};
        }
        if(movement.equals("Hip Hinge")){
            this.muscles=new String[]{"Hamstrings","Glutes"};
        }
        if(movement.equals("Fly")){
            this.muscles=new String[]{"Pecs","AntDelts"};
        }
        if(movement.equals("Horizontal Pull")){
            this.muscles=new String[]{"Biceps","MidDelts","Back","RearDelts"};
        }
        if(movement.equals("Biceps Iso")){
            this.muscles=new String[]{"Biceps"};
        }
        if(movement.equals("Triceps Iso")){
            this.muscles=new String[]{"Triceps"};
        }
        if(movement.equals("Quads Iso")){
            this.muscles=new String[]{"Quads"};
        }
        if(movement.equals("Hamstrings Iso")){
            this.muscles=new String[]{"Hamstrings"};
        }
        if(movement.equals("Anterior Delts Iso")){
            this.muscles=new String[]{"AntDelts"};
        }
        if(movement.equals("Middle Delts Iso")){
            this.muscles=new String[]{"MidDelts"};
        }
        if(movement.equals("Rear Delts Iso")){
            this.muscles=new String[]{"RearDelts"};
        }
        if(movement.equals("Calves Iso")){
            this.muscles=new String[]{"Calves"};
        }
    }
    public static String[] getMovementTypes(){
        return movementTypes;
    }
    public String getMovement(){
        return this.movement;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
