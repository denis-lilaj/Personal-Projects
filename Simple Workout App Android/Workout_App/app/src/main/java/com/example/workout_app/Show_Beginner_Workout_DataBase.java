package com.example.workout_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;
import java.util.jar.Attributes;

public class Show_Beginner_Workout_DataBase extends AppCompatActivity {


    TextView NameOfWorkout;
    ImageView ImageOfWorkout;
    TextView InformationOfWorkout;
    TextView RepetitionOfWorkout;

    String user_Id;
    String workout_Id;
    String NameOfWorkoutString;
    byte[] UriByte;
    String InformationOfWorkoutString;
    String RepetitionOfWorkoutString;


    Button EditWorkout;
    Button DeleteWorkout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_beginner_workout_data_base);

        NameOfWorkout=findViewById(R.id.NameOfWorkout);
        ImageOfWorkout=findViewById(R.id.ImageOfWorkout);
        InformationOfWorkout=findViewById(R.id.InformationOfWorkout);
        RepetitionOfWorkout=findViewById(R.id.RepetitionOfWorkout);

        Bundle bundle=getIntent().getExtras();

        user_Id=bundle.getString("user_Id");
        workout_Id=bundle.getString("workout_Id");
        NameOfWorkoutString=bundle.getString("NameOfWorkout");
        UriByte=bundle.getByteArray("Uri");

        InformationOfWorkoutString=bundle.getString("Information");
        RepetitionOfWorkoutString=bundle.getString("Repetitions");

        NameOfWorkout.setText(NameOfWorkoutString);
        ImageOfWorkout.setImageBitmap(getImage(UriByte));
        InformationOfWorkout.setText(InformationOfWorkoutString);
        RepetitionOfWorkout.setText(RepetitionOfWorkoutString);

        EditWorkout=findViewById(R.id.EditWorkout);
        EditWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Show_Beginner_Workout_DataBase.this,Edit_Beginner_Workout_DataBase.class);
                intent.putExtra("workout_Id",workout_Id);
                intent.putExtra("user_Id",user_Id);
                intent.putExtra("NameOfWorkout",NameOfWorkoutString);
                intent.putExtra("InformationOfWorkout",InformationOfWorkoutString);
                intent.putExtra("RepetitionOfWorkout",RepetitionOfWorkoutString);
                startActivity(intent);
            }
        });

        DeleteWorkout=findViewById(R.id.DeleteWorkout);
        DeleteWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WorkoutDBManager workoutDBManager=new WorkoutDBManager(getApplicationContext());
                SQLiteDatabase sqLiteDatabase=workoutDBManager.openDB();
                workoutDBManager.DeleteWorkout(sqLiteDatabase,Integer.parseInt(user_Id),Integer.parseInt(workout_Id));

                Toast.makeText(getApplicationContext(),"Success! Please enter your credentials again to see the results",Toast.LENGTH_LONG).show();

                new Timer().schedule(new TimerTask(){
                    public void run() {
                        startActivity(new Intent(Show_Beginner_Workout_DataBase.this, MainActivity.class));
                    }
                }, 3000 );
            }
        });

    }


    public static Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }



}



