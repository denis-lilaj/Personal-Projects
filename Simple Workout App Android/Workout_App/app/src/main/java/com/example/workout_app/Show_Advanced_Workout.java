package com.example.workout_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Show_Advanced_Workout extends AppCompatActivity {

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
        setContentView(R.layout.activity_show_advanced_workout);

        NameOfWorkout = findViewById(R.id.NameOfWorkout);
        ImageOfWorkout = findViewById(R.id.ImageOfWorkout);
        InformationOfWorkout = findViewById(R.id.InformationOfWorkout);
        RepetitionOfWorkout = findViewById(R.id.RepetitionOfWorkout);

        Bundle bundle = getIntent().getExtras();
        position = bundle.getInt("position");

        NameOfWorkoutString = Advanced_Workout_Collector.arrayList_Advanced_Workout.get(position).Name.toString();
        ImageOfWorkoutInt = Advanced_Workout_Collector.arrayList_Advanced_Workout.get(position).Image;
        InformationOfWorkoutString = Advanced_Workout_Collector.arrayList_Advanced_Workout.get(position).Information.toString();
        RepetitionOfWorkoutInt = Advanced_Workout_Collector.arrayList_Advanced_Workout.get(position).Repetitions;

        NameOfWorkout.setText(NameOfWorkoutString);
        ImageOfWorkout.setImageResource(ImageOfWorkoutInt);
        InformationOfWorkout.setText(InformationOfWorkoutString);
        RepetitionOfWorkout.setText(Integer.toString(RepetitionOfWorkoutInt));

    }
}