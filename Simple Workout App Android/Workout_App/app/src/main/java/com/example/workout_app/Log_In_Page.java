package com.example.workout_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Log_In_Page extends AppCompatActivity {

    WorkoutDBManager workoutDBManager;
    SQLiteDatabase sqLiteDatabase;

    EditText userEmail;
    EditText userPassword;
    Button LogInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_page);

        workoutDBManager = new WorkoutDBManager(getApplicationContext());
        sqLiteDatabase = workoutDBManager.openDB();

        userEmail=findViewById(R.id.UserEmail);
        userPassword=findViewById(R.id.UserPassword);
        LogInButton=findViewById(R.id.LogInButton);

        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getUserEmail=userEmail.getText().toString();
                String getUserPassword=userPassword.getText().toString();
                String getTypeOfWorkout=workoutDBManager.match_credentials(sqLiteDatabase,getUserEmail,getUserPassword);
                String getUserId=workoutDBManager.get_User_Id(sqLiteDatabase,getUserEmail,getUserPassword);


                if(getTypeOfWorkout!=null && getTypeOfWorkout.equals("Beginner Workout"))
                {
                    Intent intent=new Intent(Log_In_Page.this,Beginner_Workout_Activity.class);
                    intent.putExtra("user_Id",getUserId);
                    intent.putExtra("user_Email",getUserEmail);
                    intent.putExtra("user_Password",getUserPassword);
                    startActivity(intent);
                }

                else if(getTypeOfWorkout!=null && getTypeOfWorkout.equals("Advanced Workout"))
                {
                    Intent intent=new Intent(Log_In_Page.this,Advanced_Workout_Activity.class);
                    intent.putExtra("user_Id",getUserId);
                    intent.putExtra("user_Email",getUserEmail);
                    intent.putExtra("user_Password",getUserPassword);
                    startActivity(intent);
                }

                else if(getTypeOfWorkout==null){
                    Toast.makeText(getApplicationContext(),"Invalid username or password.Try again!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}