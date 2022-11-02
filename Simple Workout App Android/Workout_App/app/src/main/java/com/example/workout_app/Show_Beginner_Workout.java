package com.example.workout_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.jar.Attributes;

public class Show_Beginner_Workout extends AppCompatActivity {

    int position=0;

    TextView NameOfWorkout;
    ImageView ImageOfWorkout;
    TextView InformationOfWorkout;
    TextView RepetitionOfWorkout;

    String NameOfWorkoutString;
    int ImageOfWorkoutInt;
    String InformationOfWorkoutString;
    int RepetitionOfWorkoutInt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_beginner_workout);

        NameOfWorkout=findViewById(R.id.NameOfWorkout);
        ImageOfWorkout=findViewById(R.id.ImageOfWorkout);
        InformationOfWorkout=findViewById(R.id.InformationOfWorkout);
        RepetitionOfWorkout=findViewById(R.id.RepetitionOfWorkout);

        Bundle bundle=getIntent().getExtras();
        position=bundle.getInt("position");




        NameOfWorkoutString=Beginner_Workout_Collector.arrayList_Beginner_Workout.get(position).Name;
        ImageOfWorkoutInt=Beginner_Workout_Collector.arrayList_Beginner_Workout.get(position).Image;
        InformationOfWorkoutString=Beginner_Workout_Collector.arrayList_Beginner_Workout.get(position).Information.toString();
        RepetitionOfWorkoutInt=Beginner_Workout_Collector.arrayList_Beginner_Workout.get(position).Repetitions;

        NameOfWorkout.setText(NameOfWorkoutString);
        ImageOfWorkout.setImageResource(ImageOfWorkoutInt);
        InformationOfWorkout.setText(InformationOfWorkoutString);
        RepetitionOfWorkout.setText(Integer.toString(RepetitionOfWorkoutInt));


        }


    }

