package com.example.workout_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Edit_Beginner_Workout_DataBase extends AppCompatActivity {

    EditText WorkoutName;
    EditText WorkoutDescription;
    EditText WorkoutRepetitions;
    Button EditWorkout;
    String user_Id;
    String workout_Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_beginner_workout_data_base);

        Bundle bundle=getIntent().getExtras();
        user_Id=bundle.getString("user_Id");
        workout_Id=bundle.getString("workout_Id");
        String get_Workout_Name=bundle.getString("NameOfWorkout");
        String get_Workout_Description=bundle.getString("InformationOfWorkout");
        String get_Workout_Repetitions=bundle.getString("RepetitionOfWorkout");



        WorkoutName = findViewById(R.id.EditName);
        WorkoutDescription = findViewById(R.id.EditDescription);
        WorkoutRepetitions = findViewById(R.id.EditRepetitions);

        WorkoutName.setText(get_Workout_Name);
        WorkoutDescription.setText(get_Workout_Description);
        WorkoutRepetitions.setText(get_Workout_Repetitions);

        EditWorkout=findViewById(R.id.EditWorkout);
        EditWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Workout_DB workout=new Workout_DB(WorkoutName.getText().toString(),null,WorkoutDescription.getText().toString(), WorkoutRepetitions.getText().toString());
                WorkoutDBManager workoutDBManager=new WorkoutDBManager(getApplicationContext());
                SQLiteDatabase sqLiteDatabase=workoutDBManager.openDB();
                workoutDBManager.EditWorkout(sqLiteDatabase,workout, Integer.parseInt(user_Id), Integer.parseInt(workout_Id));

                Toast.makeText(getApplicationContext(),"Success! Please enter your credentials again to see the results",Toast.LENGTH_LONG).show();

                new Timer().schedule(new TimerTask(){
                    public void run() {
                        startActivity(new Intent(Edit_Beginner_Workout_DataBase.this, MainActivity.class));
                    }
                }, 3000 );

            }
        });



    }
}